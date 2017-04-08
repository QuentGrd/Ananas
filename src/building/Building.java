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
	
	/*	0:EMOTION	1:MONEY		2:FAMILY*/
	private double[] reward;
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

	public double[] getReward() {
		return reward;
	}

	public void setReward(double[] reward) {
		this.reward = reward;
	}
	
	public double getReward(int index) {
		if(index>=0 && index<3)
			return reward[index];
		else{
			System.out.println("ERREUR D'INDEXAGE : BUILDING-GET");
			return 0;
		}
	}

	public void setReward(double reward, int index) {
		if(index>=0 && index<3)
			this.reward[index] = reward;
		else{
			System.out.println("ERREUR D'INDEXAGE : BUILDING-SET");
		}
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
	
	public String toString(){
		return super.toString() + "\t(" + address.toString() +")";
	}
	
}
