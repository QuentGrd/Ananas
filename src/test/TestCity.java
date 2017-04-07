package test;

import run.NRun;

public class TestCity {

	public static void main(String[] args) {
		
		NRun run = new NRun();
		run.initialisation();
		run.run();
		
		/*<AFFICHAGE SANS MOUVEMENT>
		City city = new City();
		CityBuilder cBuilder = new CityBuilder(city);
		
		GUIMain gui = new GUIMain(city.getMap());
		gui.getGmap().refreshMap(city.getPopulation());
		*/
		
	}

}
