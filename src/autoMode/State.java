package autoMode;

import java.util.ArrayList;

import city.Infrastructure;
import utils.Coordinates;

/**
 * 
 * @author matthieu
 *
 */
public class State {
	
	private double reward;
	private Coordinates coord;
	
	private Infrastructure infrastructure;
	
	/**
	 * 1 : obstacle
	 * 0 : runnable
	 */
	private int type;
	
	private ArrayList<QActions> listAction;
	
	private double QValueAverage;
	
	public State(int x, int y){
		this.reward = 0;
		coord = new Coordinates(x, y);
		type = 1;
	}

	public double getReward() {
		return reward;
	}

	public void setReward(double reward) {
		this.reward = reward;
	}

	public Coordinates getCoord() {
		return coord;
	}

	public void setCoord(Coordinates coord) {
		this.coord = coord;
	}

	public Infrastructure getInfrastructure() {
		return infrastructure;
	}

	public void setInfrastructure(Infrastructure infrastructure) {
		this.infrastructure = infrastructure;
	}

	public ArrayList<QActions> getListAction() {
		return listAction;
	}

	public void setListAction(ArrayList<QActions> listAction) {
		this.listAction = listAction;
	}

	public double getQValueAverage() {
		return QValueAverage;
	}

	public void setQValueAverage(double qValueAverage) {
		QValueAverage = qValueAverage;
	}

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}
}
