package city;

public class PositionAlreadyTakenException extends Exception{

	private static final long serialVersionUID = -7757227384166500377L;

	public PositionAlreadyTakenException(){
		super("This position is already taken!");
	}
	
}
