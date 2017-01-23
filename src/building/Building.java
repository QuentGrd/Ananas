package building;

import city.Infrastructure;
import utils.Coordinates;

/**
 * 
 * @author Matthieu - Quentin
 *
 */
public abstract class Building extends Infrastructure{

	private static final long serialVersionUID = -694506032732642763L;
	private double reward;
	private Coordinates address;
	
	public Coordinates getAddress(){
		return address;
	}
	
	public void setAddress(int x, int y){
		address.setX(x);
		address.setY(y);
	}
	
}
