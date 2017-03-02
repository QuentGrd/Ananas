package run;

import java.util.ArrayList;
import java.util.Random;

import javax.swing.event.CaretListener;

import builders.CityBuilder;
import character.Character;
import city.City;
import clock.Clock;
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
				//checkRoutine();
				movePopulation();
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
		
		//pour tout les perso
		for (int i = 0; i < carList.size(); i++) {
			
			Character car = carList.get(i);
			
			//ajout de l'action de la dailyRoutine si c'est l'heure de debut
			for (int j = 0; j < car.getRoutine().getDailyRoutine().size(); j++) {
				
				int hour = car.getRoutine().getDailyRoutine().get(i).getBeginTime().getHour();
				int minute = car.getRoutine().getDailyRoutine().get(i).getBeginTime().getMinute();
				
				if(clock.getHours().getCounter() == hour && clock.getMin().getCounter() == minute){
					car.getRoutine().getCurrentRoutine().add(car.getRoutine().getDailyRoutine().get(i));
					System.out.println(car.getName() + " :\t"+car.getRoutine().getCurrentRoutine().toString());
				}
			}
		}
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
