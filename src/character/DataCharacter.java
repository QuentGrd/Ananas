package character;

import java.util.ArrayList;

/**
 * 
 * @author matthieu
 *
 */
public class DataCharacter {

	private ArrayList<Integer> emotionHistoric;
	
	public DataCharacter(){
		this.emotionHistoric = new ArrayList<Integer>();
	}

	public ArrayList<Integer> getEmotionHistoric() {
		return emotionHistoric;
	}

	public void setEmotionHistoric(ArrayList<Integer> emotionHistoric) {
		this.emotionHistoric = emotionHistoric;
	}
}
