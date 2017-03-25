package character;

import java.util.ArrayList;

/**
 * 
 * @author matthieu
 *
 */
public class DataCharacter {

	private ArrayList<Integer> emotionHistoric;
	//0:Sleeping	1:Chilling	2:Shifting	3:working	4:Entertain	5:Nothing
	private ArrayList<Integer> actionRepartition;
	private String[] actionName = {"Sleeping","Chilling","Shifting","Working","Entertain","Other"}; 
	
	public DataCharacter(){
		this.emotionHistoric = new ArrayList<Integer>();
		initActionRepartition();
		
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
}
