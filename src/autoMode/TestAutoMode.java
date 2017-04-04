package autoMode;

import builders.MapBuilder;
import city.Map;


/**
 * 
 * @author matthieu
 *
 */
public class TestAutoMode {
	public static void main(String[] args) {
		Map map = new Map(30);
		MapBuilder mapB = new MapBuilder(map);
		mapB.initBuildings();
		
//		QCharacter qcar = new QCharacter();
//		QCharacterBuilder qCarBuilder = new QCharacterBuilder();
//		qCarBuilder.create(qcar, map);
//		
//		System.out.println(qcar.getEnvironment().toString());
//		
//		System.out.println("\nHome : " + qcar.getHome().getAddress().toString() + "\nWork : " + qcar.getWork().getAddress().toString());
//		System.out.println(qcar.toString());
		
		QPopulationBuilder Qpb = new QPopulationBuilder();
		QPopulation Qp = new QPopulation(5);
		Qpb.create(Qp, map);
		
		for (int i = 0; i < Qp.getNbOfCharacter(); i++) {
			System.out.println(Qp.getListCharacter().get(i).toString());
		}
		
		System.out.println("\nOK.");
	}
}
