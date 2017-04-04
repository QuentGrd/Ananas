package autoMode;

import city.Map;

/**
 * 
 * @author matthieu
 *
 */
public class QPopulationBuilder {

	public QPopulationBuilder(){
		
	}
	
	public void create(QPopulation pop, Map map){
		QCharacterBuilder QcharBuild = new QCharacterBuilder();
		for (int i = 0; i < pop.getNbOfCharacter(); i++) {
			
			QCharacter qcar = new QCharacter();
			QcharBuild.create(qcar, map);
			pop.getListCharacter().add(qcar);
		}
	}
	
}
