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
	
	private Image imgHome1;
	private Image imgWork1;
	private Image imgWork2;
	private Image imgEnter1;
	private Image imgRoadh;
	private Image imgRoadw;
	private Image player1;
	
	public MapManager(){
		try {
			imgHome1 = ImageIO.read(new File(System.getProperty("user.dir") + "/res/img/home" + 1 + ".png"));
			imgWork1 = ImageIO.read(new File(System.getProperty("user.dir") + "/res/img/work0.png"));
			imgWork2 = ImageIO.read(new File(System.getProperty("user.dir") + "/res/img/work.png"));
			imgEnter1 = ImageIO.read(new File(System.getProperty("user.dir") + "/res/img/enter.png"));
			imgRoadh = ImageIO.read(new File(System.getProperty("user.dir") + "/res/img/roadh.png"));
			imgRoadw = ImageIO.read(new File(System.getProperty("user.dir") + "/res/img/roadw.png"));
			player1 = ImageIO.read(new File(System.getProperty("user.dir") + "/res/img/player1.png")).getScaledInstance((20), (20), Image.SCALE_DEFAULT);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public Image printHome(Home home){
		Coordinates size = home.getSize();
		return imgHome1.getScaledInstance((size.getY()*20), (size.getX()*20), Image.SCALE_DEFAULT);
	}
	
	public Image printWork(Work work){
		Coordinates size = work.getSize();
		if (size.getX() == size.getY())
			return imgWork1.getScaledInstance((size.getY()*20), (size.getX()*20), Image.SCALE_DEFAULT);
		else
			return imgWork2.getScaledInstance((size.getY()*20), (size.getX()*20), Image.SCALE_DEFAULT);
	}
	
	public Image printEntertainment(Entertainment enter){
		Coordinates size = enter.getSize();
		return imgEnter1.getScaledInstance((size.getY()*20), (size.getX()*20), Image.SCALE_DEFAULT);
	}
	
	public Image printRoad(Road road){
		Coordinates size = road.getSize();
		if(size.getX() > size.getY())
			return imgRoadh.getScaledInstance((size.getY()*20), (size.getX()*20), Image.SCALE_DEFAULT);
		else
			return imgRoadw.getScaledInstance((size.getY()*20), (size.getX()*20), Image.SCALE_DEFAULT);
	}
	
	public Image printCharacter(Character c){
		return player1;
	}
	
}
