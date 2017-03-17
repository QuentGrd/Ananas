package gui;

import java.awt.Graphics;

import javax.swing.JPanel;

import city.Map;
import city.Population;
import utils.Coordinates;

/**
 * 
 * @author quentin
 *
 */

public class GUIGraphicsMap extends JPanel{
	
	private static final long serialVersionUID = -7166169059693080348L;
	
	private Map map;
	private Population pop;

	public GUIGraphicsMap(Map map, Population pop){
		this.map = map;
		this.pop = pop;
	}
	
	public void paintComponent(Graphics g){
		MapManager mngr = new MapManager();
		Coordinates coord;
		int i = 0;
		for(i=0; i<map.getWorkList().size(); i++){
			coord = map.getWorkList().get(i).getPosition();
			g.drawImage(mngr.printWork(map.getWorkList().get(i)), coord.getY()*20, coord.getX()*20, this);
		}
		
		for(i=0; i<map.getHomeList().size(); i++){
			coord = map.getHomeList().get(i).getPosition();
			g.drawImage(mngr.printHome(map.getHomeList().get(i)), coord.getY()*20, coord.getX()*20, this);
		}
		
		for(i=0; i<map.getEntertainmentList().size(); i++){
			coord = map.getEntertainmentList().get(i).getPosition();
			g.drawImage(mngr.printEntertainment(map.getEntertainmentList().get(i)), coord.getY()*20, coord.getX()*20, this);
		}
		
		for(i=0; i<map.getRoadList().size(); i++){
			coord = map.getRoadList().get(i).getPosition();
			g.drawImage(mngr.printRoad(map.getRoadList().get(i)), coord.getY()*20, coord.getX()*20, this);
		}
		
		for(i=0; i<pop.getListCharacter().size(); i++){
			coord = pop.getListCharacter().get(i).getPosition();
			g.drawImage(mngr.printCharacter(pop.getListCharacter().get(i)), coord.getY()*20, coord.getX()*20, this);
		}
		System.out.println("Fin");
	}
	
}
