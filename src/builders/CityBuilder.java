package builders;

import city.City;
import city.Map;
import city.Population;

public class CityBuilder {
	
	private MapBuilder mapB;
	private PopulationBuilder popBuilder;
	
	public CityBuilder(City city){
		
		Map map = city.getMap();
		map = new Map(30);
		mapB = new MapBuilder(map);
		mapB.initBuildings();
		city.setMap(map);
		
		Population pop = city.getPopulation();
		pop = new Population(5);
		popBuilder = new PopulationBuilder(pop, map);
		city.setPopulation(pop);
		System.out.println(pop.toString());
	}

}
