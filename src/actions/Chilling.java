package actions;

import building.Home;
import clock.Schedule;

public class Chilling extends Occupation{

	private Home place;
	
	public Chilling(Home home, Schedule beginTime, Schedule duration){
		this.setBeginTime(beginTime);
		this.setDuration(duration);
		this.setFinishTime(calculFinishTime(beginTime, duration));
		this.setReward(home.getReward());
		this.place = home;
	}

	public Home getPlace() {
		return place;
	}

	public void setPlace(Home place) {
		this.place = place;
	}
	
	
}
