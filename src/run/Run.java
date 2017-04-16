package run;

import clock.Clock;
import clock.Schedule;

public class Run {
	
	protected boolean run;
	protected boolean play;
	protected int speed;
	protected Clock clock;
	
	public Run(){
		run = true;
		play = true;
		speed = 100;
	}

	public void switchPlayStatus(){
		if (play)
			this.play = false;
		else
			this.play = true;
	}
	
	public void switchRun(){
		if (run)
			this.run = false;
		else
			this.run = true;
	}
	
	public void setSpeed(int s){
		this.speed = s;
	}

	public boolean isPlay() {
		return this.play;
	}
	
	public Clock getClock(){
		return this.clock;
	}
	
	public Schedule getClockTime(){
		return new Schedule(clock.getHours().getCounter(), clock.getMin().getCounter());
	}
	
	public String toString(){
		return "play: " + play + "; run: " + run + "; speed: " + speed;
	}
	
}
