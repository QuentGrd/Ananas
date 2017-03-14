package actions;

import clock.Schedule;

/**
 * 
 * @author matthieu
 *
 */
public abstract class Occupation extends Actions{

	private Schedule duration;
	private Schedule finishTime;

	public Schedule calculFinishTime(Schedule beginTime, Schedule duration){
		Schedule result = new Schedule(beginTime.getHour(), beginTime.getMinute());
		
		int sum = result.getMinute()+duration.getMinute();
		result.setMinute(sum%60);
		if(sum>=60){
			result.setHour((result.getHour()+duration.getHour()+1)%24);
		}
		else{
			result.setHour((result.getHour()+duration.getHour())%24);
		}
		
		return result;
	}
	
	public Schedule getDuration() {
		return duration;
	}

	public void setDuration(Schedule duration) {
		this.duration = duration;
	}
	
	public Schedule getFinishTime() {
		return finishTime;
	}

	public void setFinishTime(Schedule finishTime) {
		this.finishTime = finishTime;
	}

	public String toString(){
		return super.toString() + " -"+duration;
	}
}
