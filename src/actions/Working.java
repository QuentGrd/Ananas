package actions;

import building.Work;
import clock.Schedule;

/**
 * 
 * @author matthieu
 *
 */
public class Working extends Occupation{

	private Work place;
	
	public Working(Work work,Schedule beginTime, Schedule duration){
		this.setBeginTime(beginTime);
		this.setDuration(duration);
		this.setFinishTime(calculFinishTime(beginTime, duration));
		this.setReward(work.getReward(0), 0);
		this.setReward(work.getReward(1), 1);
		this.setReward(work.getReward(2), 2);
		this.place = work;
	}

	public Work getPlace() {
		return place;
	}

	public void setPlace(Work place) {
		this.place = place;
	}
	
	public String toString(){
		return super.toString()+" -"+place.getName();
	}
}
