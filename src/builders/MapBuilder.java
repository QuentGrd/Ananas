package builders;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;

import building.Entertainment;
import building.Home;
import building.Work;
import city.Infrastructure;
import city.Map;
import city.PositionAlreadyTakenException;
import trace.Road;
import utils.Coordinates;


/**
 * 
 * @author Quentin - Matthieu
 *
 */
public class MapBuilder {
	
	private static final String[] INFRAFILEMAPPING = {"Type", "PosX", "PosY", "SizeX", "SizeY", "AdressX", "AdressY"};
	private static final String INFRAPATH = System.getProperty("user.dir") + "/res/infrastructure.csv";
	
	
	private static final String TYPE = "Type";
	private static final String POSX = "PosX";
	private static final String POSY = "PosY";
	private static final String SIZEX = "SizeX";
	private static final String SIZEY = "SizeY";
	private static final String ADRESSX = "AdressX";
	private static final String ADRESSY = "AdressY";
	
	private Map map;
	
	public MapBuilder(Map map){
		this.map = map;
		//map = new Map(30);
	}
	
	/**
	 * This method add an infrastructure on the grid
	 * @param building Building to add
	 * @throws PositionAlreadyTakenException If the Building try to take an already taken place
	 */
	public void addToGrid(Infrastructure infrastructure) throws PositionAlreadyTakenException{
		Coordinates position = infrastructure.getPosition();
		Coordinates size = infrastructure.getSize();
		//System.out.println("Type: " + infrastructure.getType() + " Size: " + size.getX() + "x" + size.getY() + " / Position: " + position.getX() + ", " + position.getY());
		int i, j;
		for (i=position.getX(); i<(position.getX() + size.getX()); i++){
			for (j=position.getY(); j<(position.getY() + size.getY()); j++){
				if(map.getGrid()[i][j] == null){
					map.getGrid()[i][j] = infrastructure;
					//System.out.println("Added !");
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
		for (i=position.getX(); i<(position.getX() + size.getX()); i++){
			for (j=position.getY(); j<(position.getY() + size.getY()); j++){
				map.getGrid()[i][j] = null;
			}
		}
	}
	
	/**
	 * This method initialize infrastructure object with the resource file
	 */
	public void initBuildings(){
		int i;
		FileReader fileReader;
		CSVParser reader;
		
		WorkBuilder workBuilder = new WorkBuilder();
		EntertainmentBuilder enterBuilder = new EntertainmentBuilder();
		HomeBuilder homeBuilder = new HomeBuilder();
		
		try {
			fileReader = new FileReader(new File(INFRAPATH));
			CSVFormat format = CSVFormat.DEFAULT.withHeader(INFRAFILEMAPPING);
			reader = new CSVParser(fileReader, format);
			
			ArrayList<CSVRecord> csvRecords = new ArrayList<CSVRecord>();
			csvRecords = (ArrayList<CSVRecord>) reader.getRecords();
			
			for(i=1; i<csvRecords.size(); i++){
				CSVRecord record = csvRecords.get(i);
				
				try{
					switch(Integer.parseInt(record.get(TYPE))){
						case 1: //Type 1 is Home
							/*Home home = new Home(Integer.parseInt(record.get(POSX)), Integer.parseInt(record.get(POSY)),
									Integer.parseInt(record.get(SIZEX)), Integer.parseInt(record.get(SIZEY)),
									Integer.parseInt(record.get(ADRESSX)), Integer.parseInt(record.get(ADRESSY)));*/
							
							homeBuilder.creatWork();
							Home home = homeBuilder.getHome();
							
							home.initPosition(Integer.parseInt(record.get(POSX)), Integer.parseInt(record.get(POSY)));
							home.initSize(Integer.parseInt(record.get(SIZEX)), Integer.parseInt(record.get(SIZEY)));
							home.initAddress(Integer.parseInt(record.get(ADRESSX)), Integer.parseInt(record.get(ADRESSY)));
							map.getHomeList().add(home);
							
							this.addToGrid(home);
							break;
						case 2: //Type 2 is Work
							
							workBuilder.creatWork();
							Work work = workBuilder.getWork();
							
							work.initPosition(Integer.parseInt(record.get(POSX)), Integer.parseInt(record.get(POSY)));
							work.initSize(Integer.parseInt(record.get(SIZEX)), Integer.parseInt(record.get(SIZEY)));
							work.initAddress(Integer.parseInt(record.get(ADRESSX)), Integer.parseInt(record.get(ADRESSY)));
							map.getWorkList().add(work);
							
							this.addToGrid(work);
							break;
						case 3: //Type 3 is Entertainment
							
							enterBuilder.creatEntertainment();
							Entertainment enter = enterBuilder.getEnter();
							
							enter.initPosition(Integer.parseInt(record.get(POSX)), Integer.parseInt(record.get(POSY)));
							enter.initSize(Integer.parseInt(record.get(SIZEX)), Integer.parseInt(record.get(SIZEY)));
							enter.initAddress(Integer.parseInt(record.get(ADRESSX)), Integer.parseInt(record.get(ADRESSY)));
							
							this.addToGrid(enter);
							break;
						case 4: //Type 4 is Normal Roads
							Road road = new Road(Integer.parseInt(record.get(POSX)), Integer.parseInt(record.get(POSY)),
									Integer.parseInt(record.get(SIZEX)), Integer.parseInt(record.get(SIZEY)));
							this.addToGrid(road);
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
