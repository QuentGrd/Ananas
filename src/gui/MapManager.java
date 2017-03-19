package gui;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;
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
	
	public Image printHome(Home home){
		Coordinates coord = home.getPosition();
		JLabel img = new JLabel();
		ImageIcon sprite = new ImageIcon(System.getProperty("user.dir") + "/res/img/home.png");
		img.setIcon(sprite);
		img.setBounds((coord.getY()*20), (coord.getX()*20), 40, 40);
		return sprite.getImage();
	}
	
	public Image printWork(Work work){
		Coordinates coord = work.getPosition();
		Coordinates size = work.getSize();
		JLabel img = new JLabel();
		ImageIcon sprite = new ImageIcon(System.getProperty("user.dir") + "/res/img/work.png");
		sprite = new ImageIcon(sprite.getImage().getScaledInstance((size.getY()*20), (size.getX()*20), Image.SCALE_DEFAULT));
		img.setIcon(sprite);
		img.setBounds((coord.getY()*20), (coord.getX()*20), (size.getY()*20), (size.getX()*20));
		return sprite.getImage();
	}
	
	public Image printEntertainment(Entertainment enter){
		Coordinates coord = enter.getPosition();
		Coordinates size = enter.getSize();
		JLabel img = new JLabel();
		ImageIcon sprite = new ImageIcon(System.getProperty("user.dir") + "/res/img/enter.png");
		sprite = new ImageIcon(sprite.getImage().getScaledInstance((size.getY()*20), (size.getX()*20), Image.SCALE_DEFAULT));
		img.setIcon(sprite);
		img.setBounds((coord.getY()*20), (coord.getX()*20), (size.getY()*20), (size.getX()*20));
		return sprite.getImage();
	}
	
	public Image printRoad(Road road){
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
		return sprite.getImage();
	}
	
	public Image printCharacter(Character c){
		Coordinates coord = c.getPosition();
		JLabel img = new JLabel();
		ImageIcon sprite = new ImageIcon(System.getProperty("user.dir") + "/res/img/players.png");
		sprite = new ImageIcon(sprite.getImage().getScaledInstance(20, 20, Image.SCALE_DEFAULT));
		img.setIcon(sprite);
		img.setBounds((coord.getY()*20), (coord.getX()*20), 20, 20);
		return sprite.getImage();
	}
	
}
