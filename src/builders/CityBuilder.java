package builders;

import city.City;
import city.Map;
import clock.Clock;

public class CityBuilder {
	
	MapBuilder mapB;
	
	public CityBuilder(City city){
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
