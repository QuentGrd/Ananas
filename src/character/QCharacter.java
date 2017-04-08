package character;


import autoMode.Environment;
import autoMode.State;
import utils.Coordinates;

/**
 * 
 * @author matthieu
 *
 */
public class QCharacter extends Character{

	private Coordinates initialPosition;
	private State currentState;
	private Environment environment;
	private int nbOfDeath;
	
	public QCharacter(){
		
	}
	
	/**
	 * This methode return the index of the boundedCounter with the lower value as priority
	 * @return priority
	 */
	public int choosePriority(){
		int prio = 0;
		int prioValue = this.getLife(0).getCounter();
		
		for (int i = 0; i < 3; i++) {
			if(this.getLife(i).getCounter() < prioValue){
				prio = i;
				prioValue = this.getLife(i).getCounter();
			}
		}
		return prio;
	}
	
	public void resetLife(){
		for (int i = 0; i < 3; i++) {
			this.setLife(75, i);
		}
	}
	
	public Coordinates getInitialPosition() {
		return initialPosition;
	}

	public void setInitialPosition(Coordinates initialPosition) {
		this.initialPosition = initialPosition;
	}

	public State getCurrentState() {
		return currentState;
	}

	public void setCurrentState(State currentState) {
		this.currentState = currentState;
	}

	public Environment getEnvironment() {
		return environment;
	}

	public void setEnvironment(Environment environment) {
		this.environment = environment;
	}

	public int getNbOfDeath() {
		return nbOfDeath;
	}

	public void setNbOfDeath(int nbOfDeath) {
		this.nbOfDeath = nbOfDeath;
	}

	public String toString(){
		return "[auto]\t" + super.toString() ;
	}
	
}
