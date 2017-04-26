package gui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JLabel;
import javax.swing.JPanel;

import character.NCharacter;

public class GUIGraphicCharacterID extends JPanel{

	private static final long serialVersionUID = -6400646750851939562L;
	
	private NCharacter charac;
	private Image img;

	public GUIGraphicCharacterID(){
		this.setBackground(GUIColor.background);
		this.setMaximumSize(new Dimension(400, 200));
	}
	
	public void setCharactert(NCharacter c){
		this.charac = c;
		this.repaint();
	}
	
	public void paintComponent(Graphics g){
		try {
			img = ImageIO.read(new File(System.getProperty("user.dir") + "/res/img/player1.png")).getScaledInstance((75), (75), Image.SCALE_DEFAULT);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		//Icon
		g.drawImage(img, 15, 15, this);
		
		//Name
		g.setColor(Color.BLACK);
		g.setFont(new Font("Arial", Font.BOLD, 30));
		g.drawString(charac.getFirstName().toUpperCase(), 105, 45);
		g.drawString(charac.getName(), 105, 80);
		
		//Emotion Bar
		g.setColor(Color.BLACK);
		g.drawRect(15, 105, 370, 20);
		g.setColor(GUIColor.emotion);
		g.fillRect(15 + 1, 105 + 1, ((370 -1)*charac.getLife(0).getCounter())/100, 18);
		
		//Money Bar
		g.setColor(Color.BLACK);
		g.drawRect(15, 130, 370, 20);
		g.setColor(GUIColor.money);
		g.fillRect(15 + 1, 130 + 1, ((370 - 1)*charac.getLife(1).getCounter())/100, 18);
		
		//Family Bar
		g.setColor(Color.BLACK);
		g.drawRect(15, 155, 370, 20);
		g.setColor(GUIColor.family);
		g.fillRect(15 + 1, 155 + 1, ((370 - 1)*charac.getLife(2).getCounter())/100, 18);
	}
	
}
