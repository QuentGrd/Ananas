package gui;

import java.awt.Image;

import javax.swing.ImageIcon;

import utils.Coordinates;

import character.Character;

/**
 * 
 * @author quentin
 *
 */

public class CharacterSprite {
	
	private Image img;
	private Coordinates coord;
	private Character charac;
	
	public CharacterSprite(Character charac){
		this.initSprite();
		this.charac = charac;
	}
	
	public void initSprite(){
		ImageIcon sprite = new ImageIcon(System.getProperty("user.dir") + "/res/img/player.png");
		sprite = new ImageIcon(sprite.getImage().getScaledInstance(20, 20, Image.SCALE_DEFAULT));
		img = sprite.getImage();
	}

	public Image getImg() {
		return img;
	}

	public void setImg(Image img) {
		this.img = img;
	}

	public Coordinates getCoord() {
		return coord;
	}

	public void setCoord(Coordinates coord) {
		this.coord = coord;
	}

	public Character getCharac() {
		return charac;
	}

	public void setCharac(Character charac) {
		this.charac = charac;
	}
	
}
