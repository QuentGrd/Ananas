package actions;

import building.Work;

public class Working extends Occupation{

	private Work work;
	
	public Working(Work work, String duration){
		this.setDuration(duration);
		this.work = work;
	}
}
