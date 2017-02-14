package builders;

import java.io.FileReader;
import java.io.IOException;
import java.util.List;
import java.util.Random;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;

import character.Character;
import city.Map;
import utils.BoundedCounter;

public class CharacterBuilder {

	public static String[] FILE_HEADER_MAPPING_NAME = {"name"};
	public static String[] FILE_HEADER_MAPPING_FIRSTNAME = {"gender","firstName"};
	
	private Character character;
	
	public CharacterBuilder(Character character){
		this.character = character;
		initCharacter();
	}
	
	/**
	 * initialize the different component of the character by using the other methodes
	 */
	public void initCharacter(){
		initCharacterName();
		initCharacterFirstName();
		character.setAge(randomSelection(1, 100));
		character.setEmotion(new BoundedCounter(75, 0, 100));
	}
	
	/**
	 * random name initialization by reading name.csv
	 */
	public void initCharacterName(){
		
		try{
			CSVFormat csvFileFormat = CSVFormat.DEFAULT.withHeader(FILE_HEADER_MAPPING_NAME);
			
			FileReader fileReader = new FileReader("./res/name.csv");
			CSVParser csvFileParser = new CSVParser(fileReader, csvFileFormat);
			
			List<CSVRecord> csvRecords = csvFileParser.getRecords();
			
			//random selection of name, first name and gender
			int randomLineForName = randomSelection(0, csvRecords.size()-1);
			
			//research in file
			for(int i=0; i<=randomLineForName; i++){
				CSVRecord record = csvRecords.get(i);
				if(i==randomLineForName){
					character.setName(record.get("name"));
				}
			}
			
			
			
			csvFileParser.close();
			fileReader.close();
			
		}catch(IOException e){
			e.printStackTrace();
		}
	}
	
	/**
	 * random firstName and gender initialization by ready firstName.csv
	 */
	public void initCharacterFirstName(){
		
		try{
			CSVFormat csvFileFormat = CSVFormat.DEFAULT.withHeader(FILE_HEADER_MAPPING_FIRSTNAME);
			
			FileReader fileReader = new FileReader("./res/firstName.csv");
			CSVParser csvFileParser = new CSVParser(fileReader, csvFileFormat);
			
			List<CSVRecord> csvRecords = csvFileParser.getRecords();
			
			//random selection of name, first name and gender
			int randomLineForFirstName = randomSelection(0, csvRecords.size()-1);
			
			//research in file
			for(int i=0; i<=randomLineForFirstName; i++){
				CSVRecord record = csvRecords.get(i);
				if(i==randomLineForFirstName){
					character.setFirstName(record.get("firstName"));
					String boolGender = record.get("gender");
					if(boolGender.equals("1"))
						character.setGender(true);
					if(boolGender.equals("0"))
						character.setGender(false);
				}
			}
			
			csvFileParser.close();
			fileReader.close();
			
		}catch(IOException e){
			e.printStackTrace();
		}
	}
	
	/**
	 * init the character's home
	 * @param map
	 */
	public void initCharacterHome(Map map){
		int home;
		do{
			home = randomSelection(0, map.getHomeList().size());
		}while(map.getHomeList().get(home).isFull());
		character.setAddress(map.getHomeList().get(home));
		map.getHomeList().get(home).addUser();
	}
	
	/**
	 * found a random number betwin min and max
	 * @param min
	 * @param max
	 * @return random number found
	 */
	public int randomSelection(int min, int max){
		int random;
		Random rand = new Random();
		
		random = rand.nextInt(max - min +1) + min;
		
		return random;
	}

	public Character getCharacter() {
		return character;
	}
}
