package builders;

import java.util.ArrayList;

import character.Character;
import city.Map;
import city.Population;

/**
 * 
 * @author matthieu
 * @version 25012017
 */
public class PopulationBuilder {

	private Population pop;
	private Map map;
	
	public PopulationBuilder(Population pop, Map map){
		this.pop = pop;
		this.map = map;
		populationCreation(pop.getNbOfCharacter());
	}
	
	/**
	 * Creation of the population
	 * @param nbOfCharacter
	 */
	public void populationCreation(int nbOfCharacter){
		
		ArrayList<Character> list = new ArrayList<Character>();
		for(int i=0; i<pop.getNbOfCharacter(); i++){
			Character character = new Character();
			CharacterBuilder builder = new CharacterBuilder(character);
			builder.initCharacterHome(map);
			builder.initCharacterWork(map);
			builder.initCharacterID();
			builder.initRoutine();
			//builder.getCharacter().getRoutine().getCurrentAction().foundPath(map);
			list.add(builder.getCharacter());
		}
		pop.setListCharacter(list);
	}

	public Population getPop() {
		return pop;
	}
}
