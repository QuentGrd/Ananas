package building;


/**
 * 
 * @author Matthieu - Quentin
 *
 */
public class Home extends Building{
	
	private static final long serialVersionUID = -3727578556231230363L;

	public Home(int posX, int posY, int sizeX, int sizeY, int addressX, int addressY){
		this.setPosition(posX, posY);
		this.setSize(sizeX, sizeY);
		this.setAddress(addressX, addressY);
	}

}
