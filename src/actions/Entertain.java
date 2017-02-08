package actions;

import building.Entertainment;

/**
 * 
 * @author matthieu
 *
 */
public class Entertain extends Occupation{

	private Entertainment place;
	
	public Entertain(Entertainment entertainment, String duration){
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
