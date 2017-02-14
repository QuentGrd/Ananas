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
	
	public Working(Work work, Schedule duration){
		this.setDuration(duration);
		this.place = work;
	}

	public Work getPlace() {
		return place;
	}

	public void setPlace(Work place) {
		this.place = place;
	}
}
