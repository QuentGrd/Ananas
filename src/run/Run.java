package run;

import java.util.ArrayList;
import java.util.Random;

import javax.swing.JOptionPane;

import actions.Actions;
import actions.Chilling;
import actions.Entertain;
import actions.Shifting;
import actions.Sleeping;
import actions.Working;
import builders.CityBuilder;
import character.Character;
import city.City;
import clock.Clock;
import clock.Schedule;
import gui.GUIMain;
import utils.Coordinates;

/**
 * 
 * @author matthieu
 *
 */
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
		
		while(run){
			
			initCurrentRoutine();
			runRoutine();
			lifeManagment();
			statisticManagment();
			run = !endOfTheGame();
			gui.refreshGUI(city.getPopulation(), clock);
			clock.increment();
			try{
				Thread.sleep(500);
			}catch(InterruptedException e){
				Thread.currentThread().interrupt();
				e.printStackTrace();
			}
		}
		JOptionPane jop1 = new JOptionPane();

		jop1.showMessageDialog(null, "Vous avez perdu !\nMerci d'avoir joué", "Fin du jeu", JOptionPane.INFORMATION_MESSAGE);
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
	 * this methode manage all routine features
	 */
	public void runRoutine(){
		ArrayList<Character> carList = city.getPopulation().getListCharacter();
		int carListSize = city.getPopulation().getNbOfCharacter();
		
		//System.out.println("\n");
		
		for (int i = 0; i < carListSize; i++) {
			Character car = carList.get(i);
      
			if(car.getAlive() == true){
				Actions carCurrentAction = car.getRoutine().getCurrentAction(); 
				/*if(carCurrentAction != null)
					System.out.println(car.getFirstName() + "["+ car.getEmotion().getCounter() +"] : " + carCurrentAction.getClass().getName());
				else
					System.out.println(car.getFirstName() + "["+ car.getEmotion().getCounter() +"] : " + carCurrentAction);*/
				ArrayList<Actions> carCurrentRoutine = car.getRoutine().getCurrentRoutine();
				
				//si il n'y a pas d'action courante
				if(car.getRoutine().isEmptyCurrentAction()){
					
					if(!car.getRoutine().isEmptyCurrentRoutine()){
						//si c'est l'heure on ajoute l'action de tete
						if(isPassed(clock, carCurrentRoutine.get(0).getBeginTime())){
							car.getRoutine().setCurrentAction(car.getRoutine().moveFirstCurrentRoutine());
						}
					}
				}
				//si il y a une action courante
				else{
					//actions.Shifting
					if(carCurrentAction.getClass().getName().equals("actions.Shifting")){
						Shifting shift = (Shifting) car.getRoutine().getCurrentAction();
						
						if(!shift.getPathIsFound()){
							shift.foundPath(city.getMap());
							shift.setPathIsFound(true);
						}
						
						
						//si l'action n'est pas fini
						if(!shift.getFinish()){
							moveCharacter(car, shift.getPath().get(0));
							car.getEmotion().decrement();
							shift.suppFirst();
						}
						//si l'action est fini
						else{
							shift.setFinish(false);
							shift.foundPath(city.getMap());
							if(!car.getRoutine().isEmptyCurrentRoutine())
								car.getRoutine().setCurrentAction(car.getRoutine().moveFirstCurrentRoutine());
						}
					}
					
					//actions.Chilling
					if(carCurrentAction.getClass().getName().equals("actions.Chilling")){
						Chilling chill = (Chilling) car.getRoutine().getCurrentAction();
						if(isPassed(clock, chill.getFinishTime())){
							//System.out.println(chill.getReward());
							car.getEmotion().increment((int)Math.abs(chill.getReward()));
							car.getRoutine().setCurrentAction(car.getRoutine().moveFirstCurrentRoutine());
						}
					}
					
					//actions.Entertain
					if(carCurrentAction.getClass().getName().equals("actions.Entertain")){
						Entertain enter = (Entertain) car.getRoutine().getCurrentAction();
						if(isPassed(clock, enter.getFinishTime())){
							//System.out.println(enter.getReward());
							car.getEmotion().increment((int)Math.abs(enter.getReward()));
							car.getRoutine().setCurrentAction(car.getRoutine().moveFirstCurrentRoutine());
						}
					}
					
					//actions.Sleeping
					if(carCurrentAction.getClass().getName().equals("actions.Sleeping")){
						Sleeping sleep = (Sleeping) car.getRoutine().getCurrentAction();
						if(isPassed(clock, sleep.getFinishTime())){
							//System.out.println(sleep.getReward());
							car.getEmotion().increment((int)Math.abs(sleep.getReward()));
							car.getRoutine().setCurrentAction(car.getRoutine().moveFirstCurrentRoutine());
						}
					}
					
					//actions.Working
					if(carCurrentAction.getClass().getName().equals("actions.Working")){
						Working work = (Working) car.getRoutine().getCurrentAction();
						if(isPassed(clock, work.getFinishTime())){
							//System.out.println(work.getReward());
							car.getEmotion().decrement((int)Math.abs(work.getReward()));
							car.getRoutine().setCurrentAction(car.getRoutine().moveFirstCurrentRoutine());
						}
					}
				}
			}
		}
	}
	
	/**
	 * this methode manage the life of character
	 */
	public void lifeManagment(){
		ArrayList<Character> carList = city.getPopulation().getListCharacter();
		int carListSize = city.getPopulation().getNbOfCharacter();
		
		for (int i = 0; i < carListSize; i++) {
			Character car = carList.get(i);
			 
			if(car.getAlive() == true){
				if(car.getEmotion().getCounter() == 0){
					car.setAlive(false);
				}
			}
		}
	}
	
	public void statisticManagment(){
		ArrayList<Character> carList = city.getPopulation().getListCharacter();
		int carListSize = city.getPopulation().getNbOfCharacter();
		
		for (int i = 0; i < carListSize; i++) {
			Character car = carList.get(i);
			
			//emotionhistoric
			car.getData().getEmotionHistoric().add(car.getEmotion().getCounter());
			
			//emotionhistoric Today/Yesterday
			if(equalSchedule(clock, new Schedule(0, 0))){
				car.getData().setEmotionHistoricYesterday(car.getData().getEmotionHistoricToday());
				car.getData().setEmotionHistoricToday(new ArrayList<Integer>());
			}
			else{
				car.getData().getEmotionHistoricToday().add(car.getEmotion().getCounter());
				System.out.println(car.getData().getEmotionHistoricToday().toString()+"\n"+car.getData().getEmotionHistoricYesterday().toString()+'\n');
			}
			
			//actionRepartition
			if(car.getRoutine().getCurrentAction() == null){
				car.getData().getActionRepartition().set(5, car.getData().getActionRepartition().get(5) +1);
			}
			else{
				if(car.getRoutine().getCurrentAction().getClass().getName().equals("actions.Sleeping")){
					car.getData().getActionRepartition().set(0, car.getData().getActionRepartition().get(0) +1);
				}
				else if(car.getRoutine().getCurrentAction().getClass().getName().equals("actions.Chilling")){
					car.getData().getActionRepartition().set(1, car.getData().getActionRepartition().get(1) +1);
				}
				else if(car.getRoutine().getCurrentAction().getClass().getName().equals("actions.Shifting")){
					car.getData().getActionRepartition().set(2, car.getData().getActionRepartition().get(2) +1);
				}
				else if(car.getRoutine().getCurrentAction().getClass().getName().equals("actions.Working")){
					car.getData().getActionRepartition().set(3, car.getData().getActionRepartition().get(3) +1);
				}
				else if(car.getRoutine().getCurrentAction().getClass().getName().equals("actions.Entertain")){
					car.getData().getActionRepartition().set(4, car.getData().getActionRepartition().get(4) +1);
				}
				else
					car.getData().getActionRepartition().set(5, car.getData().getActionRepartition().get(5) +1);
			}
		}
		System.out.println("----------------");
	}
	
	public Boolean endOfTheGame(){
		for (int i = 0; i < city.getPopulation().getListCharacter().size(); i++) {
			if(city.getPopulation().getListCharacter().get(i).getAlive() == true)
				return false;
		}
		return true;
	}
	
	/**
	 * this methode move all action from the dailyRoutine to the currentRoutine if it's a new day.
	 */
	public void initCurrentRoutine(){
		
		//si une nouvelle journée commence, on ajoute toute la dailyRoutine a la currentRoutine pour chaque perso
		if(equalSchedule(clock, new Schedule(0,0))){
			
			ArrayList<Character> carList = city.getPopulation().getListCharacter();
			int carListSize = city.getPopulation().getNbOfCharacter();
			
			//pour chaque personnage
			for (int i = 0; i < carListSize; i++) {
				Character car = carList.get(i);
				
				//on ajoute toute les action de la dailyRoutine
				for (int j = 0; j < car.getRoutine().getDailyRoutine().size(); j++) {
					car.getRoutine().getCurrentRoutine().add(car.getRoutine().getDailyRoutine().get(j));
				}
			}
		}
	}
	
	public Boolean equalSchedule(Clock clock, Schedule schedule){
		
		if(clock.getHours().getCounter() == schedule.getHour()){
			int min1 = clock.getMin().getCounter();
			int min2 = clock.getMin().getCounter()+1;
			int min3 = clock.getMin().getCounter()+2;
			
			if(schedule.getMinute() == min1 || schedule.getMinute() == min2 || schedule.getMinute() == min3)
				return true;
			else
				return false;
		}
		else
			return false;
	}
	
	public Boolean isPassed(Clock clock, Schedule schedule){
		
		if(clock.getHours().getCounter() >= schedule.getHour()){
			if(clock.getMin().getCounter() >= schedule.getMinute()){
				return true;
			}
			else
				return false;
		}
		else
			return false;
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
