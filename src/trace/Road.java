package trace;


/**
 * 
 * @author Matthieu - Quentin
 * @version 24012017
 *
 */
public class Road extends Trace{

	private static final long serialVersionUID = 3367578817645963315L;
	
	private static final int type = 4;
	
	public Road(int posx, int posy, int sizex, int sizey){
		this.initPosition(posx, posy);
		this.initSize(sizex, sizey);
		this.setType(type);
	}
	
}
