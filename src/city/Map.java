package city;

import java.io.Serializable;
import java.util.ArrayList;

import utils.Coordinates;

/**
 * 
 * @author quentin
 * @version 23012017
 */

public class Map implements Serializable{

	private static final long serialVersionUID = 1930196824142386900L;
	
	private ArrayList<Infrastructure> buildings;
	private Infrastructure[][] grid;
	
	public Map(int taille){
		grid = new Infrastructure[taille][taille];
	}
	
	/**
	 * This method add an infrastructure on the grid
	 * @param building Building to add
	 * @throws PositionAlreadyTakenException If the Building try to take an already taken place
	 */
	public void addToGrid(Infrastructure building) throws PositionAlreadyTakenException{
		Coordinates position = building.getPosition();
		Coordinates size = building.getSize();
		int i, j;
		for (i=position.getX(); i<size.getX(); i++){
			for (j=position.getY(); j<size.getY(); j++){
				if(grid[i][j] != null){
					grid[i][j] = building;
				}
				else{
					throw new PositionAlreadyTakenException();
				}
			}
		}
	}
	
	/**
	 * This method remove an infrastructure from the grid
	 * @param building Building to remove
	 */
	public void removeFromGrid(Infrastructure building){
		Coordinates position = building.getPosition();
		Coordinates size = building.getSize();
		int i, j;
		for (i=position.getX(); i<size.getX(); i++){
			for (j=position.getY(); j<size.getY(); j++){
				grid[i][j] = null;
			}
		}
	}
}
