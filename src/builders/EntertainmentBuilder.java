package builders;

import java.io.FileReader;
import java.io.IOException;
import java.util.List;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;

import building.Entertainment;


/**
 * 
 * @author matthieu
 *
 */
public class EntertainmentBuilder {

	private static final String[] ENTERTAINMENTINFOMAPPING = {"NAME", "OPENING_TIME", "CLOSING_TIME", "DURATION", "REWARD"};
	private static final String ENTERTAINMENTINFOPATH = System.getProperty("user.dir") + "/res/entertainment.csv";
	private int currentIndiceInEntertainment;
	
	private Entertainment enter;
	
	public EntertainmentBuilder(){
		enter = new Entertainment();
	}
	
	
	public void  creatEntertainment(){
		initEntertainmentInfo(enter);
	}
	/**
	 * This methode search in entertainment.csv to initialiaze enter
	 * @param work
	 */
	public void initEntertainmentInfo(Entertainment enter){
		try{
			CSVFormat csvFileFormat = CSVFormat.DEFAULT.withHeader(ENTERTAINMENTINFOMAPPING);
			
			FileReader fileReader = new FileReader(ENTERTAINMENTINFOPATH);
			CSVParser csvFileParser = new CSVParser(fileReader, csvFileFormat);
			
			List<CSVRecord> csvRecords = csvFileParser.getRecords();
			
			//research in file
			for(int i=0; i<=currentIndiceInEntertainment; i++){
				CSVRecord record = csvRecords.get(i);
				if(i==currentIndiceInEntertainment){
					enter.setName(record.get("NAME"));
					enter.setReward(Double.parseDouble(record.get("REWARD")));
					enter.setAverageUsageTime(record.get("DURATION"));
					enter.setTimeTable(record.get("OPENING_TIME") + "/" + record.get("CLOSING_TIME"));
				}
			}
			
			currentIndiceInEntertainment ++;
			
			csvFileParser.close();
			fileReader.close();
			
		}catch(IOException e){
			e.printStackTrace();
		}
	}


	public Entertainment getEnter() {
		return enter;
	}


	public void setEnter(Entertainment enter) {
		this.enter = enter;
	}
	
	
}
