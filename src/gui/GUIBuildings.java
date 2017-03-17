package gui;

import java.awt.Graphics;

import javax.swing.JPanel;

import city.Map;
import utils.Coordinates;

public class GUIBuildings extends JPanel{

	private static final long serialVersionUID = 1794817274548210448L;
	
	private Map map;

	public GUIBuildings(Map map){
		this.map = map;
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
		
	}
	
}
