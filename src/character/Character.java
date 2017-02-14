package character;

import building.Home;
import utils.BoundedCounter;

/**
 * 
 * @author Matthieu
 * @version 24012017
 */
public class Character {
	
	private boolean gender;
	private int age;
	private String name;
	private String firstName;
	private Home address;
	
	private BoundedCounter emotion;
	
	public Character(){

	}
	
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
	
	public Home getAddress() {
		return address;
	}

	public void setAddress(Home address) {
		this.address = address;
	}

	public String toString(){
		String str = "name : " + name + "\tfirstName : " + firstName + "\tage : " + age;
		if(gender == true)
			str += "\tgender : Male";
		else if(gender == false)
			str += "\tgender : Female" ; 
		str += "\temotion lvl : " + emotion.getCounter() + "/100 ";
		str += "\tadress : " + this.address.toString();
		return str;
	}
}
