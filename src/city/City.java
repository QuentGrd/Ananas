package city;

/**
 * This class represent the city of the game (contain the map and the population)
 * @author quentin
 * @version 25012017
 *
 */

public class City {
	
	private Map map;
	
	public City(int size){
		map = new Map(size);
	}
}
