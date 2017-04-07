package character;

import building.Home;
import building.Work;
import utils.BoundedCounter;
import utils.Coordinates;

/**
 * 
 * @author Matthieu
 * @version 24012017
 */
public abstract class Character {
	
	private boolean gender;
	private int age;
	private String name;
	private String firstName;
	private Home home;
	private BoundedCounter emotion;
	private String id;
	private Boolean alive;
	
	private Coordinates position;
	
	public boolean isGender() {
		return gender;
	}
	public void setGender(boolean gender) {
		this.gender = gender;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public BoundedCounter getEmotion() {
		return emotion;
	}
	public void setEmotion(BoundedCounter emotion) {
		this.emotion = emotion;
	}
	
	public Home getHome() {
		return home;
	}

	public void setHome(Home home) {
		this.home = home;
	}

	public Coordinates getPosition() {
		return position;
	}

	public void setPosition(Coordinates position) {
		this.position = position;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Boolean getAlive() {
		return alive;
	}

	public void setAlive(Boolean alive) {
		this.alive = alive;
	}

	public String toString(){
		String str = "name : " + name + "\tfirstName : " + firstName + "\tage : " + age;
		if(gender == true)
			str += "\tgender : Male";
		else if(gender == false)
			str += "\tgender : Female" ;
		str += "\tID : " + id;
		str += "\temotion lvl : " + emotion.getCounter() + "/100 ";
		str += "\tHome : " + this.home.getAddress().toString();
		return str;
	}
}
