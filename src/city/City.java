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
	private Population population;
	
	public City(){
	}

	public Map getMap() {
		return map;
	}

	public void setMap(Map map) {
		this.map = map;
	}

	public Clock getClock() {
		return clock;
	}

	public void setClock(Clock clock) {
		this.clock = clock;
	}

	public Population getPopulation() {
		return population;
	}

	public void setPopulation(Population population) {
		this.population = population;
	}
	
	
}
