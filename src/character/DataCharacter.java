package character;

import java.util.ArrayList;

/**
 * 
 * @author matthieu
 *
 */
public class DataCharacter {

	private ArrayList<Integer> emotionHistoric;
	private ArrayList<Integer> actionRepartition;
	
	public DataCharacter(){
		this.emotionHistoric = new ArrayList<Integer>();
		this.actionRepartition = new ArrayList<Integer>();
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
}
