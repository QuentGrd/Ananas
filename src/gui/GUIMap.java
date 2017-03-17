package gui;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.LayoutManager;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.OverlayLayout;

import building.Entertainment;
import building.Home;
import building.Work;
import city.Map;
import city.Population;
import trace.Road;

public class GUIMap extends JPanel{

	private static final long serialVersionUID = -2571888897605324494L;
	
	private Population pop;
	
	private int GRID_SIZE;
	private Map map;
	private Cell[][] jmap;
	
	private CardLayout cl;
	private JPanel gridMap;
	private JPanel spriteMap;
	private JPanel buildings;
	private GUICharacters characters;
	private OverlayLayout overl ;
	private static final String SPRITEMAP = "Sprite Map";
	private static final String GRIDMAP = "Grid Map";
	
	private MapManager mngr = new MapManager();

    public GUIMap(Map map, Population pop) {
    	this.pop = pop;
    	
        setPreferredSize(new Dimension(600, 600));
        
        this.map = map;
        GRID_SIZE = map.getSize();
        jmap = new Cell[GRID_SIZE][GRID_SIZE];
        
        this.initCardLayout();
        this.initMap();
                
    }
    
    public void initCardLayout(){
    	cl = new CardLayout();
    	gridMap = new JPanel();
    	spriteMap = new JPanel();
    	buildings = new JPanel();
    	characters = new GUICharacters(pop);
    	
    	this.setLayout(cl);
    	gridMap.setLayout(new GridLayout(GRID_SIZE+1, GRID_SIZE+1));
    	buildings.setLayout(null);
    	characters.setLayout(null);
    	overl = new OverlayLayout(spriteMap);
    	spriteMap.setLayout(overl);
    	spriteMap.add(characters);
    	spriteMap.add(buildings);
    	
    	this.add(spriteMap, SPRITEMAP);
    	this.add(gridMap, GRIDMAP);
    	cl.show(this, SPRITEMAP);
    }
    
    public void initMap(){
    	for (int x = 0; x < GRID_SIZE +1; x++) {
            for (int y = 0; y < GRID_SIZE +1; y++) {
            	if (x == GRID_SIZE){
            		JPanel p = new JPanel();
            		JLabel label = new JLabel(String.valueOf(y));
					p.add(label);
					gridMap.add(p);
				}
				else if (y == GRID_SIZE){
					JPanel p = new JPanel();
					JLabel label = new JLabel(String.valueOf(x));
					p.add(label);
					gridMap.add(p);
				}
				else{
	                Cell cell = new Cell(x, y);
	                JLabel sprite = new JLabel();
	                switch(map.getInfrastructure(x, y).getType()){
						case 1:
							sprite = mngr.printHome((Home) map.getInfrastructure(x, y), buildings);
							cell.setBackground(new Color(52, 152, 219));
							break;
						case 2:
							sprite = mngr.printWork((Work) map.getInfrastructure(x, y), buildings);
							cell.setBackground(new Color(231, 76, 60));
							break;
						case 3:
							sprite = mngr.printEntertainment((Entertainment) map.getInfrastructure(x, y), buildings);
							cell.setBackground(new Color(39, 174, 96));
							break;
						case 4:
							sprite = mngr.printRoad((Road) map.getInfrastructure(x, y), buildings);
							cell.setBackground(new Color(149, 165, 166));
							break;
						default:
							cell.setBackground(new Color(236, 240, 241));
							break;
					}
	                
	                MouseListener ml = new MouseListener() {
	                    public void mouseClicked(MouseEvent e) {
	                        click(e, cell);
	                    }
						public void mousePressed(MouseEvent e) {
						}
						public void mouseReleased(MouseEvent e) {
						}
						public void mouseEntered(MouseEvent e) {
						}
						public void mouseExited(MouseEvent e) {
						}
	                };
	                cell.addMouseListener(ml);
	                sprite.addMouseListener(ml);
	                jmap[x][y] = cell;
	                gridMap.add(jmap[x][y]);
	                buildings.add(sprite);
				}
       
            }
        }
    }
    
    /**
	 * this method actualize the map to see the population
	 */
	public void refreshMap(Population pop){
		for (int x = 0; x < map.getSize(); x++) {
			for (int y = 0; y < map.getSize(); y++) {
				switch(map.getInfrastructure(x, y).getType()){
				case 1:
					setCaseColor(x, y, new Color(52, 152, 219));
					break;
				case 2:
					setCaseColor(x, y, new Color(231, 76, 60));
					break;
				case 3:
					setCaseColor(x, y, new Color(39, 174, 96));
					break;
				case 4:
					setCaseColor(x, y, new Color(149, 165, 166));
					break;
				default:
					setCaseColor(x, y, new Color(236, 240, 241));
					break;
				}
			}
			
		}
		
		for (int i = 0; i < pop.getListCharacter().size(); i++) {
			int xPosition = pop.getListCharacter().get(i).getPosition().getX();
			int yPosition = pop.getListCharacter().get(i).getPosition().getY();
			int xHome = pop.getListCharacter().get(i).getHome().getAddress().getX();
			int yHome = pop.getListCharacter().get(i).getHome().getAddress().getY();
			int xWork = pop.getListCharacter().get(i).getWork().getAddress().getX();
			int yWork = pop.getListCharacter().get(i).getWork().getAddress().getY();
			setCaseColor(xHome, yHome, new Color(255,215,0), ""+i);
			setCaseColor(xWork, yWork, new Color(255,215,0), ""+i);
			setCaseColor(xPosition, yPosition, new Color(155,48,255), ""+i);
		}
	}
	
	/**
	 * this method set the background the case (x,y) to color 
	 * @param x
	 * @param y
	 * @param color
	 */
	public void setCaseColor(int x, int y, Color color){
		jmap[x][y].removeAll();
		jmap[x][y].setBackground(color);
	}
	
	public void setCaseColor(int x, int y, Color color, String txt){
		jmap[x][y].removeAll();
		jmap[x][y].setBackground(color);
		JLabel jlabel = new JLabel(txt);
		jmap[x][y].add(jlabel);
	}

    public void click(MouseEvent e, Cell cell) {
    	//System.out.println(cell.getX()+";"+cell.getY());
    	int y = (cell.getX()-5)/19;
		int x = (cell.getY()-5)/19;
    	System.out.println(map.getInfrastructure(x, y).toString());
    }
}
