package gui;

import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
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
		Image img = null;
		try {
			img = ImageIO.read(new File(System.getProperty("user.dir") + "/res/img/home" + 1 + ".png")).getScaledInstance((size.getY()*20), (size.getX()*20), Image.SCALE_DEFAULT);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return img;
	}
	
	public Image printWork(Work work){
		Coordinates size = work.getSize();
		Image img = null;
		try{
			if (size.getX() == size.getY())
				img = ImageIO.read(new File(System.getProperty("user.dir") + "/res/img/work0.png")).getScaledInstance((size.getY()*20), (size.getX()*20), Image.SCALE_DEFAULT);
			else
				img = ImageIO.read(new File(System.getProperty("user.dir") + "/res/img/work.png")).getScaledInstance((size.getY()*20), (size.getX()*20), Image.SCALE_DEFAULT);
		} catch(IOException e){
			e.printStackTrace();
		}
		return img;
	}
	
	public Image printEntertainment(Entertainment enter){
		Coordinates size = enter.getSize();
		Image img = null;
		try {
			img = ImageIO.read(new File(System.getProperty("user.dir") + "/res/img/enter.png")).getScaledInstance((size.getY()*20), (size.getX()*20), Image.SCALE_DEFAULT);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return img;
	}
	
	public Image printRoad(Road road){
		Coordinates size = road.getSize();
		Image img = null;
		try{
			if(size.getX() > size.getY())
				img = ImageIO.read(new File(System.getProperty("user.dir") + "/res/img/roadh.png")).getScaledInstance((size.getY()*20), (size.getX()*20), Image.SCALE_DEFAULT);
			else
				img = ImageIO.read(new File(System.getProperty("user.dir") + "/res/img/roadw.png")).getScaledInstance((size.getY()*20), (size.getX()*20), Image.SCALE_DEFAULT);
		} catch(IOException e){
			e.printStackTrace();
		}
		return img;
	}
	
	public Image printCharacter(Character c){
		Image img = null;
		try {
			img = ImageIO.read(new File(System.getProperty("user.dir") + "/res/img/player1.png")).getScaledInstance((20), (20), Image.SCALE_DEFAULT);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return img;
	}
	
}
