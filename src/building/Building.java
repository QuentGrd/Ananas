package building;

import city.Infrastructure;
import utils.Coordinates;

/**
 * 
 * @author Matthieu - Quentin
 *
 */
public abstract class Building extends Infrastructure{

	private double reward;
	private Coordinates address;
	
	public Coordinates getAddress(){
		return address;
	}
	
}
