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
		this.setReward(entertainment.getReward());
		this.place = entertainment;
	}

	public Entertainment getPlace() {
		return place;
	}

	public void setPlace(Entertainment place) {
		this.place = place;
	}
}
