package builders;

import city.City;
import city.Map;
import city.Population;
import clock.Clock;

public class CityBuilder {
	
	private MapBuilder mapB;
	private PopulationBuilder popBuilder;
	
	public CityBuilder(City city){
		
		Population pop = city.getPopulation();
		pop = new Population(20);
		popBuilder = new PopulationBuilder(pop);
		System.out.println(pop.toString());
		
		Map map = city.getMap();
		map = new Map(30);
		mapB = new MapBuilder(map);
		mapB.initBuildings();
		System.out.println(map.toString());
		
		Clock clock = city.getClock();
		clock = new Clock(0, 0, 0, 1, 1, 2017);
		clock.setSpeed(1000);
		clock.run();
	}

}
