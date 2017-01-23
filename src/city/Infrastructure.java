package city;

import utils.Coordinates;

/**
 * 
 * @author Matthieu - Quentin
 *
 */
public abstract class Infrastructure {
	
	private String name;
	private Coordinates address;
	private Coordinates position;
	private Coordinates size;
	private int nbUser;
	
	public Coordinates getPosition(){
		return position;
	}
	
	public Coordinates getSize(){
		return size;
	}
	
	public Coordinates getAddress(){
		return address;
	}
	
}
