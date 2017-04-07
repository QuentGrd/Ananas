package builders;

import city.City;
import city.Map;
import city.Population;

public class CityBuilder {
	
	private MapBuilder mapB;
	private PopulationBuilder popBuilder;
	
	public CityBuilder(City city, Boolean autoMode){
		
		Map map = city.getMap();
		map = new Map(30);
		mapB = new MapBuilder(map);
		mapB.initBuildings();
		city.setMap(map);
		
		
		Population pop = city.getPopulation();
		if(!autoMode){
			pop = new Population(5);
			popBuilder = new PopulationBuilder(pop, map, false);
			city.setPopulation(popBuilder.populationCreation());
		}
		else{
			pop = new Population(5);
			popBuilder = new PopulationBuilder(pop, map, true);
			city.setPopulation(popBuilder.populationCreation());
		}
		System.out.println(pop.toString());
		
	}

}
