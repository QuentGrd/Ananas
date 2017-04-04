package autoMode;

import builders.MapBuilder;
import city.Map;

public class TestAutoMode {
	public static void main(String[] args) {
		Map map = new Map(30);
		MapBuilder mapB = new MapBuilder(map);
		mapB.initBuildings();
		
		QCharacter qcar = new QCharacter();
		QCharacterBuilder qCarBuilder = new QCharacterBuilder();
		qCarBuilder.create(qcar, map);
		
		System.out.println(qcar.getEnvironment().toString());
		
		System.out.println("\nHome : " + qcar.getHome().getAddress().toString() + "\nWork : " + qcar.getWork().getAddress().toString());
		System.out.println("money : " + qcar.getMoney().getCounter() + "\tfamily : " + qcar.getFamily().getCounter());
		
		System.out.println("\nOK.");
	}
}
