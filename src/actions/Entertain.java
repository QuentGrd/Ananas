package actions;

import building.Entertainment;
import clock.Schedule;

/**
 * 
 * @author matthieu
 *
 */
public class Entertain extends Occupation{

	private Entertainment place;
	
	public Entertain(Entertainment entertainment, Schedule beginTime, Schedule duration){
		this.setBeginTime(beginTime);
		this.setDuration(duration);
		this.setFinishTime(calculFinishTime(beginTime, duration));
		this.setReward(entertainment.getReward(0), 0);
		this.setReward(entertainment.getReward(1), 1);
		this.setReward(entertainment.getReward(2), 2);
		this.place = entertainment;
	}

	public Entertainment getPlace() {
		return place;
	}

	public void setPlace(Entertainment place) {
		this.place = place;
	}
}
