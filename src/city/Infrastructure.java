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
	private int type;
	private String name;
	private Coordinates position;
	private Coordinates size;
	private int nbUser;
	
	public void initPosition(int x, int y){
		position = new Coordinates(x, y);
	}
	
	public void initSize(int x, int y){
		size = new Coordinates(x, y);
	}
	
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

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getNbUser() {
		return nbUser;
	}

	public void setNbUser(int nbUser) {
		this.nbUser = nbUser;
	}

	public int getType() {
		return type;
	}
	
}
