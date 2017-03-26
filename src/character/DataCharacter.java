package character;

import java.util.ArrayList;

/**
 * 
 * @author matthieu
 *
 */
public class DataCharacter {

	private ArrayList<Integer> emotionHistoric;
	
	private ArrayList<Integer> emotionHistoricToday;
	private ArrayList<Integer> emotionHistoricYesterday;
	
	//0:Sleeping	1:Chilling	2:Shifting	3:working	4:Entertain	5:Nothing
	private ArrayList<Integer> actionRepartition;
	private String[] actionName = {"Sleeping","Chilling","Shifting","Working","Entertain","Other"};
	
	private ArrayList<Integer> actionRepartitionToday;
	private ArrayList<Integer> actionRepartitionYesterday;
	
	
	//0:positiv	1:negativ	2:nul
	private ArrayList<Integer> rewardRepartition;
	private String[] rewardName = {"Positiv reward", "Negativ reward", "nul reward"};
	
	public DataCharacter(){
		emotionHistoric = new ArrayList<Integer>();
		emotionHistoricToday = new ArrayList<Integer>();
		emotionHistoricYesterday = new ArrayList<Integer>();
		initActionRepartition();
		initRewardRepartition();
		initActionRepartitionDaily();
	}
	
	public void initActionRepartition(){
		this.actionRepartition = new ArrayList<Integer>();
		actionRepartition.add(0);
		actionRepartition.add(0);
		actionRepartition.add(0);
		actionRepartition.add(0);
		actionRepartition.add(0);
		actionRepartition.add(0);
	}
	public void initActionRepartitionDaily(){
		this.actionRepartitionToday = new ArrayList<Integer>();
		this.actionRepartitionYesterday = new ArrayList<Integer>();
		actionRepartitionToday.add(0);
		actionRepartitionToday.add(0);
		actionRepartitionToday.add(0);
		actionRepartitionToday.add(0);
		actionRepartitionToday.add(0);
		actionRepartitionToday.add(0);
		
		actionRepartitionYesterday.add(0);
		actionRepartitionYesterday.add(0);
		actionRepartitionYesterday.add(0);
		actionRepartitionYesterday.add(0);
		actionRepartitionYesterday.add(0);
		actionRepartitionYesterday.add(0);
	}
	
	public void initRewardRepartition(){
		rewardRepartition = new ArrayList<Integer>();
		rewardRepartition.add(0);
		rewardRepartition.add(0);
		rewardRepartition.add(0);
	}

	public ArrayList<Integer> getEmotionHistoric() {
		return emotionHistoric;
	}

	public void setEmotionHistoric(ArrayList<Integer> emotionHistoric) {
		this.emotionHistoric = emotionHistoric;
	}

	public ArrayList<Integer> getActionRepartition() {
		return actionRepartition;
	}

	public void setActionRepartition(ArrayList<Integer> actionRepartition) {
		this.actionRepartition = actionRepartition;
	}

	public String getActionName(int i) {
		return actionName[i];
	}

	public ArrayList<Integer> getEmotionHistoricToday() {
		return emotionHistoricToday;
	}

	public void setEmotionHistoricToday(ArrayList<Integer> emotionHistoricToday) {
		this.emotionHistoricToday = emotionHistoricToday;
	}

	public ArrayList<Integer> getEmotionHistoricYesterday() {
		return emotionHistoricYesterday;
	}

	public void setEmotionHistoricYesterday(ArrayList<Integer> emotionHistoricYesterday) {
		this.emotionHistoricYesterday = emotionHistoricYesterday;
	}

	public ArrayList<Integer> getRewardRepartition() {
		return rewardRepartition;
	}

	public void setRewardRepartition(ArrayList<Integer> rewardRepartition) {
		this.rewardRepartition = rewardRepartition;
	}

	public String getRewardName(int i) {
		return rewardName[i];
	}

	public ArrayList<Integer> getActionRepartitionToday() {
		return actionRepartitionToday;
	}

	public void setActionRepartitionToday(ArrayList<Integer> actionRepartitionToday) {
		this.actionRepartitionToday = actionRepartitionToday;
	}

	public ArrayList<Integer> getActionRepartitionYesterday() {
		return actionRepartitionYesterday;
	}

	public void setActionRepartitionYesterday(ArrayList<Integer> actionRepartitionYesterday) {
		this.actionRepartitionYesterday = actionRepartitionYesterday;
	}
}
