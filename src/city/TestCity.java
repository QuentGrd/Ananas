package city;

import builders.CityBuilder;
import gui.GUIMain;

public class TestCity {

	public static void main(String[] args) {
		City c = new City();
		CityBuilder cityB = new CityBuilder(c);
		System.out.println(c.getMap().toString());
		System.out.println(c.getMap().getGrid()[20][14].toString());
		
		GUIMain gui = new GUIMain(c.getMap());
	}

}
