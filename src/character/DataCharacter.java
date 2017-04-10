package character;

import java.util.ArrayList;

/**
 * 
 * @author matthieu
 *
 */
public class DataCharacter {

	private String[] rewardType = {"Emotion", "Money", "Tiredness"};
	private ArrayList<ArrayList<Integer>> emotionHistoric;
	
	private ArrayList<ArrayList<Integer>> emotionHistoricToday;
	private ArrayList<ArrayList<Integer>> emotionHistoricYesterday;
	
	//0:Sleeping	1:Chilling	2:Shifting	3:working	4:Entertain	5:Nothing
	private ArrayList<Integer> actionRepartition;
	private String[] actionName = {"Sleeping","Chilling","Shifting","Working","Entertain","Other"};
	
	private ArrayList<Integer> actionRepartitionToday;
	private ArrayList<Integer> actionRepartitionYesterday;
	
	
	//0:positiv	1:negativ	2:nul
	private ArrayList<Integer> rewardRepartition;
	private String[] rewardName = {"Positiv reward", "Negativ reward", "nul reward"};
	
	public DataCharacter(){
		initRewardEvolution();
		initActionRepartition();
		initRewardRepartition();
		initActionRepartitionDaily();
	}
	
	public void initRewardEvolution(){
		emotionHistoric = new ArrayList<ArrayList<Integer>>();
		emotionHistoricToday = new ArrayList<ArrayList<Integer>>();
		emotionHistoricYesterday = new ArrayList<ArrayList<Integer>>();
		for (int i = 0; i < 3; i++) {
			emotionHistoric.add(new ArrayList<Integer>());
			emotionHistoricToday.add(new ArrayList<Integer>());
			emotionHistoricYesterday.add(new ArrayList<Integer>());
		}
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
	
	public void resetEmotionHistoricToday(){
		emotionHistoricToday = new ArrayList<ArrayList<Integer>>();
		for (int i = 0; i < 3; i++) {
			emotionHistoricToday.add(new ArrayList<Integer>());
		}
	}

	
	public String[] getRewardType() {
		return rewardType;
	}
	
	public String getRewardType(int index) {
		if(0<=index && index<3)
			return rewardType[index];
		else
			return "###ERREUR###";
	}

	public ArrayList<Integer> getActionRepartition() {
		return actionRepartition;
	}

	public void setActionRepartition(ArrayList<Integer> actionRepartition) {
		this.actionRepartition = actionRepartition;
	}

	public ArrayList<ArrayList<Integer>> getEmotionHistoric() {
		return emotionHistoric;
	}
	
	public ArrayList<Integer> getEmotionHistoric(int index){
		return emotionHistoric.get(index);
	}

	public void setEmotionHistoric(ArrayList<ArrayList<Integer>> emotionHistoric) {
		this.emotionHistoric = emotionHistoric;
	}

	public ArrayList<ArrayList<Integer>> getEmotionHistoricToday() {
		return emotionHistoricToday;
	}
	
	public ArrayList<Integer> getEmotionHistoricToday(int index){
		if(index>=0 && index <3)
			return emotionHistoricToday.get(index);
		else {
			System.out.println("COUCOU");
			return null;
		}
	}

	public void setEmotionHistoricToday(ArrayList<ArrayList<Integer>> emotionHistoricToday) {
		this.emotionHistoricToday = emotionHistoricToday;
	}

	public ArrayList<ArrayList<Integer>> getEmotionHistoricYesterday() {
		return emotionHistoricYesterday;
	}
	
	public ArrayList<Integer> getEmotionHistoricYesterday(int index){
		return emotionHistoricYesterday.get(index);
	}

	public void setEmotionHistoricYesterday(ArrayList<ArrayList<Integer>> emotionHistoricYesterday) {
		this.emotionHistoricYesterday = emotionHistoricYesterday;
	}

	public String getActionName(int i) {
		return actionName[i];
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
