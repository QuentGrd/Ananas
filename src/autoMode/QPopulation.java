package autoMode;

import java.util.ArrayList;

/**
 * 
 * @author matthieu
 *
 */
public class QPopulation {

	private int nbOfCharacter;
	private ArrayList<QCharacter> listCharacter;
	
	public QPopulation(int size){
		nbOfCharacter = size;
		listCharacter = new ArrayList<QCharacter>();
	}

	public int getNbOfCharacter() {
		return nbOfCharacter;
	}

	public void setNbOfCharacter(int nbOfCharacter) {
		this.nbOfCharacter = nbOfCharacter;
	}

	public ArrayList<QCharacter> getListCharacter() {
		return listCharacter;
	}

	public void setListCharacter(ArrayList<QCharacter> listCharacter) {
		this.listCharacter = listCharacter;
	}
}
