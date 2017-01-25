package builders;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;

import city.Population;
import utils.BoundedCounter;
import character.Character;

/**
 * 
 * @author matthieu
 * @version 25012017
 */
public class PopulationBuilder {
	
	public static String[] FILE_HEADER_MAPPING_NAME = {"name"};
	public static String[] FILE_HEADER_MAPPING_FIRSTNAME = {"gender","firstName"};

	private Population pop;
	
	
	public PopulationBuilder(Population pop){
		this.pop = pop;
		populationCreation(pop.getNbOfCharacter());
	}
	
	/**
	 * Creation of the population
	 * @param nbOfCharacter
	 */
	public void populationCreation(int nbOfCharacter){
		
		ArrayList<Character> list = new ArrayList<Character>();
		for(int i=0; i<pop.getNbOfCharacter(); i++){
			Character character = new Character();
			initCharacter(character);
			list.add(character);
		}
		pop.setListCharacter(list);
	}
	
	public void initCharacter(Character character){
		initCharacterName(character);
		initCharacterFirstName(character);
		character.setAge(randomSelection(1, 100));
		character.setEmotion(new BoundedCounter(75, 0, 100));
	}
	
	/**
	 * random name initialization by reading name.csv
	 */
	public void initCharacterName(Character character){
		
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
	public void initCharacterFirstName(Character character){
		
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
}
