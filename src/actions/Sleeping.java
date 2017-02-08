package actions;

import building.Home;

public class Sleeping extends Occupation{
	
	private Home place;
	
	public Sleeping(Home home, String duration){
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
