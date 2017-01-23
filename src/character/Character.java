package character;

import java.io.FileReader;
import java.io.IOException;
import java.util.List;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;

import utils.BoundedCounter;
import utils.Coordinates;

public class Character {
	
	private boolean gender;
	private int age;
	private String name;
	private Coordinates address;
	
	private BoundedCounter emotion;
	
	public Character(){
		initCharacter();
	}
	
	public void initCharacter(){
		initID();
		initWork();
	}
	
	public void initID(){
		String[] FILE_HEADER_MAPPING = {"gender","name","firstName"};
		
		try{
			CSVFormat csvFileFormat = CSVFormat.DEFAULT.withHeader(FILE_HEADER_MAPPING);
			
			FileReader fileReader = new FileReader("characterID.csv");
			CSVParser csvFileParser = new CSVParser(fileReader, csvFileFormat);
			
			List<CSVRecord> csvRecords = csvFileParser.getRecords();
			
			
			
			
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
	
	public int getSizeCsv(String path){
		int size = 0;
		return size;
	}
}
