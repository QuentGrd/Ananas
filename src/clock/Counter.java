package clock;

/**
 * This class represent a counter
 * @author quentin
 * @version 19012017
 *
 */
public class Counter {
	
	protected int counter;
	
	public Counter (int value){
		this.counter = value;
	}

	public void increment(){
		this.counter++;
	}
	
	public void decrement(){
		this.counter--;
	}

	public int getCounter() {
		return counter;
	}

	public void setCounter(int counter) {
		this.counter = counter;
	}
	
	public String toString(){
		return String.valueOf(counter);
	}
	
}
