package autoMode;

import builders.CharacterBuilder;
import character.Character;
import city.Map;
import utils.BoundedCounter;

/**
 * 
 * @author matthieu
 *
 */
public class QCharacterBuilder{

	
	public QCharacterBuilder(){
		
	}
	
	public void create(QCharacter qchar, Map map){
		Character car = new Character();
		CharacterBuilder carBuild = new CharacterBuilder(car);
		carBuild.initCharacterID();
		carBuild.initCharacterHome(map);
		carBuild.initCharacterWork(map);
		car = carBuild.getCharacter();
		
		qchar.setName(car.getName());
		qchar.setFirstName(car.getFirstName());
		qchar.setAlive(true);
		qchar.setAge(car.getAge());
		qchar.setEmotion(car.getEmotion());
		qchar.setEmotionHistoric(car.getEmotionHistoric());
		qchar.setGender(car.isGender());
		qchar.setHome(car.getHome());
		qchar.setWork(car.getWork());
		qchar.setMoney(new BoundedCounter(75, 0, 100));
		qchar.setFamily(new BoundedCounter(75, 0, 100));
		qchar.setInitialPosition(qchar.getHome().getAddress());
		qchar.setEnvironment(new Environment(map, qchar.getHome(), qchar.getWork()));
	}
}
