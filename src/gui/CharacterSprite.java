package gui;

import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

import character.Character;
import utils.Coordinates;

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
		/*try {
			img = ImageIO.read(new File(System.getProperty("user.dir") + "/res/img/players.png"));
			img.getScaledInstance(20, 20, Image.SCALE_DEFAULT);
		} catch (IOException e) {
			e.printStackTrace();
		}*/
		ImageIcon sprite = new ImageIcon(System.getProperty("user.dir") + "/res/img/players.png");
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
