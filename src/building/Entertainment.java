package building;

/**
 * 
 * @author Matthieu - Quentin
 *
 */
public class Entertainment extends Building{
	
	private static final long serialVersionUID = 8975254877371478140L;

	private static final int type = 3;
	
	private String timeTable;
	private String averageUsageTime;
	
	public Entertainment(int posX, int posY, int sizeX, int sizeY, int addressX, int addressY){
		this.initPosition(posX, posY);
		this.initSize(sizeX, sizeY);
		this.initAddress(addressX, addressY);
		this.setType(type);
	}
	
	public Entertainment(){
		this.setType(type);
	}

	public String getTimeTable() {
		return timeTable;
	}

	public void setTimeTable(String timeTable) {
		this.timeTable = timeTable;
	}

	public String getAverageUsageTime() {
		return averageUsageTime;
	}

	public void setAverageUsageTime(String averageUsageTime) {
		this.averageUsageTime = averageUsageTime;
	}
	
	public String toString(){
		String str = "";
		str += super.getType() + " - Name : " + super.getName() + "\tAdress : " + super.getAddress().toString() + "\tReward : " + super.getReward();
		str += "\tTimeTable : " + this.timeTable + "\tAverageUsageTime : " + this.averageUsageTime;
		return str;
	}
}
