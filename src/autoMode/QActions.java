package autoMode;

/**
 * 
 * @author matthieu
 *
 */
public class QActions {
	private State currentAction;
	private State nextAction;
	
	private double value;
	
	public QActions(State current, State next){
		this.currentAction = current;
		this.nextAction = next;
		
		this.value = 0;
	}

	public State getCurrentAction() {
		return currentAction;
	}

	public void setCurrentAction(State currentAction) {
		this.currentAction = currentAction;
	}

	public State getNextAction() {
		return nextAction;
	}

	public void setNextAction(State nextAction) {
		this.nextAction = nextAction;
	}

	public double getValue() {
		return value;
	}

	public void setValue(double value) {
		this.value = value;
}
}
