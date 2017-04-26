package testUnit;

import builders.QCharacterBuilder;
import character.QCharacter;
import junit.framework.TestCase;

/**
 * 
 * @author matthieu
 *
 */
public class TestQCharacter extends TestCase{

	private QCharacterBuilder builder;
	private QCharacter car;
	
	public TestQCharacter(String name){
		super(name);
	}
	
	protected void setUp() throws Exception{
		super.setUp();
		car = new QCharacter();
		builder  = new QCharacterBuilder(car);
		car = builder.createCharacter();
	}
	
	protected void tearDown() throws Exception {
		super.tearDown();
		car = null;
	}
	
	public void testQCharacter(){
		assertNotNull("L'instance n'est pas créée", car);
	}
	
	public void testAlive(){
		assertTrue("Le personnage n'est pas en vie", car.getAlive());
	}
	
	public void testNbOfdeath(){
		assertEquals("Erreur dans le nombre de mort", 0, car.getNbOfDeath());
	}
	
	public void testName(){
		assertNotNull("Erreur dans l'initialisation du nom via CSV", car.getName());
	}
	
	public void testFirstname(){
		assertNotNull("Erreur dans l'initialisation du prenom via CSV", car.getFirstName());
	}
	
	public void testAge(){
		assertTrue("Erreur d'age, elle n'est pas entre 10 et 100", (10<=car.getAge() && car.getAge()<=100));
	}
}
