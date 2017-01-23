package building;

/**
 * 
 * @author Matthieu - Quentin
 *
 */
public class Entertainment extends Building{
	
	private static final int type = 3;
	
	private String timeTable;
	private double averageUsageTime;
	
	public Entertainment(int posX, int posY, int sizeX, int sizeY, int addressX, int addressY){
		this.initPosition(posX, posY);
		this.initSize(sizeX, sizeY);
		this.initAddress(addressX, addressY);
	}
}
