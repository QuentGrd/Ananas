package actions;

import building.Home;
import clock.Schedule;

public class Sleeping extends Occupation{
	
	private Home place;
	
	public Sleeping(Home home, Schedule duration){
		this.setDuration(duration);
		this.place = home;
	}

	public Home getPlace() {
		return place;
	}

	public void setPlace(Home place) {
		this.place = place;
	}
}
