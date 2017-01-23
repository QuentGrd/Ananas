package building;

import utils.Coordinates;

/**
 * 
 * @author Matthieu - Quentin
 *
 */
public class Home extends Building{
	
	private static final long serialVersionUID = -3727578556231230363L;

	public Home(int posX, int posY, int sizeX, int sizeY, int addressX, int addressY){
		this.initPosition(posX, posY);
		this.initSize(sizeX, sizeY);
		this.initAddress(addressX, addressY);
		this.setType(1);
	}

}
