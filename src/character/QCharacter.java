package character;


import autoMode.Environment;
import utils.Coordinates;

/**
 * 
 * @author matthieu
 *
 */
public class QCharacter extends Character{

	private Coordinates initialPosition;
	
	private Environment environment;
	
	public QCharacter(){
		
	}
	
	public String toString(){
		return "[auto]\t" + super.toString();
	}
	
}
