package clock;
 
/**
 * This class is used to test the clock feature
 * @author quentin - matthieu
 * @version 22012017
 */
public class TestClock {

	public static void main(String[] args) {
		Clock c = new Clock(0, 0, 0, 1, 1, 2017);
		c.run();
	}

}
