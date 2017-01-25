package city;

import clock.Clock;

/**
 * This class represent the city of the game (contain the clock, the map and the population)
 * @author quentin
 * @version 25012017
 *
 */

public class City {
	
	private Map map;
	private Clock clock;
	
	public City(int size){
		clock = new Clock(0, 0, 0, 1, 1, 2017);
		map = new Map(size);
		clock.setSpeed(1000);
		clock.run();
	}
}
