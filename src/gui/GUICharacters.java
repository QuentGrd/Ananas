package gui;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Toolkit;
import java.util.ArrayList;

import javax.swing.JPanel;

import city.Population;

public class GUICharacters extends JPanel{
	
	private static final long serialVersionUID = -3087957456826316584L;
	
	private Population pop;
	private ArrayList<CharacterSprite> characs;

	public GUICharacters(Population pop){
		this.pop = pop;
		this.initSprites();
		//this.setLayout(null);
	}
	
	public void initSprites(){
		int nbSprite = pop.getListCharacter().size();
		characs = new ArrayList<CharacterSprite>();
		int i;
		for (i=0; i<nbSprite; i++){
			System.out.println(pop.getListCharacter().get(i));
			characs.add(new CharacterSprite(pop.getListCharacter().get(i)));
		}
	}
	
    public void paintComponent(Graphics g) {
        System.out.println("Zbeb");
        //draw(g);
        int i;
        for(i=0; i<pop.getListCharacter().size(); i++){
        	//g.fillOval((pop.getListCharacter().get(i).getPosition().getY())*20, (pop.getListCharacter().get(i).getPosition().getX())*20, 20, 20);
        	g.drawImage(characs.get(i).getImg(), characs.get(i).getCharac().getPosition().getY()*20, characs.get(i).getCharac().getPosition().getX()*20, this);
        }
    }
	
}
