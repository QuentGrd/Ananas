package city;

import java.io.Serializable;

import utils.Coordinates;

/**
 * 
 * @author Matthieu - Quentin
 *
 */
public abstract class Infrastructure implements Serializable {
	
	private String name;
	private Coordinates position;
	private Coordinates size;
	private int nbUser;
	
	public Coordinates getPosition(){
		return position;
	}
	
	public Coordinates getSize(){
		return size;
	}
	
}
