package clock;

/**
 * This class represent a clock
 * @author quentin
 * @version 19012017
 */
public class Clock extends Thread{
	private CyclicCounter sec;
	private CyclicCounter min;
	private CyclicCounter hours;
	
	private long speed;
	private boolean pause;
	
	public Clock(int hours, int min, int sec){
		this.sec = new CyclicCounter(sec, 0, 59);
		this.min = new CyclicCounter(min, 0, 59);
		this.hours = new CyclicCounter(hours, 0, 23);
		this.speed = 1000;
		this.pause = false;
	}
	
	public void increment(){
		if (sec.getCounter() == sec.getMax()){
			if(min.getCounter() == min.getMax()){
				hours.increment();
			}
			min.increment();
		}
		sec.increment();
	}

	public void run(){
		while(!pause){
			try {
				Clock.sleep(speed);
			} catch (InterruptedException e) {
				System.err.println(e.getMessage());
			}
			this.increment();
			System.out.println(this.toString());
		}
	}
	
	public CyclicCounter getSec() {
		return sec;
	}

	public void setSec(CyclicCounter sec) {
		this.sec = sec;
	}

	public CyclicCounter getMin() {
		return min;
	}

	public void setMin(CyclicCounter min) {
		this.min = min;
	}

	public CyclicCounter getHours() {
		return hours;
	}

	public void setHours(CyclicCounter hours) {
		this.hours = hours;
	}
	
	
	public long getSpeed() {
		return speed;
	}

	public void setSpeed(long speed) {
		this.speed = speed;
	}

	public boolean isPause() {
		return pause;
	}

	public void setPause(boolean pause) {
		this.pause = pause;
	}

	public String toString(){
		return hours.toString() + ":" + min.toString() + ":" + sec.toString();
	}
	
}
