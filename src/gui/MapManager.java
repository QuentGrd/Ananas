package gui;

import java.awt.Image;

import javax.swing.ImageIcon;

import building.Entertainment;
import building.Home;
import building.Work;
import character.Character;
import trace.Road;
import utils.Coordinates;

/**
 * 
 * @author quentin
 *
 */

public class MapManager {
	
	public MapManager(){
		
	}
	
	public Image printHome(Home home){
		Coordinates size = home.getSize();
		ImageIcon sprite = new ImageIcon(System.getProperty("user.dir") + "/res/img/home.png");
		sprite = new ImageIcon(sprite.getImage().getScaledInstance((size.getY()*20), (size.getX()*20), Image.SCALE_DEFAULT));
		return sprite.getImage();
	}
	
	public Image printWork(Work work){
		Coordinates size = work.getSize();
		ImageIcon sprite = new ImageIcon(System.getProperty("user.dir") + "/res/img/work.png");
		sprite = new ImageIcon(sprite.getImage().getScaledInstance((size.getY()*20), (size.getX()*20), Image.SCALE_DEFAULT));
		return sprite.getImage();
	}
	
	public Image printEntertainment(Entertainment enter){
		Coordinates size = enter.getSize();
		ImageIcon sprite = new ImageIcon(System.getProperty("user.dir") + "/res/img/enter.png");
		sprite = new ImageIcon(sprite.getImage().getScaledInstance((size.getY()*20), (size.getX()*20), Image.SCALE_DEFAULT));
		return sprite.getImage();
	}
	
	public Image printRoad(Road road){
		Coordinates size = road.getSize();
		ImageIcon sprite;
		if(size.getX() > size.getY())
			sprite = new ImageIcon(System.getProperty("user.dir") + "/res/img/roadh.png");
		else
			sprite = new ImageIcon(System.getProperty("user.dir") + "/res/img/roadw.png");
		sprite = new ImageIcon(sprite.getImage().getScaledInstance((size.getY()*20), (size.getX()*20), Image.SCALE_DEFAULT));
		return sprite.getImage();
	}
	
	public Image printCharacter(Character c){
		ImageIcon sprite = new ImageIcon(System.getProperty("user.dir") + "/res/img/players.png");
		sprite = new ImageIcon(sprite.getImage().getScaledInstance(20, 20, Image.SCALE_DEFAULT));
		return sprite.getImage();
	}
	
}
