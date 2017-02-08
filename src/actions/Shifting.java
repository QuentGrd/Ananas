package actions;

import utils.Coordinates;

/**
 * 
 * @author matthieu
 *
 */
public class Shifting extends Actions{

	private Coordinates begin;
	private Coordinates end;
	
	public Shifting(Coordinates begin, Coordinates end){
		this.begin = begin;
		this.end = end;
		this.setReward(-5);
	}

	public Coordinates getBegin() {
		return begin;
	}

	public void setBegin(Coordinates begin) {
		this.begin = begin;
	}

	public Coordinates getEnd() {
		return end;
	}

	public void setEnd(Coordinates end) {
		this.end = end;
	}
}
