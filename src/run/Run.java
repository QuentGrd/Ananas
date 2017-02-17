package run;

import java.util.ArrayList;
import java.util.Random;

import builders.CityBuilder;
import character.Character;
import city.City;
import gui.GUIMain;
import utils.Coordinates;

public class Run {

	private City city;
	
	private GUIMain gui;
	
	public Run(){
		
	}
	
	public void initialisation(){
		city = new City();
		CityBuilder cBuilder = new CityBuilder(city);
		
		gui = new GUIMain(city.getMap());
	}
	
	public void run(){
		
		while(true){
			movePopulation();
			gui.getGmap().refreshMap(city.getPopulation());
			try{
				Thread.sleep(500);
			}catch(InterruptedException e){
				Thread.currentThread().interrupt();
				e.printStackTrace();
			}
		}
	}
	
	public void movePopulation(){
		ArrayList<Character> carList = city.getPopulation().getListCharacter();
		
		for (int i = 0; i < carList.size(); i++) {
			moveCharacter(carList.get(i));
		}
	}
	
	/**
	 * this metode change randomly the position of a character
	 * @param car
	 */
	public void moveCharacter(Character car){
		ArrayList<Coordinates> possibleMoves = validNeighbour(car);
		int selectedMove = randomSelection(0, possibleMoves.size()-1);
		car.setPosition(possibleMoves.get(selectedMove));
	}
	
	/**
	 * this methode select roads address 
	 * @param car
	 * @return
	 */
	public ArrayList<Coordinates> validNeighbour(Character car){
		int currentX = car.getPosition().getX();
		int currentY = car.getPosition().getY();
		
		ArrayList<Coordinates> valid = new ArrayList<Coordinates>();
		if(currentX+1 < city.getMap().getSize()){
			if(city.getMap().getInfrastructure(currentX+1, currentY).getType() == 4){
				valid.add(new Coordinates(currentX+1, currentY));
			}
		}
		if(currentX-1 > 0){
			if(city.getMap().getInfrastructure(currentX-1, currentY).getType() == 4){
				valid.add(new Coordinates(currentX-1, currentY));
			}
		}
		if(currentY+1 < city.getMap().getSize()){
			if(city.getMap().getInfrastructure(currentX, currentY+1).getType() == 4){
				valid.add(new Coordinates(currentX, currentY+1));
			}
		}
		if(currentY-1 > 0){
			if(city.getMap().getInfrastructure(currentX, currentY-1).getType() == 4){
				valid.add(new Coordinates(currentX, currentY-1));
			}
		}
		
		return valid;
	}
	
	public int randomSelection(int min, int max){
		int random;
		Random rand = new Random();
		
		random = rand.nextInt(max - min +1) + min;
		
		return random;
	}
}
