package actions;

import java.util.ArrayList;

import city.Map;
import clock.Schedule;
import pathFounder.BinaryMap;
import pathFounder.PathFounder;
import utils.Coordinates;

/**
 * 
 * @author matthieu
 *
 */
public class Shifting extends Actions{

	private Coordinates begin;
	private Coordinates end;
	private ArrayList<Coordinates> path;
	
	public Shifting(Schedule beginTime, Coordinates begin, Coordinates end){
		this.setBeginTime(beginTime);
		this.begin = begin;
		this.end = end;
		this.setReward(-5);
		
		path = new ArrayList<Coordinates>();
	}

	public void foundPath(Map map){
		PathFounder pfounder = new PathFounder(new BinaryMap(map));
		path = pfounder.getPath(begin, end);
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

	public ArrayList<Coordinates> getPath() {
		return path;
	}

	public void setPath(ArrayList<Coordinates> path) {
		this.path = path;
	}
	
	public String toString(){
		String str =  super.toString()+"\t["+begin.toString()+"->"+end.toString()+"]";
		str += "\t";
		for (int i = 0; i < path.size(); i++) {
			str += path.get(i).toString() + "->";
		}
		return str;
	}
}
