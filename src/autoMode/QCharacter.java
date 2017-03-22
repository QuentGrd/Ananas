package autoMode;

import character.Character;
import utils.BoundedCounter;
import utils.Coordinates;

/**
 * 
 * @author matthieu
 *
 */
public class QCharacter extends Character{

	private BoundedCounter Money;
	private BoundedCounter Family;
	
	private Coordinates initialPosition;
	
	private Environment environment;
	
	public QCharacter(){
		
	}

	public BoundedCounter getMoney() {
		return Money;
	}

	public void setMoney(BoundedCounter money) {
		Money = money;
	}

	public BoundedCounter getFamily() {
		return Family;
	}

	public void setFamily(BoundedCounter family) {
		Family = family;
	}

	public Environment getEnvironment() {
		return environment;
	}

	public void setEnvironment(Environment environment) {
		this.environment = environment;
	}

	public Coordinates getInitialPosition() {
		return initialPosition;
	}

	public void setInitialPosition(Coordinates initialPosition) {
		this.initialPosition = initialPosition;
	}
}
