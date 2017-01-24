package character;

import java.io.FileReader;
import java.io.IOException;
import java.util.List;
import java.util.Random;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;

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
	//private Coordinates address;
	
	private BoundedCounter emotion;
	
	public Character(){
		initCharacter();
		age = randomSelection(1, 100);
		emotion = new BoundedCounter(75, 0, 100);
	}
	/**
	 * character's data initialization
	 */
	public void initCharacter(){
		initName();
		initFirstName();
		initWork();
	}
	
	/**
	 * random name initialization by reading name.csv
	 */
	public void initName(){
		String[] FILE_HEADER_MAPPING = {"name"};
		
		try{
			CSVFormat csvFileFormat = CSVFormat.DEFAULT.withHeader(FILE_HEADER_MAPPING);
			
			FileReader fileReader = new FileReader("./res/name.csv");
			CSVParser csvFileParser = new CSVParser(fileReader, csvFileFormat);
			
			List<CSVRecord> csvRecords = csvFileParser.getRecords();
			
			//random selection of name, first name and gender
			int randomLineForName = randomSelection(0, csvRecords.size()-1);
			
			//research in file
			for(int i=0; i<=randomLineForName; i++){
				CSVRecord record = csvRecords.get(i);
				if(i==randomLineForName){
					this.name = record.get("name");
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
	public void initFirstName(){
		String[] FILE_HEADER_MAPPING = {"gender","firstName"};
		
		try{
			CSVFormat csvFileFormat = CSVFormat.DEFAULT.withHeader(FILE_HEADER_MAPPING);
			
			FileReader fileReader = new FileReader("./res/firstName.csv");
			CSVParser csvFileParser = new CSVParser(fileReader, csvFileFormat);
			
			List<CSVRecord> csvRecords = csvFileParser.getRecords();
			
			//random selection of name, first name and gender
			int randomLineForFirstName = randomSelection(0, csvRecords.size()-1);
			
			//research in file
			for(int i=0; i<=randomLineForFirstName; i++){
				CSVRecord record = csvRecords.get(i);
				if(i==randomLineForFirstName){
					this.firstName = record.get("firstName");
					String boolGender = record.get("gender");
					if(boolGender.equals("1"))
						this.gender = true;
					if(boolGender.equals("0"))
						this.gender = false;
				}
			}
			
			csvFileParser.close();
			fileReader.close();
			
		}catch(IOException e){
			e.printStackTrace();
		}
	}
	
	public void initAddress(){
		
	}
	
	public void initWork(){
		
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
	
	public String toString(){
		String str = "name : " + name + "\tfirstName : " + firstName + "\tage : " + age;
		if(gender == true)
			str += "\tgender : Male";
		else if(gender == false)
			str += "\tgender : Female" ; 
		str += "\temotion lvl : " + emotion.getCounter() + "/100 ";
		return str;
	}
}
