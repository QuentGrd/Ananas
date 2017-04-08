package gui;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import character.Character;
import city.Population;

public class QGUIGraphicsList extends GUIGraphicsList{
	
	private static final long serialVersionUID = 3101194973785593449L;
	
	public QGUIGraphicsList(Population pop){
		super(pop);
	}
	
	public void paintComponent(Graphics g){
		int nbCharac = pop.getNbOfCharacter();
		int widthCell = width/chPerRow;
		int heightCell = height/((nbCharac/chPerRow)+(nbCharac%chPerRow));
		int i;
		for (i=0; i<nbCharac; i++){
			Character c = pop.getListCharacter().get(i);
			g.setColor(Color.BLACK);
			g.drawRect((i%chPerRow)*widthCell, (i/chPerRow)*heightCell, widthCell, heightCell);
			g.setColor(Color.GRAY);
			g.fillRect((i%chPerRow)*widthCell, (i/chPerRow)*heightCell, widthCell, heightCell);
			try {
				int imageWidth = 50;
				int imageHeight = 50;
				Image img = ImageIO.read(new File(System.getProperty("user.dir") + "/res/img/player1.png")).getScaledInstance(imageWidth, imageHeight, Image.SCALE_DEFAULT);
				g.drawImage(img, ((i%chPerRow)*widthCell)+(widthCell/2)-(imageWidth/2), ((i/chPerRow)*heightCell)+3*(heightCell/5)-(imageHeight)/*2*(heightCell/5)-(imageHeight/2)*/, this);
			} catch (IOException e) {
				e.printStackTrace();
				int imageWidth = 50;
				int imageHeight = 50;
				g.setColor(Color.YELLOW);
				g.fillOval(((i%chPerRow)*widthCell)+(widthCell/2)-(imageWidth/2), ((i/chPerRow)*heightCell)+3*(heightCell/5)-(imageHeight)/*2*(heightCell/5)-(imageHeight/2)*/, imageWidth, imageHeight);
			}
			// Emotion Bar
			g.setColor(Color.BLACK);
			g.drawRect(((i%chPerRow)*widthCell)+(widthCell/2)-((widthCell-(width/10))/2), ((i/chPerRow)*heightCell)+4*(heightCell/7)-(((heightCell/7)-(heightCell/10))/2), (widthCell-(width/10)), (heightCell/5)-(heightCell/10));
			g.setColor(Color.GREEN);
			g.fillRect(((i%chPerRow)*widthCell)+(widthCell/2)-((widthCell-(width/10))/2), ((i/chPerRow)*heightCell)+4*(heightCell/7)-(((heightCell/7)-(heightCell/10))/2), ((widthCell-(width/10))*c.getLife(0).getCounter())/100, (heightCell/5)-(heightCell/10));
			
			//Money bar
			g.setColor(Color.BLACK);
			g.drawRect(((i%chPerRow)*widthCell)+(widthCell/2)-((widthCell-(width/10))/2), ((i/chPerRow)*heightCell)+5*(heightCell/7)-(((heightCell/7)-(heightCell/10))/2), (widthCell-(width/10)), (heightCell/5)-(heightCell/10));
			g.setColor(Color.YELLOW);
			g.fillRect(((i%chPerRow)*widthCell)+(widthCell/2)-((widthCell-(width/10))/2), ((i/chPerRow)*heightCell)+5*(heightCell/7)-(((heightCell/7)-(heightCell/10))/2), ((widthCell-(width/10))*c.getLife(1).getCounter())/100, (heightCell/5)-(heightCell/10));
			
			//Family Bar
			g.setColor(Color.BLACK);
			g.drawRect(((i%chPerRow)*widthCell)+(widthCell/2)-((widthCell-(width/10))/2), ((i/chPerRow)*heightCell)+6*(heightCell/7)-(((heightCell/7)-(heightCell/10))/2), (widthCell-(width/10)), (heightCell/5)-(heightCell/10));
			g.setColor(Color.ORANGE);
			g.fillRect(((i%chPerRow)*widthCell)+(widthCell/2)-((widthCell-(width/10))/2), ((i/chPerRow)*heightCell)+6*(heightCell/7)-(((heightCell/7)-(heightCell/10))/2), ((widthCell-(width/10))*c.getLife(2).getCounter())/100, (heightCell/5)-(heightCell/10));
			
			g.setColor(Color.BLACK);
			g.setFont(new Font("Arial", Font.BOLD, 15));
			g.drawString(c.getFirstName() + " " + c.getName(), ((i%chPerRow)*widthCell)+(widthCell/5), ((i/chPerRow)*heightCell)+1*(heightCell/5));
		}
	}
	
}
