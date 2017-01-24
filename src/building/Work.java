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
}
