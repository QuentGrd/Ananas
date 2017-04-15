package gui;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JPanel;

import building.Entertainment;
import building.Home;
import building.Work;
import city.Map;
import city.Population;
import trace.Road;
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
	
	private MapManager mngr;

	public GUIGraphicsMap(Map map, Population pop){
		this.map = map;
		this.pop = pop;
		this.setPreferredSize(new Dimension(600, 600));
		this.addMouseListener(new GraphicsMouseListener());
		mngr = new MapManager();
	}
	
	public void paintComponent(Graphics g){
		
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
			if (pop.getListCharacter().get(i).getAlive()){
				g.drawImage(mngr.printCharacter(pop.getListCharacter().get(i)), coord.getY()*20, coord.getX()*20, this);
			}
		}
		
		mngr.setI(0);
	}
	
	class GraphicsMouseListener implements MouseListener{

		@Override
		public void mouseClicked(MouseEvent e) {
			System.out.println("MouseListening");
			System.out.println(e.getY() + ", " + e.getX());
			int x = (e.getY()/20);
			int y = e.getX()/20;
			System.out.println(map.getInfrastructure(x, y));
			switch(map.getInfrastructure(x, y).getType()){
				case 1:
					GUIInfrastructureInfo.setInfo((Home) map.getInfrastructure(x, y));
					break;
				case 2:
					GUIInfrastructureInfo.setInfo((Work) map.getInfrastructure(x, y));
					break;
				case 3:
					GUIInfrastructureInfo.setInfo((Entertainment) map.getInfrastructure(x, y));
					break;
				case 4:
					GUIInfrastructureInfo.setInfo((Road) map.getInfrastructure(x, y));
					break;
			}
		}

		@Override
		public void mousePressed(MouseEvent e) {
		}

		@Override
		public void mouseReleased(MouseEvent e) {
		}

		@Override
		public void mouseEntered(MouseEvent e) {
		}

		@Override
		public void mouseExited(MouseEvent e) {
		}
	}
	
}
