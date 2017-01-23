package city;

import java.io.Serializable;

import utils.Coordinates;

/**
 * 
 * @author Matthieu - Quentin
 *
 */
public abstract class Infrastructure implements Serializable {
	
	private static final long serialVersionUID = -9013964635046940228L;
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
	
	public void setPosition(int x, int y){
		position.setX(x);
		position.setY(y);
	}
	
	public void setSize(int x, int y){
		size.setX(x);
		size.setY(y);
	}
	
}
