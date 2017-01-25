package city;

import java.util.ArrayList;

import builders.PopulationBuilder;
import character.Character;

public class Population {

	private int nbOfCharacter;
	private ArrayList<Character> listCharacter;
	
	public Population(int nbOfCharacter){
		this.nbOfCharacter = nbOfCharacter;
		PopulationBuilder builder = new PopulationBuilder(this);
	}

	
	
	public int getNbOfCharacter() {
		return nbOfCharacter;
	}

	public void setNbOfCharacter(int nbOfCharacter) {
		this.nbOfCharacter = nbOfCharacter;
	}

	public ArrayList<Character> getListCharacter() {
		return listCharacter;
	}

	public void setListCharacter(ArrayList<Character> listCharacter) {
		this.listCharacter = listCharacter;
	}
	
}
