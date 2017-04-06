package character;


import autoMode.Environment;
import utils.Coordinates;

/**
 * 
 * @author matthieu
 *
 */
public class QCharacter extends Character{

	private Coordinates initialPosition;
	
	private Environment environment;
	
	public QCharacter(){
		
	}
	
	public Coordinates getInitialPosition() {
		return initialPosition;
	}

	public void setInitialPosition(Coordinates initialPosition) {
		this.initialPosition = initialPosition;
	}

	public Environment getEnvironment() {
		return environment;
	}

	public void setEnvironment(Environment environment) {
		this.environment = environment;
	}

	public String toString(){
		return "[auto]\t" + super.toString() ;
	}
	
}
