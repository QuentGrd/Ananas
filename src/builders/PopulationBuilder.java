package builders;

import java.util.ArrayList;

import character.Character;
import city.Population;

/**
 * 
 * @author matthieu
 * @version 25012017
 */
public class PopulationBuilder {

	private Population pop;
	
	
	public PopulationBuilder(Population pop){
		this.pop = pop;
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
			list.add(builder.getCharacter());
		}
		pop.setListCharacter(list);
	}

	public Population getPop() {
		return pop;
	}
}
