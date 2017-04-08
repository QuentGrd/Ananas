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

public class GUIGraphicsList extends JPanel{

	private static final long serialVersionUID = -451852768204398689L;

	protected static final int chPerRow = 1;
	protected static final int width = 400;
	protected static final int height = 600;
	
	protected Population pop;
	
	public GUIGraphicsList(Population pop){
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
	
}
