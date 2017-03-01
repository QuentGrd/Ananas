package building;

import clock.Schedule;

/**
 * 
 * @author Matthieu - Quentin
 *
 */
public class Work extends Building{
	
	private static final long serialVersionUID = 2170007801527174708L;

	private static final int type = 2;
	
	private Schedule openingTime;
	private Schedule closingTime;
	private Schedule averageUsageTime;
	
	public Work(int posX, int posY, int sizeX, int sizeY, int addressX, int addressY){
		this.initPosition(posX, posY);
		this.initSize(sizeX, sizeY);
		this.initAddress(addressX, addressY);
		this.setType(type);
	}
	
	public Work(){
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
