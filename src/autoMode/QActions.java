package autoMode;

/**
 * 
 * @author matthieu
 *
 */
public class QActions {
	private State currentState;
	private State nextState;
	
	private double value;
	
	public QActions(State current, State next){
		this.currentState = current;
		this.nextState = next;
		
		this.value = 0;
	}

	public State getCurrentState() {
		return currentState;
	}

	public void setCurrentState(State currentState) {
		this.currentState = currentState;
	}

	public State getNextState() {
		return nextState;
	}

	public void setNextState(State nextState) {
		this.nextState = nextState;
	}

	public double getValue() {
		return value;
	}

	public void setValue(double value) {
		this.value = value;
}
}
