package character;

import java.io.FileReader;
import java.io.IOException;
import java.util.List;
import java.util.Random;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;

import utils.BoundedCounter;
import utils.Coordinates;

public class Character {
	
	private boolean gender;
	private int age;
	private String name;
	private String firstName;
	private Coordinates address;
	
	private BoundedCounter emotion;
	
	public Character(){
		initCharacter();
		age = randomSelection(1, 100);
		emotion = new BoundedCounter(75, 0, 100);
	}
	
	public void initCharacter(){
		initID();
		initWork();
	}
	
	public void initID(){
		String[] FILE_HEADER_MAPPING = {"gender","firstName","name"};
		
		try{
			CSVFormat csvFileFormat = CSVFormat.DEFAULT.withHeader(FILE_HEADER_MAPPING);
			
			FileReader fileReader = new FileReader("./res/characterID.csv");
			CSVParser csvFileParser = new CSVParser(fileReader, csvFileFormat);
			
			List<CSVRecord> csvRecords = csvFileParser.getRecords();
			
			//random selection of name, first name and gender
			int randomLineForName = randomSelection(0, csvRecords.size()-1);
			int randomLineForFirstName = randomSelection(0, csvRecords.size()-1);
			
			//research in file
			for(int i=0; i<=Math.max(randomLineForFirstName, randomLineForName); i++){
				CSVRecord record = csvRecords.get(i);
				if(i==randomLineForFirstName){
					this.firstName = record.get("firstName");
					String boolGender = record.get("gender");
					if(boolGender.equals("1"))
						this.gender = true;
					if(boolGender.equals("0"))
						this.gender = false;
				}
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
	
	public void initAddress(){
		
	}
	
	public void initWork(){
		
	}
	
	public int randomSelection(int min, int max){
		int random;
		Random rand = new Random();
		
		random = rand.nextInt(max - min +1) + min;
		
		return random;
	}
	
	public String toString(){
		String str = "name : " + name + "\tfirstName : " + firstName + "\tage : " + age + "\tgender : " + gender;
		str += "\temotion lvl : " + emotion.getCounter() + "/100 ";
		return str;
	}
}
