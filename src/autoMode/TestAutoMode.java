package autoMode;

import builders.CharacterBuilder;
import builders.MapBuilder;
import character.Character;
import city.Map;

public class TestAutoMode {
	public static void main(String[] args) {
		Map map = new Map(30);
		MapBuilder mapB = new MapBuilder(map);
		mapB.initBuildings();
		
		Character character = new Character();
		CharacterBuilder builder = new CharacterBuilder(character);
		builder.initCharacterHome(map);
		builder.initCharacterWork(map);
		builder.initCharacterID();
		builder.initRoutine();
		
		Environment env = new Environment(map, character.getHome(), character.getWork());
		System.out.println(env.toString());
		
		System.out.println("\nHome : " + character.getHome().getAddress().toString() + "\nWork : " + character.getWork().getAddress().toString());
		
		System.out.println("\nOK.");
	}
}
