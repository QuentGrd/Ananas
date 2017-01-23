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

import building.Home;
import utils.Coordinates;

/**
 * 
 * @author Quentin
 * @version 23012017
 */

public class Map implements Serializable{

	private static final long serialVersionUID = 1930196824142386900L;
	
	private static final String[] BUILDINGFILEMAPPING = {"Type", "PosX", "PosY", "SizeX", "SizeY", "AdressX", "AdressY"};
	
	private static final String BUILDINGPATH = ("user.dir") + "/res/buildings.csv";
	
	private static final String TYPE = "Type";
	private static final String POSX = "PosX";
	private static final String POSY = "PosY";
	private static final String SIZEX = "SizeX";
	private static final String SIZEY = "SizeY";
	private static final String ADRESSX = "AdressX";
	private static final String ADRESSY = "AdressY";
	
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
	
	/**
	 * This method initialize building object with the resource file
	 */
	public void initBuildings(){
		int i;
		FileReader fileReader;
		CSVParser reader;
		try {
			fileReader = new FileReader(new File(BUILDINGPATH));
			CSVFormat format = CSVFormat.DEFAULT.withHeader(BUILDINGFILEMAPPING);
			reader = new CSVParser(fileReader, format);
			
			ArrayList<CSVRecord> csvRecords = new ArrayList<CSVRecord>();
			csvRecords = (ArrayList<CSVRecord>) reader.getRecords();
			
			for(i=0; i<csvRecords.size(); i++){
				CSVRecord record = csvRecords.get(i);
				try{
					switch(Integer.parseInt(record.get(TYPE))){
						case 1: //Type 1 is Home
							this.addToGrid(new Home(Integer.parseInt(record.get(SIZEX)), Integer.parseInt(record.get(SIZEY)), 
									Integer.parseInt(record.get(POSX)), Integer.parseInt(record.get(POSY)), 
									Integer.parseInt(record.get(ADRESSX)), Integer.parseInt(record.get(ADRESSY))));
							break;
						case 2: //Type 2 is Work
							break;
						case 3: //Type 3 is Entertainment
							break;
						default: //Default case
							break;
					}
				} catch (PositionAlreadyTakenException pate){
					System.err.println(pate.getMessage());
				}
			}
			reader.close();
			fileReader.close();
		} catch (FileNotFoundException e) {
			System.err.println(e.getMessage());
		} catch (IOException e) {
			System.err.println(e.getMessage());
		}
	}
	
	
}
