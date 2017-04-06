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
