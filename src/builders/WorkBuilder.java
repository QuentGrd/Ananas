package builders;

import java.io.FileReader;
import java.io.IOException;
import java.util.List;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;

import building.Work;
import clock.Schedule;

/**
 * 
 * @author matthieu - Quentin
 *
 */
public class WorkBuilder {
	
	private static final String[] WORKINFOMAPPING = {"NAME","OPENING_TIME","CLOSING_TIME","REWARD"};
	private static final String WORKINFOPATH = System.getProperty("user.dir") + "/res/work.csv";
	private int currentIndiceInWork;
	
	private Work work;
	
	public WorkBuilder(){
	}
	
	public void creatWork(){
		work = new Work();	
		initWorkInfo(work);
	}
	
	/**
	 * this fonction search informations in work.csv to initialize work
	 * @param work
	 */
	public void initWorkInfo(Work work){
		try{
			CSVFormat csvFileFormat = CSVFormat.DEFAULT.withHeader(WORKINFOMAPPING);
			
			FileReader fileReader = new FileReader(WORKINFOPATH);
			CSVParser csvFileParser = new CSVParser(fileReader, csvFileFormat);
			
			List<CSVRecord> csvRecords = csvFileParser.getRecords();
			
			//research in file
			for(int i=0; i<=currentIndiceInWork; i++){
				CSVRecord record = csvRecords.get(i);
				if(i==currentIndiceInWork){
					work.setName(record.get("NAME"));
					work.setReward(Double.valueOf(record.get("REWARD")));
					work.setOpeningTime(new Schedule(record.get("OPENING_TIME")));
					work.setClosingTime(new Schedule(record.get("CLOSING_TIME")));
					//work.setTimeTable(record.get("OPENING_TIME") + "/" + record.get("CLOSING_TIME"));
				}
			}
			
			currentIndiceInWork ++;
			
			csvFileParser.close();
			fileReader.close();
			
		}catch(IOException e){
			e.printStackTrace();
		}
	
	}

	public Work getWork() {
		return work;
	}

	public void setWork(Work work) {
		this.work = work;
	}
	
	
}
