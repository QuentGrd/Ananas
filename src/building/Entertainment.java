package building;

import clock.Schedule;

/**
 * 
 * @author Matthieu - Quentin
 *
 */
public class Entertainment extends Building{
	
	private static final long serialVersionUID = 8975254877371478140L;

	private static final int type = 3;
	
	private Schedule openingTime;
	private Schedule closingTime;
	private Schedule averageUsageTime;
	
	public Entertainment(int posX, int posY, int sizeX, int sizeY, int addressX, int addressY){
		this.initPosition(posX, posY);
		this.initSize(sizeX, sizeY);
		this.initAddress(addressX, addressY);
		this.setType(type);
	}
	
	public Entertainment(){
		this.setType(type);
	}

	public Schedule getOpeningTime() {
		return openingTime;
	}

	public void setOpeningTime(Schedule openingTime) {
		this.openingTime = openingTime;
	}

	public Schedule getClosingTime() {
		return closingTime;
	}

	public void setClosingTime(Schedule closingTime) {
		this.closingTime = closingTime;
	}

	public Schedule getAverageUsageTime() {
		return averageUsageTime;
	}

	public void setAverageUsageTime(Schedule averageUsageTime) {
		this.averageUsageTime = averageUsageTime;
	}

	@Override
	public String toString() {
		return super.toString() + "\topen : " + openingTime + " - close : " + closingTime + "\taverageUsageTime : " + averageUsageTime;
	}
}
