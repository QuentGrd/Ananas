package builders;

import org.apache.log4j.Logger;

import city.City;
import city.Map;
import city.Population;
import log.LoggerUtility;

public class CityBuilder {
	
	private MapBuilder mapB;
	private PopulationBuilder popBuilder;
	
	private static Logger logger = LoggerUtility.getLogger(CityBuilder.class);
	
	@SuppressWarnings("unused")
	public CityBuilder(City city, boolean autoMode, int nbCharac){
		
		Map map = city.getMap();
		map = new Map(30);
		mapB = new MapBuilder(map);
		mapB.initBuildings();
		city.setMap(map);
		
		
		Population pop = city.getPopulation();
		if(!autoMode){
			pop = new Population(nbCharac);
			popBuilder = new PopulationBuilder(pop, map, false);
			city.setPopulation(popBuilder.populationCreation());
		}
		else{
			pop = new Population(nbCharac);
			popBuilder = new PopulationBuilder(pop, map, true);
			city.setPopulation(popBuilder.populationCreation());
		}
		
		if (city != null)
			logger.info("City created");
		else
			logger.fatal("City hasn't been created");
		
	}

}
