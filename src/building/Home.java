package building;

/**
 * 
 * @author Matthieu - Quentin
 * @version 24012917
 *
 */
public class Home extends Building{
	
	private static final long serialVersionUID = -3727578556231230363L;
	
	private static final int type = 1;

	public Home(int posX, int posY, int sizeX, int sizeY, int addressX, int addressY){
		this.initPosition(posX, posY);
		this.initSize(sizeX, sizeY);
		this.initAddress(addressX, addressY);
		this.setType(type);
	}

}
