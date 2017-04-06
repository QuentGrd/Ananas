package autoMode;

import builders.MapBuilder;
import builders.QCharacterBuilder;
import character.QCharacter;
import city.Map;

public class TestAutoMode {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Map map = new Map(30);
		MapBuilder mapB = new MapBuilder(map);
		mapB.initBuildings();
		
		QCharacter qcar = new QCharacter();
		QCharacterBuilder builder = new QCharacterBuilder(qcar);
		
		qcar = builder.createCharacter();
		qcar = builder.initCharacterHome(map);
		qcar = builder.initCharacterEnvironment(map, qcar.getHome());
		System.out.println(qcar.toString());
	}

}
