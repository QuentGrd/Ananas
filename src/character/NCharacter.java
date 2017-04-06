package character;

import building.Work;

/**
 * 
 * @author matthieu
 *
 */
public class NCharacter extends Character{

	private Work work;
	private DataCharacter data;
	private Routine routine;
	
	public NCharacter(){
		
	}
	
	public Work getWork() {
		return work;
	}

	public void setWork(Work work) {
		this.work = work;
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
	
	public String toString(){
		return "[norm]\t" + super.toString() + "\tWork : " + this.work.getAddress().toString();
	}
}
