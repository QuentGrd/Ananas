package testUnit;

import java.util.ArrayList;
import java.util.Random;

import builders.MapBuilder;
import city.Map;
import junit.framework.TestCase;
import pathFounder.BinaryMap;
import pathFounder.PathFounder;
import utils.Coordinates;

/**
 * 
 * @author matthieu
 *
 */
public class TestAStar extends TestCase{

	private Map map;
	private BinaryMap binaryMap;
	private PathFounder pathFounder;
	
	public TestAStar(String name){
		super(name);
		map = new Map(30);
		MapBuilder mapBuild = new MapBuilder(map);
		mapBuild.initBuildings();
		
		binaryMap = new BinaryMap(map);
		pathFounder = new PathFounder(binaryMap);
	}
	
	public void testPath(){
		int houseChoise = randomSelection(1, map.getHomeList().size()-1);
		Coordinates house = map.getHomeList().get(houseChoise).getAddress();
		binaryMap.addStart(house.getX(), house.getY());
		
		int workChoise  = randomSelection(1, map.getWorkList().size()-1);
		Coordinates work = map.getWorkList().get(workChoise).getAddress();
		binaryMap.addGoal(work.getX(), work.getY());
		
		pathFounder = new PathFounder(binaryMap);
		ArrayList<Coordinates> path = pathFounder.getPath(house, work);
		
		assertNotNull("Erreur lors de la generation du chemin", path); 
	}
	
	public int randomSelection(int min, int max){
		int random;
		Random rand = new Random();
		
		random = rand.nextInt(max - min +1) + min; 
		
		return random;
	}
}
