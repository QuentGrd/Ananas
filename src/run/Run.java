package run;

import java.util.ArrayList;
import java.util.Random;

import actions.Occupation;
import actions.Shifting;
import builders.CityBuilder;
import character.Character;
import city.City;
import clock.Clock;
import clock.Schedule;
import gui.GUIMain;
import utils.Coordinates;

public class Run {

	private City city;
	private GUIMain gui;
	private Clock clock;
	
	private boolean run;
	
	public Run(){
		run = true;
	}
	
	public void initialisation(){
		city = new City();
		CityBuilder cBuilder = new CityBuilder(city);
		clock = new Clock(0, 0, 1, 1, 2017);
		
		gui = new GUIMain(city.getMap(), clock, city.getPopulation());
	}
	
	public void run(){
		
		while(true){
			if(run){
				clock.increment();
				checkRoutine();
				gui.refreshGUI(city.getPopulation(), clock);
				try{
					Thread.sleep(500);
				}catch(InterruptedException e){
					Thread.currentThread().interrupt();
					e.printStackTrace();
				}
			}
		}
	}
	
	public void movePopulation(){
		ArrayList<Character> carList = city.getPopulation().getListCharacter();
		
		for (int i = 0; i < carList.size(); i++) {
			moveCharacter(carList.get(i));
		}
	}
	
	/**
	 * this metode change randomly the position of a character
	 * @param car
	 */
	public void moveCharacter(Character car){
		ArrayList<Coordinates> possibleMoves = validNeighbour(car);
		int selectedMove = randomSelection(0, possibleMoves.size()-1);
		car.setPosition(possibleMoves.get(selectedMove));
	}
	
	/**
	 * this methode check in all routine if there are a new action to do
	 */
	public void checkRoutine(){
		ArrayList<Character> carList = city.getPopulation().getListCharacter();
		System.out.println("\n");
		//pour tout les perso
		for (int i = 0; i < carList.size(); i++) {
			
			Character car = carList.get(i);
			System.out.println("\t" + car.getName() + " : " + car.getRoutine().getCurrentAction().toString());
			System.out.println("\t\t" + car.getRoutine().getCurrentRoutine().toString());
			
		
			//ajout de l'action de la dailyRoutine dans la currentRoutine si c'est l'heure de debut
			for (int j = 0; j < car.getRoutine().getDailyRoutine().size(); j++) {
				
				int hour = car.getRoutine().getDailyRoutine().get(j).getBeginTime().getHour();
				int minute = car.getRoutine().getDailyRoutine().get(j).getBeginTime().getMinute();
				
				if(clock.getHours().getCounter() == hour && clock.getMin().getCounter() == minute){
					car.getRoutine().getCurrentRoutine().add(car.getRoutine().getDailyRoutine().get(j));
				}
			}
			
			//gestion de l'action courante
			//si l'action est un deplacment
			if(car.getRoutine().getCurrentAction().getClass().getName().equals("actions.Shifting")){
				Shifting shift = (Shifting) car.getRoutine().getCurrentAction();
				//si l'action n'est pas fini
				if(!shift.getFinish()){
					moveCharacter(car, shift.getPath().get(0));
					shift.suppFirst();
				}
				//si l'action est fini
				else{
					if(car.getRoutine().getCurrentRoutine().size()>0)
						car.getRoutine().setCurrentAction(car.getRoutine().getCurrentRoutine().get(0));
				}
			}
			
		}
	}
	
	/**
	 * This methode move the caracter car to the position coordNextPosition
	 * @param car
	 * @param coordNextPoisition
	 */
	public void moveCharacter(Character car, Coordinates coordNextPoisition){
		car.setPosition(coordNextPoisition);
	}
	
	/**
	 * This methode calcul a new schedule with a begin time and a duration
	 * @param beginTime
	 * @param duration
	 * @return
	 */
	public Schedule calculFinishTime(Schedule beginTime, Schedule duration){
		Schedule result = new Schedule(beginTime.getHour(), beginTime.getMinute());
		
		int sum = result.getMinute()+duration.getMinute();
		result.setMinute(sum%60);
		if(sum>=60){
			result.setHour((result.getHour()+duration.getHour()+1)%24);
		}
		else{
			result.setHour((result.getHour()+duration.getHour())%24);
		}
		
		return result;
	}
	
	/**
	 * this methode select roads address 
	 * @param car
	 * @return
	 */
	public ArrayList<Coordinates> validNeighbour(Character car){
		int currentX = car.getPosition().getX();
		int currentY = car.getPosition().getY();
		
		ArrayList<Coordinates> valid = new ArrayList<Coordinates>();
		if(currentX+1 < city.getMap().getSize()){
			if(city.getMap().getInfrastructure(currentX+1, currentY).getType() == 4 || isAutorizedBuilding(currentX+1, currentY, car)){
				valid.add(new Coordinates(currentX+1, currentY));
			}
		}
		if(currentX-1 > 0){
			if(city.getMap().getInfrastructure(currentX-1, currentY).getType() == 4 || isAutorizedBuilding(currentX-1, currentY, car)){
				valid.add(new Coordinates(currentX-1, currentY));
			}
		}
		if(currentY+1 < city.getMap().getSize()){
			if(city.getMap().getInfrastructure(currentX, currentY+1).getType() == 4 || isAutorizedBuilding(currentX, currentY+1, car)){
				valid.add(new Coordinates(currentX, currentY+1));
			}
		}
		if(currentY-1 > 0){
			if(city.getMap().getInfrastructure(currentX, currentY-1).getType() == 4 || isAutorizedBuilding(currentX, currentY-1, car)){
				valid.add(new Coordinates(currentX, currentY-1));
			}
		}
		
		return valid;
	}
	
	public boolean isAutorizedBuilding(int x, int y, Character car){
		
		//si c'est sa maison il peut rentrer 
		if(car.getHome().getAddress().getX() == x && car.getHome().getAddress().getY() == y)
			return true;
		//si c'est son travail il peut rentrer
		if(car.getWork().getAddress().getX() == x && car.getWork().getAddress().getY() == y)
			return true;
		
		//si c'est un lieu de loisir il peut rentrer ...
		
		
		//sinon il peut pas rentrer
		return false;
	}
	
	public int randomSelection(int min, int max){
		int random;
		Random rand = new Random();
		
		random = rand.nextInt(max - min +1) + min; //<!PROBLEME MUST BE POSITIVE>
		
		return random;
	}
}
