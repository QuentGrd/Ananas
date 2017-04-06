package autoMode;

import builders.MapBuilder;
import builders.PopulationBuilder;
import builders.QCharacterBuilder;
import character.QCharacter;
import city.Map;
import city.Population;

public class TestAutoMode {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Map map = new Map(30);
		MapBuilder mapB = new MapBuilder(map);
		mapB.initBuildings();
		
		Population pop = new Population(5);
		PopulationBuilder builder = new PopulationBuilder(pop, map, true);
		pop = builder.populationCreation();
		System.out.println(pop.toString());
	}

}
