package building;

import utils.Coordinates;

/**
 * 
 * @author Matthieu - Quentin
 *
 */
public class Home extends Building{
	
	private static final long serialVersionUID = -3727578556231230363L;
	private final int type = 1;

	public Home(int posX, int posY, int sizeX, int sizeY, int addressX, int addressY){
		initPosition(posX, posY);
		initSize(sizeX, sizeY);
		initAddress(addressX, addressY);
	}

}
