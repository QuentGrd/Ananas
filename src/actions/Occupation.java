package actions;

import clock.Schedule;

/**
 * 
 * @author matthieu
 *
 */
public abstract class Occupation extends Actions{

	private Schedule duration;

	public Schedule getDuration() {
		return duration;
	}

	public void setDuration(Schedule duration) {
		this.duration = duration;
	}
	
	public String toString(){
		return super.toString() + " -"+duration;
	}
}
