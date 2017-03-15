package gui;

import java.awt.Image;
import java.awt.image.BufferedImage;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

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
	
	public JLabel printHome(Home home, JPanel map){
		Coordinates coord = home.getPosition();
		JLabel img = new JLabel();
		ImageIcon sprite = new ImageIcon(System.getProperty("user.dir") + "/res/img/home.png");
		img.setIcon(sprite);
		img.setBounds((coord.getY()*20), (coord.getX()*20), 40, 40);
		//map.add(img);
		return img;
	}
	
	public JLabel printWork(Work work, JPanel map){
		Coordinates coord = work.getPosition();
		Coordinates size = work.getSize();
		JLabel img = new JLabel();
		ImageIcon sprite = new ImageIcon(System.getProperty("user.dir") + "/res/img/work.png");
		sprite = new ImageIcon(sprite.getImage().getScaledInstance((size.getY()*20), (size.getX()*20), Image.SCALE_DEFAULT));
		img.setIcon(sprite);
		//img.setSize(size.getX(), size.getY());
		img.setBounds((coord.getY()*20), (coord.getX()*20), (size.getY()*20), (size.getX()*20));
		//map.add(img);
		return img;
	}
	
	public JLabel printEntertainment(Entertainment enter, JPanel map){
		Coordinates coord = enter.getPosition();
		Coordinates size = enter.getSize();
		JLabel img = new JLabel();
		ImageIcon sprite = new ImageIcon(System.getProperty("user.dir") + "/res/img/enter.png");
		sprite = new ImageIcon(sprite.getImage().getScaledInstance((size.getY()*20), (size.getX()*20), Image.SCALE_DEFAULT));
		img.setIcon(sprite);
		img.setBounds((coord.getY()*20), (coord.getX()*20), (size.getY()*20), (size.getX()*20));
		//map.add(img);
		return img;
	}
	
	public JLabel printRoad(Road road, JPanel map){
		Coordinates coord = road.getPosition();
		Coordinates size = road.getSize();
		JLabel img = new JLabel();
		ImageIcon sprite;
		if(size.getX() > size.getY())
			sprite = new ImageIcon(System.getProperty("user.dir") + "/res/img/roadh.png");
		else
			sprite = new ImageIcon(System.getProperty("user.dir") + "/res/img/roadw.png");
		sprite = new ImageIcon(sprite.getImage().getScaledInstance((size.getY()*20), (size.getX()*20), Image.SCALE_DEFAULT));
		img.setIcon(sprite);
		img.setBounds((coord.getY()*20), (coord.getX()*20), (size.getY()*20), (size.getX()*20));
		//map.add(img);
		return img;
	}
	
}
