package actions;

import building.Home;

public class Chilling extends Occupation{

	private Home place;
	
	public Chilling(Home home, String duration){
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
