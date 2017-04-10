package run;

import java.util.ArrayList;
import java.util.Random;

import javax.swing.JOptionPane;

import autoMode.QActions;
import autoMode.State;
import builders.CityBuilder;
import building.Home;
import character.Character;
import character.QCharacter;
import city.City;
import city.Infrastructure;
import clock.Clock;
import gui.GUIMain;
import pathFounder.BinaryMap;
import pathFounder.PathFounder;
import utils.Coordinates;

/**
 * 
 * @author matthieu
 *
 */
public class QRun {
	
	private City city;
	private GUIMain gui;
	private static Clock clock;
	private static boolean run;
	private static boolean play;
	//lowest is faster
	private int speed;
	
	private double learnFactor;
	private double discountedFactor;
	private int exploration;
	
	
	public QRun(){
		run = true;
		play = true;
		speed = 100;
		
		learnFactor = 0.5;
		discountedFactor = 0.5;
		exploration = 10;
	}
	
	public void initialisation(){
		city = new City();
		CityBuilder cBuilder = new CityBuilder(city, true);
		clock = new Clock(0, 0, 1, 1, 2017);
		
		gui = new GUIMain(city.getMap(), clock, city.getPopulation(), 1);
	}
	
	public void run(){
		
		while(run){
			if (play){
				
				for (int i = 0; i < city.getPopulation().getNbOfCharacter(); i++) {
					QActions actionChosen;
					QCharacter car = (QCharacter)city.getPopulation().getListCharacter().get(i);
					//System.out.println(car.getCurrentState().getCoord() + " - " + car.getPosition());
					if(car.getAlive() == true){
						if(clock.getMin().getCounter()%exploration == 0){
							actionChosen = randomActionChoise(car.getCurrentState().getListAction());
						}
						else{
							actionChosen = QLDecision(car);
							System.out.println(car.getRewardPriority()+" - (" + car.getNbOfDeath() +") [" + actionChosen.getValue(0)+"\t"+actionChosen.getValue(1)+"\t"+actionChosen.getValue(2)+"]");
						}
						
						//si il doit rentrer chez lui il suit un chemin
						if(car.getGoingHome() == true && car.getPath().size()>0)
							moveToHome(car, car.getPath().get(0));
						//sinon il apprend
						else
							moveAgent(actionChosen, car);
					}
				}
				System.out.println("----------");
				
				priorityManagment();
				lifeManagment();
				
				gui.refreshGUI(city.getPopulation(), clock);
				clock.increment();
			}
			try{
				Thread.sleep(speed);
			}catch(InterruptedException e){
				Thread.currentThread().interrupt();
				e.printStackTrace();
			}
		}
		JOptionPane jop1 = new JOptionPane();

		jop1.showMessageDialog(null, "Vous avez perdu !\nMerci d'avoir joué", "Fin du jeu", JOptionPane.INFORMATION_MESSAGE);
		gui.dispose();
	}
	
	/**
	 * this methode manage the life of character
	 */
	public void lifeManagment(){
		ArrayList<Character> carList = city.getPopulation().getListCharacter();
		int carListSize = city.getPopulation().getNbOfCharacter();
		
		for (int i = 0; i < carListSize; i++) {
			QCharacter car = (QCharacter) carList.get(i);
			
			//si le perso est mort
			if(car.getAlive() == false){
				car.resetLife();
				car.setAlive(true);
				
				Home newHome;
				//tirage aleatoire de sa nouvelle maison
				Random rand = new Random();
				int choise = rand.nextInt(city.getMap().getHomeList().size());
				
				newHome = city.getMap().getHomeList().get(choise);
				car.setHome(newHome);
				car.setInitialPosition(newHome.getAddress());
				car.setPosition(newHome.getAddress());
				car.setCurrentState(car.getEnvironment().getState(car.getPosition().getX(), car.getPosition().getY()));
			}
			
			//si le perso est en vie
			if(car.getAlive() == true){
				if(!car.isAlive()){
					car.setAlive(false);
					car.setNbOfDeath(car.getNbOfDeath()+1);
				}
			}
			
		}
	}
	
