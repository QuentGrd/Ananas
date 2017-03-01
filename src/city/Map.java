package city;

import java.io.Serializable;
import java.util.ArrayList;

import building.Entertainment;
import building.Home;
import building.Work;

/**
 * 
 * @author Quentin
 * @version 23012017
 */

public class Map implements Serializable{

	private static final long serialVersionUID = 1930196824142386900L;
	
	private Infrastructure[][] grid;
	private ArrayList<Home> homeList;
	private ArrayList<Work> workList;
	private ArrayList<Entertainment> entertainmentList;
	
	private int size;
	
	public Map(int size){
		this.size = size;
		grid = new Infrastructure[size][size];
		homeList = new ArrayList<Home>();
		workList = new ArrayList<Work>();
		entertainmentList = new ArrayList<Entertainment>();
	}
	
	public Infrastructure[][] getGrid() {
		return grid;
	}

	public void setGrid(Infrastructure[][] grid) {
		this.grid = grid;
	}
	
	public int getSize(){
		return size;
	}
	
	public Infrastructure getInfrastructure(int x, int y){
		return grid[x][y];
	}

	public ArrayList<Home> getHomeList() {
		return homeList;
	}

	public void setHomeList(ArrayList<Home> homeList) {
		this.homeList = homeList;
	}

	public ArrayList<Work> getWorkList() {
		return workList;
	}

	public void setWorkList(ArrayList<Work> workList) {
		this.workList = workList;
	}

	public ArrayList<Entertainment> getEntertainmentList() {
		return entertainmentList;
	}

	public void setEntertainmentList(ArrayList<Entertainment> entertainmentList) {
		this.entertainmentList = entertainmentList;
	}

	public String toString(){
		String str = "";
		int i, j;
		for (i=0; i<size; i++){
			for(j=0; j<size; j++){
				if(grid[i][j] != null){
					switch(grid[i][j].getType()){
						case 1: //Type 1 is for Home
							str += "H";
							break;
						case 2: //Type 2 is for Work
							str += "W";
							break;
						case 3: //Type 3 is for Entertainment
							str += "E";
							break;
						case 4: //Type 4 is for Road
							str += "#";
							break;
						default:
							str += " ";
							break;
					}
				}
				else
					str += ".";
			}
			str += "\n";
		}	
		return str;
	}
	
}
