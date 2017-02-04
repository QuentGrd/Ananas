package building;


/**
 * 
 * @author Matthieu - Quentin
 *
 */
public class Work extends Building{
	
	private static final long serialVersionUID = 2170007801527174708L;

	private static final int type = 2;
	
	private String timeTable;
	private double averageUsageTime;
	
	public Work(int posX, int posY, int sizeX, int sizeY, int addressX, int addressY){
		this.initPosition(posX, posY);
		this.initSize(sizeX, sizeY);
		this.initAddress(addressX, addressY);
		this.setType(type);
	}
	
	public Work(){
		this.setType(type);
	}

	public String getTimeTable() {
		return timeTable;
	}

	public void setTimeTable(String timeTable) {
		this.timeTable = timeTable;
	}
	
	public String toString(){
		String str = "";
		str += super.getType() + " - Name : " + super.getName() + "\tAdress : " + super.getAddress().toString() + "\tReward : " + super.getReward();
		str += "\tTimeTable : " + this.timeTable;
		return str;
	}
}