	/**
	 * This methode change the reward priority of the agent
	 */
	public void priorityManagment(){
		ArrayList<Character> carList = city.getPopulation().getListCharacter();
		int carListSize = city.getPopulation().getNbOfCharacter();
		
		for (int i = 0; i < carListSize; i++) {
			QCharacter car = (QCharacter) carList.get(i);
			int priority = car.choosePriority();
			
			if(priority == 2){
				//si le chemin est vide
				if(car.getPath().size() == 0){
					//soit on commence un retour à la maison
					if(car.getGoingHome() == false){
						car.setGoingHome(true);
						PathFounder pf = new PathFounder(new BinaryMap(city.getMap()));
						car.setPath(pf.getPath(car.getPosition(), car.getInitialPosition()));
					}
					//soit on fini le retour à la maison
					else{
						car.getLife(2).increment(30);
						car.setGoingHome(false);
					}
				}
			}
			else
				car.setRewardPriority(priority);
		}
	}
	
	
	/**
	 * this methode say the right action to do
	 * @return action to do
	 */
	public QActions QLDecision(QCharacter agentQL){
		QActions action;
		/*liste des actions possibles*/
		ArrayList<QActions> choiseList = agentQL.getCurrentState().getListAction();
		
		/*creation et remplissage d'une liste contenant le/les actions maximale(s)*/
		ArrayList<QActions> listMax = new ArrayList<QActions>();
		double max = choiseList.get(0).getValue(agentQL.getRewardPriority());
		for(int i=0; i<choiseList.size(); i++){
			if(choiseList.get(i).getValue(agentQL.getRewardPriority()) > max){
				listMax.clear();
				listMax.add(choiseList.get(i));
				max = choiseList.get(i).getValue(agentQL.getRewardPriority());
			}
			else if(choiseList.get(i).getValue(agentQL.getRewardPriority()) == max){
				listMax.add(choiseList.get(i));
			}
		}
		
		if(listMax.size()>1)
			action = randomActionChoise(listMax);
		else
			action = listMax.get(0);
		
		return action;
	}
	
	/**
	 * this methode choose a random action in a list of actions
	 * @param list of actions
	 * @return random action
	 */
	public QActions randomActionChoise(ArrayList<QActions> list){
		Random rand = new Random();
		int choise;
		
		choise = rand.nextInt(list.size());
		
		return list.get(choise);
	}
	
	/**
	 * This methode move the caracter car to the position coordNextPosition
	 * @param car
	 * @param coordNextPoisition
	 */
	public void moveToHome(QCharacter car, Coordinates coordNextPoisition){
		car.setPosition(coordNextPoisition);
		car.setCurrentState(car.getEnvironment().getState(coordNextPoisition.getX(), coordNextPoisition.getY()));
		car.getLife(0).decrement();
		car.getLife(1).decrement();
		car.getLife(2).decrement();
		car.getPath().remove(0);
	}
	
	/**
	 * this methode change the state of the agent using a action
	 * @param nextState
	 */
	public void moveAgent(QActions action, QCharacter agentQL){
		agentQL.setCurrentState(action.getNextState());
		agentQL.setPosition(agentQL.getCurrentState().getCoord());
		setActionQValue(action, agentQL);
		agentQL.getLife(0).decrement();
		agentQL.getLife(1).decrement();
		agentQL.getLife(2).decrement();
		
		if(!agentQL.getCurrentState().isNullReward()){
			Infrastructure infra = city.getMap().getInfrastructure(agentQL.getPosition().getX(), agentQL.getPosition().getY());
			if(infra.getType() == 3){
				agentQL.getLife(0).increment((int)agentQL.getCurrentState().getReward(0));
				agentQL.getLife(1).decrement((int)agentQL.getCurrentState().getReward(1));
				agentQL.getLife(2).increment((int)agentQL.getCurrentState().getReward(2));
			}
			else if(infra.getType() == 2){
				agentQL.getLife(0).decrement(Math.abs((int)agentQL.getCurrentState().getReward(0)));
				agentQL.getLife(1).increment(Math.abs((int)agentQL.getCurrentState().getReward(1)));
				agentQL.getLife(2).decrement(Math.abs((int)agentQL.getCurrentState().getReward(2)));
			}
			else if(infra.getType() == 1){
				agentQL.getLife(0).increment(Math.abs((int)agentQL.getCurrentState().getReward(0)));
				agentQL.getLife(1).decrement(Math.abs((int)agentQL.getCurrentState().getReward(1)));
				agentQL.getLife(2).increment(Math.abs((int)agentQL.getCurrentState().getReward(2)));
			}
		}
	}
	
	/**
	 * this methode set the value a action using the Q-learning equation
	 * @param action
	 */
	public void setActionQValue(QActions action, QCharacter character){
		
		for (int i = 0; i < 3; i++) {
			double newValue;
			
			double maxFutureQValue = maxQValue(action.getNextState(), i);
			
			int typeOfReward = i;
			
			//Q-Learning actualization
			newValue = action.getValue(typeOfReward) + learnFactor * (action.getNextState().getReward(typeOfReward) + discountedFactor * maxFutureQValue - action.getValue(typeOfReward));
			
			action.setValue(newValue, typeOfReward);
		}	
	}
	
	/**
	 * this methode found the the action with the biggest QValue of a state and return
	 * the biggest QValue
	 * @param state
	 * @return biggest QValue
	 */
	public double maxQValue(State state, int typeOfReward){
		
		double max = state.getListAction().get(0).getValue(typeOfReward);
		
		for(int i=0; i<state.getListAction().size(); i++){
			if(state.getListAction().get(i).getValue(typeOfReward) > max){
				max = state.getListAction().get(i).getValue(typeOfReward);
			}
		}
		
		return max;
	}
	
	/* Orienté poubelle ? (chercher de meilleurs solution) */
	
	public static void switchPlayStatus(){
		if (play)
			play = false;
		else
			play = true;
	}
	
	public static void switchRun(){
		if (run)
			run = false;
		else
			run = true;
	}

	public static boolean isPlay() {
		return play;
	}
	
}


