package autoMode;

/**
 * 
 * @author matthieu
 *
 */
public class QActions {
	private State currentState;
	private State nextState;
	
	private double[] value;
	
	public QActions(State current, State next){
		this.currentState = current;
		this.nextState = next;
		
		this.value = new double[3];
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

	public double[] getValue() {
		return value;
	}

	public void setValue(double[] value) {
		this.value = value;
	}
	
	public double getValue(int index) {
		if(index>=0 && index<3)
			return value[index];
		else{
			System.out.println("ERREUR D'INDEXAGE : QACTIONS-GET");
			return 0;
		}
	}

	public void setValue(double reward, int index) {
		if(index>=0 && index<3)
			this.value[index] = reward;
		else{
			System.out.println("ERREUR D'INDEXAGE : QACTIONS-SET");
		}
	}
}
