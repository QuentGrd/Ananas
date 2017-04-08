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
	private String id;
	private Boolean alive;
	
	/*	0:emotion	1:money		2:familly*/
	private BoundedCounter[] life;
	private int rewardPriority;
	
	private Coordinates position;
	
	public Boolean isAlive(){
		if(life[0].getCounter() > 0 && life[1].getCounter() > 0 && life[2].getCounter() > 0)
			return true;
		else 
			return false;
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

	public BoundedCounter[] getLife() {
		return life;
	}
	
	public void setLife(BoundedCounter[] life) {
		this.life = life;
	}
	
	public BoundedCounter getLife(int index) {
		if(index>=0 && index<3)
			return life[index];
		else{
			System.out.println("ERREUR D'INDEXAGE : LIFE-GET");
			return null;
		}
	}
	
	public void setLife(BoundedCounter counter, int index) {
		if(index>=0 && index<3)
			this.life[index] = counter;
		else{
			System.out.println("ERREUR D'INDEXAGE : LIFE-SET");
		}
	}
	
	public void setLife(int counter, int index) {
		if(index>=0 && index<3)
			this.life[index].setCounter(counter);
		else{
			System.out.println("ERREUR D'INDEXAGE : LIFE-SET");
		}
	}
	
	public int getRewardPriority() {
		return rewardPriority;
	}
	public void setRewardPriority(int rewardPriority) {
		this.rewardPriority = rewardPriority;
	}
	
	public String toString(){
		String str = "name : " + name + "\tfirstName : " + firstName + "\tage : " + age;
		if(gender == true)
			str += "\tgender : Male";
		else if(gender == false)
			str += "\tgender : Female" ;
		str += "\tID : " + id;
		str += "\tHome : " + this.home.getAddress().toString();
		return str;
	}
}
