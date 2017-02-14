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
	
	public Entertain(Entertainment entertainment, Schedule duration){
		this.setDuration(duration);
		this.place = entertainment;
	}

	public Entertainment getPlace() {
		return place;
	}

	public void setPlace(Entertainment place) {
		this.place = place;
	}
}
