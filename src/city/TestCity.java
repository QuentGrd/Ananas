package city;

import builders.CityBuilder;
import gui.GUIMain;

public class TestCity {

	public static void main(String[] args) {
		City c = new City();
		CityBuilder cityB = new CityBuilder(c);
		System.out.println(c.getMap().toString());
		System.out.println(c.getMap().getInfrastructure(20, 14).toString());
		System.out.println(c.getMap().getInfrastructure(6, 25).toString());
		
		GUIMain gui = new GUIMain(c.getMap());
	}

}
