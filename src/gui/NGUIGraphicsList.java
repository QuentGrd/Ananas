package gui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

import character.Character;
import city.Population;

public class NGUIGraphicsList extends JPanel{

	private static final long serialVersionUID = -451852768204398689L;

	private static final int chPerRow = 1;
	private static final int width = 400;
	private static final int height = 600;
	
	private Population pop;
	
	public NGUIGraphicsList(Population pop){
		this.pop = pop;
		this.setPreferredSize(new Dimension(width, height));
	}
	
	public int getPopIndex(int x, int y){
		int i = 0;
		int nbCharac = pop.getNbOfCharacter();
		int cellHeight = height/((nbCharac/chPerRow)+(nbCharac%chPerRow));
		int widthCell = width/chPerRow;
		int currentRow = (y/cellHeight);
		int currentCol = (x/widthCell);
		i = (currentRow*chPerRow) + currentCol;
		return i;
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
			g.drawRect(((i%chPerRow)*widthCell)+(widthCell/2)-((widthCell-(width/10))/2), ((i/chPerRow)*heightCell)+4*(heightCell/5)-(((heightCell/5)-(heightCell/10))/2), (widthCell-(width/10)), (heightCell/5)-(heightCell/10));
			g.setColor(Color.GREEN);
			g.fillRect(((i%chPerRow)*widthCell)+(widthCell/2)-((widthCell-(width/10))/2), ((i/chPerRow)*heightCell)+4*(heightCell/5)-(((heightCell/5)-(heightCell/10))/2), ((widthCell-(width/10))*c.getLife(0).getCounter())/100, (heightCell/5)-(heightCell/10));

			g.setColor(Color.BLACK);
			g.setFont(new Font("Arial", Font.BOLD, 15));
			g.drawString(c.getFirstName() + " " + c.getName(), ((i%chPerRow)*widthCell)+(widthCell/5), ((i/chPerRow)*heightCell)+1*(heightCell/5));
		}
	}
	
}
