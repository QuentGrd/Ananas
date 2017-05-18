package gui;

import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

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
	
	private Image imgHome0;
	private Image imgHome1;
	private Image imgHome2;
	private Image imgHome3;
	private Image imgWork0;
	private Image imgWork1;
	private Image imgWork2;
	private Image imgWork;
	private Image imgMQ;
	private Image imgEnter1;
	private Image imgMusee;
	private Image imgRoadh;
	private Image imgRoadw;
	private Image player1;
	private Image park;
	private Image cinema;
	private Image sport;
	
	private int i;
	
	public MapManager(){
		try {
			imgHome0 = ImageIO.read(new File(System.getProperty("user.dir") + "/res/img/home0.png"));
			imgHome1 = ImageIO.read(new File(System.getProperty("user.dir") + "/res/img/home1.png"));
			imgHome2 = ImageIO.read(new File(System.getProperty("user.dir") + "/res/img/home2.png"));
			imgHome3 = ImageIO.read(new File(System.getProperty("user.dir") + "/res/img/home3.png"));
			imgWork0 = ImageIO.read(new File(System.getProperty("user.dir") + "/res/img/work0.png"));
			imgWork1 = ImageIO.read(new File(System.getProperty("user.dir") + "/res/img/work1.png"));
			imgWork2 = ImageIO.read(new File(System.getProperty("user.dir") + "/res/img/work2.png"));
			imgWork = ImageIO.read(new File(System.getProperty("user.dir") + "/res/img/work.png"));
			imgMQ = ImageIO.read(new File(System.getProperty("user.dir") + "/res/img/m&q.png"));
			imgEnter1 = ImageIO.read(new File(System.getProperty("user.dir") + "/res/img/enter.png"));
			imgMusee = ImageIO.read(new File(System.getProperty("user.dir") + "/res/img/musee.png"));
			imgRoadh = ImageIO.read(new File(System.getProperty("user.dir") + "/res/img/roadh.png"));
			imgRoadw = ImageIO.read(new File(System.getProperty("user.dir") + "/res/img/roadw.png"));
			player1 = ImageIO.read(new File(System.getProperty("user.dir") + "/res/img/player1.png")).getScaledInstance((20), (20), Image.SCALE_DEFAULT);
			park = ImageIO.read(new File(System.getProperty("user.dir") + "/res/img/park.png"));
			cinema = ImageIO.read(new File(System.getProperty("user.dir") + "/res/img/cinema.png"));
			sport = ImageIO.read(new File(System.getProperty("user.dir") + "/res/img/sport.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		i = 0;
	}
	
	public void setI(int i){
		this.i = i;
	}
	
	public Image printHome(Home home){
		/*Coordinates size = home.getSize();
		return imgHome1.getScaledInstance((size.getY()*20), (size.getX()*20), Image.SCALE_DEFAULT);*/
		Coordinates size = home.getSize();
		switch(i){
			case 0:
				i = (i+1) % 4;
				return imgHome0.getScaledInstance((size.getY()*20), (size.getX()*20), Image.SCALE_DEFAULT);
			case 1:
				i = (i+1) % 4;
				return imgHome1.getScaledInstance((size.getY()*20), (size.getX()*20), Image.SCALE_DEFAULT);
			case 2:
				i = (i+1) % 4;
				return imgHome2.getScaledInstance((size.getY()*20), (size.getX()*20), Image.SCALE_DEFAULT);
			case 3:
				i = (i+1) % 4;
				return imgHome3.getScaledInstance((size.getY()*20), (size.getX()*20), Image.SCALE_DEFAULT);
			default:
				i = (i+1) % 4;
				return imgHome1.getScaledInstance((size.getY()*20), (size.getX()*20), Image.SCALE_DEFAULT);
		}
	}
	
	public Image printWork(Work work){
		Coordinates size = work.getSize();
		if (work.getName().equals("Matt&Quent's Corp"))
			return imgMQ.getScaledInstance((size.getY()*20), (size.getX()*20), Image.SCALE_DEFAULT);
		else if (size.getX() == size.getY())
			return imgWork0.getScaledInstance((size.getY()*20), (size.getX()*20), Image.SCALE_DEFAULT);
		else if (/*size.getX() == 2 && size.getY() == 4*/ size.getX() < size.getY())
			return imgWork1.getScaledInstance((size.getY()*20), (size.getX()*20), Image.SCALE_DEFAULT);
		else if (size.getX() > size.getY())
			return imgWork2.getScaledInstance((size.getY()*20), (size.getX()*20), Image.SCALE_DEFAULT);
		else
			return imgWork.getScaledInstance((size.getY()*20), (size.getX()*20), Image.SCALE_DEFAULT);
	}
	
	public Image printEntertainment(Entertainment enter){
		Coordinates size = enter.getSize();
		if (enter.getName().equals("Park public"))
			return park.getScaledInstance((size.getY()*20), (size.getX()*20), Image.SCALE_DEFAULT);
		else if (enter.getName().equals("Musée"))
			return imgMusee.getScaledInstance((size.getY()*20), (size.getX()*20), Image.SCALE_DEFAULT);
		else if (enter.getName().equals("Cinema"))
			return cinema.getScaledInstance((size.getY()*20), (size.getX()*20), Image.SCALE_DEFAULT);
		else if (enter.getName().equals("Club de sport"))
			return sport.getScaledInstance((size.getY()*20), (size.getX()*20), Image.SCALE_DEFAULT);
		else
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
