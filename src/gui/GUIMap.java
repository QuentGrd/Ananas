package gui;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JLabel;
import javax.swing.JPanel;

import city.Map;
import city.Population;

public class GUIMap extends JPanel{

	private static final long serialVersionUID = -2571888897605324494L;
	
	private Population pop;
	
	private Map map;
	
	private CardLayout cl;
	private JPanel spriteMap;
	private static final String SPRITEMAP = "Sprite Map";

    public GUIMap(Map map, Population pop) {
    	this.pop = pop;
    	
        setPreferredSize(new Dimension(600, 600));
        
        this.map = map;
        
        this.initCardLayout();
                
    }
    
    public void initCardLayout(){
    	cl = new CardLayout();
    	spriteMap = new GUIGraphicsMap(map, pop);
    	
    	this.setLayout(cl);
    	
    	this.add(spriteMap, SPRITEMAP);
    	cl.show(this, SPRITEMAP);
    }
    
    /**
	 * this method actualize the map to see the population
	 */
	public void refreshMap(Population pop){
		spriteMap.repaint();
	}
}
