package clock;

/**
 * This class represent a Bounded Counter
 * @author quentin
 * @version 19012017
 */
public class BoundedCounter extends Counter{
	
	protected int min;
	protected int max;
	
	public BoundedCounter(int value, int min, int max){
		super(value);
		this.min = min;
		this.max = max;
	}
	
	/**
	 * This method increment the bounded counter
	 */
	public void increment(){
		if (counter < max){
			this.counter++;
		}
	}
	
	/**
	 * This method decrement the bounded counter
	 */
	public void decrement(){
		if (counter > min){
			this.counter--;
		}
	}

	public int getMin() {
		return min;
	}

	public void setMin(int min) {
		this.min = min;
	}

	public int getMax() {
		return max;
	}

	public void setMax(int max) {
		this.max = max;
	}

}
