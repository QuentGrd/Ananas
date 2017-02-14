package city;

import java.util.ArrayList;

import builders.PopulationBuilder;
import character.Character;


/**
 * 
 * @author matthieu
 * @version 25012017
 */
public class Population {

	private int nbOfCharacter;
	private ArrayList<Character> listCharacter;
	
	public Population(int nbOfCharacter){
		this.nbOfCharacter = nbOfCharacter;
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
	
	public String toString(){
		String str = "";
		
		for(int i=0; i<nbOfCharacter; i++){
			System.out.println(listCharacter.get(i).toString());
		}
		
		return str;
	}
	
}
