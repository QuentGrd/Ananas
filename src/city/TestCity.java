package city;

import builders.CityBuilder;

public class TestCity {

	public static void main(String[] args) {
		City c = new City();
		CityBuilder cityB = new CityBuilder(c);
	}

}
