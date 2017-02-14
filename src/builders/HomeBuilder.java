package builders;

import building.Building;
import building.Home;

/**
 * 
 * @author quentin
 *
 */

public class HomeBuilder {
	
private Home home;
	
	public HomeBuilder(){
	}
	
	public void creatWork(){
		home = new Home();	
		home.setMaxUser(Building.density);
	}

	public Home getHome() {
		return home;
	}

	public void setHome(Home home) {
		this.home = home;
	}

}
