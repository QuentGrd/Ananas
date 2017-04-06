package character;


/**
 * 
 * @author matthieu
 *
 */
public class NCharacter extends Character{

	private DataCharacter data;
	private Routine routine;
	
	public NCharacter(){
		
	}

	public DataCharacter getData() {
		return data;
	}

	public void setData(DataCharacter data) {
		this.data = data;
	}

	public Routine getRoutine() {
		return routine;
	}

	public void setRoutine(Routine routine) {
		this.routine = routine;
	}
}
