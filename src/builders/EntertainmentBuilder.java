package builders;

import java.io.FileReader;
import java.io.IOException;
import java.util.List;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;

import building.Entertainment;

public class EntertainmentBuilder {

	
	
	/**
	 * This methode search in entertainment.csv to initialiaze enter
	 * @param work
	 */
	/*public void initEntertainmentInfo(Entertainment enter){
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
	}*/
}
