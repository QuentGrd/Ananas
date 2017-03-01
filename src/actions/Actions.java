package actions;

import clock.Schedule;

/**
 * 
 * @author matthieu
 *
 */
public abstract class Actions {
	
	private Schedule beginTime;
	private double reward;
	
	public Schedule getBeginTime() {
		return beginTime;
	}
	public void setBeginTime(Schedule begin) {
		this.beginTime = begin;
	}
	public double getReward() {
		return reward;
	}
	public void setReward(double reward) {
		this.reward = reward;
	}
	
	public String toString(){
		return "["+reward+"]"+"-"+beginTime;
	}
}
