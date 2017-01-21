package clock;

/**
 * This class represent a Cyclic Counter
 * @author quentin
 * @version 19012017
 */
public class CyclicCounter extends BoundedCounter{

	public CyclicCounter(int value, int min, int max) {
		super(value, min, max);
	}
	
	/**
	 * This method increment the Cyclic Counter
	 */
	public void increment(){
		if(counter == max)
			this.counter = min;
		else
			this.counter++;
	}
	
	/**
	 * This method decrement the Cyclic Counter
	 */
	public void decrement(){
		if(counter == min)
			this.counter = max;
		else
			this.counter--;
	}
	
}
