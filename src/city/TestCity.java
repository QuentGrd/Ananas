package city;

import builders.CityBuilder;
import gui.GUIMain;

public class TestCity {

	public static void main(String[] args) {
		City c = new City();
		CityBuilder cityB = new CityBuilder(c);
		
		GUIMain gui = new GUIMain(c.getMap());
	}

}
