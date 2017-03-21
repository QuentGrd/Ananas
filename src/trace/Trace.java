package trace;

import city.Infrastructure;


/**
 * 
 * @author Matthieu
 *
 */
public abstract class Trace extends Infrastructure{
	
	private static final long serialVersionUID = -1479848795532695053L;
	private double speed;
	private int nbUser;
	public double getSpeed() {
		return speed;
	}
	public void setSpeed(double speed) {
		this.speed = speed;
	}
	public int getNbUser() {
		return nbUser;
	}
	public void setNbUser(int nbUser) {
		this.nbUser = nbUser;
	}
}
