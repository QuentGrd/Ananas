package actions;


/**
 * 
 * @author matthieu
 *
 */
public abstract class Actions {
	
	private String beginTime;
	private double reward;
	
	public String getBeginTime() {
		return beginTime;
	}
	public void setBeginTime(String begin) {
		this.beginTime = begin;
	}
	public double getReward() {
		return reward;
	}
	public void setReward(double reward) {
		this.reward = reward;
	}
	
	
}
