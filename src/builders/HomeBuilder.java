package builders;

import org.apache.log4j.Logger;

import building.Building;
import building.Home;
import log.LoggerUtility;

/**
 * 
 * @author quentin
 *
 */

public class HomeBuilder {
	
private Home home;
private static Logger logger = LoggerUtility.getLogger(HomeBuilder.class);
	
	public HomeBuilder(){
	}
	
	public void creatWork(){
		home = new Home();	
		home.setReward(new double[3]);
		home.setReward(10, 0);
		home.setReward(0, 1);
		home.setReward(30, 0);
		home.setMaxUser(Building.density);
		logger.info("Home created");
	}

	public Home getHome() {
		return home;
	}

	public void setHome(Home home) {
		this.home = home;
	}

}
