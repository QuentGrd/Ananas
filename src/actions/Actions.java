package actions;

import city.Map;
import clock.Schedule;

/**
 * 
 * @author matthieu
 *
 */
public abstract class Actions {
	
	private Schedule beginTime;
	private double[] reward = new double[3];
	
	public void foundPath(Map map){
		
	}
	
	public Schedule getBeginTime() {
		return beginTime;
	}
	public void setBeginTime(Schedule begin) {
		this.beginTime = begin;
	}
	public double[] getReward() {
		return reward;
	}
	public void setReward(double[] reward) {
		this.reward = reward;
	}
	
	public double getReward(int index) {
		if(index>=0 && index<3)
			return reward[index];
		else{
			System.out.println("ERREUR D'INDEXAGE : BUILDING-GET");
			return 0;
		}
	}

	public void setReward(double reward, int index) {
		if(index>=0 && index<3)
			this.reward[index] = reward;
		else{
			System.out.println("ERREUR D'INDEXAGE : BUILDING-SET");
		}
	}
	
	public String toString(){
		return "["+reward+"]"+"-"+beginTime;
	}
}
