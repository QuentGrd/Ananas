package city;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;

import building.Entertainment;
import building.Home;
import building.Work;
import trace.Road;
import utils.Coordinates;

/**
 * 
 * @author Quentin
 * @version 23012017
 */

public class Map implements Serializable{

	private static final long serialVersionUID = 1930196824142386900L;
	
	private Infrastructure[][] grid;
	
	private int size;
	
	public Map(int size){
		this.size = size;
		grid = new Infrastructure[size][size];
		//this.initBuildings();
		//this.initRoads();
		System.out.println(this.toString());
	}
	
	public Infrastructure[][] getGrid() {
		return grid;
	}



	public void setGrid(Infrastructure[][] grid) {
		this.grid = grid;
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
