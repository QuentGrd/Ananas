package actions;

import building.Work;

/**
 * 
 * @author matthieu
 *
 */
public class Working extends Occupation{

	private Work place;
	
	public Working(Work work, String duration){
		this.setDuration(duration);
		this.place = work;
	}
}
