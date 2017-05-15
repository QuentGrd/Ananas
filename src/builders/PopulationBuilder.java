package builders;

import java.util.ArrayList;

import org.apache.log4j.Logger;

import character.Character;
import character.NCharacter;
import character.QCharacter;
import city.Map;
import city.Population;
import log.LoggerUtility;

/**
 * 
 * @author matthieu
 * @version 25012017
 */
public class PopulationBuilder {

	private Population pop;
	private Map map;
	private Boolean autoMode;
	
	private static Logger logger = LoggerUtility.getLogger(PopulationBuilder.class);
	
	public PopulationBuilder(Population pop, Map map, Boolean autoMode){
		this.pop = pop;
		this.map = map;
		this.autoMode = autoMode;
	}
	
	/**
	 * Creation of the population
	 * @param nbOfCharacter
	 */
	public Population populationCreation(){
		
		ArrayList<Character> list = new ArrayList<Character>();
		if(autoMode == false){
			for(int i=0; i<pop.getNbOfCharacter(); i++){
				NCharacter character = new NCharacter();
				NCharacterBuilder builder = new NCharacterBuilder(character);
				builder.initCharacterHome(map);
				builder.initCharacterWork(map);
				builder.initCharacterID();
				builder.initRoutine();
				//builder.getCharacter().getRoutine().getCurrentAction().foundPath(map);
				list.add(builder.getCharacter());
			}
		}
		else{
			for (int i = 0; i < pop.getNbOfCharacter(); i++) {
				QCharacter character = new QCharacter();
				QCharacterBuilder builder = new QCharacterBuilder(character);
				character = builder.createCharacter();
				character = builder.initCharacterHome(map);
				character = builder.initCharacterEnvironment(map, character.getHome());
				list.add(character);
			}
		}
		pop.setListCharacter(list);
		
		if(pop != null)
			logger.info("Population created");
		else
			logger.fatal("Population hasn't been created");
		
		return pop;
	}

	public Population getPop() {
		return pop;
	}
}
