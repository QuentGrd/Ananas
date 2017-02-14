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
	
	public static final int density = 1;
	
	private double reward;
	private Coordinates address;
	
	private int maxUser;
	
	public void initAddress(int x, int y){
		address = new Coordinates(x, y);
	}
	
	public Coordinates getAddress(){
		return address;
	}
	
	public void setAddress(int x, int y){
		address.setX(x);
		address.setY(y);
	}

	public double getReward() {
		return reward;
	}

	public void setReward(double reward) {
		this.reward = reward;
	}

	public int getMaxUser() {
		return maxUser;
	}

	public void setMaxUser(int maxUser) {
		this.maxUser = maxUser;
	}
	
	public boolean isFull(){
		return (this.maxUser == this.getNbUser());
	}
	
}
