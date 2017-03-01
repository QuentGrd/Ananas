package city;

import java.util.ArrayList;

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
	
	public Character[] getCharacterTab(){
		int i;
		Character charList[] = new Character[listCharacter.size()];
		for (i=0; i<listCharacter.size(); i++){
			charList[i] = listCharacter.get(i);
		}
		return charList;
	}
	
	public String[] transform(){
		Character[] list = this.getCharacterTab();
		String nameList[];
		nameList = new String[list.length];
		int i;
		for (i=0; i<list.length; i++){
			nameList[i] = list[i].getFirstName() + list[i].getName();
		}
		return nameList;
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
