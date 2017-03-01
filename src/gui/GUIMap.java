package gui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

import city.Map;
import city.Population;

public class GUIMap extends JPanel{

	private int GRID_SIZE;
	private Map map;
	private Cell[][] jmap;

    public GUIMap(Map map) {
        setPreferredSize(new Dimension(600, 600));
        
        this.map = map;
        GRID_SIZE = map.getSize();
        jmap = new Cell[GRID_SIZE][GRID_SIZE];
        this.setLayout(new GridLayout(GRID_SIZE+1, GRID_SIZE+1));
        this.initMap();
                
    }
    
    public void initMap(){
    	for (int x = 0; x < GRID_SIZE +1; x++) {
            for (int y = 0; y < GRID_SIZE +1; y++) {
            	if (x == GRID_SIZE){
            		JPanel p = new JPanel();
            		JLabel label = new JLabel(String.valueOf(y));
					p.add(label);
					add(p);
				}
				else if (y == GRID_SIZE){
					JPanel p = new JPanel();
					JLabel label = new JLabel(String.valueOf(x));
					p.add(label);
					add(p);
				}
				else{
	                Cell cell = new Cell(x, y);
	                
	                switch(map.getInfrastructure(x, y).getType()){
						case 1:
							JLabel img = new JLabel();
							ImageIcon sprite = new ImageIcon(System.getProperty("user.dir") + "/res/img/home.png");
							img.setIcon(sprite);
							cell.add(img);
							cell.setBackground(new Color(52, 152, 219));
							break;
						case 2:
							cell.setBackground(new Color(231, 76, 60));
							break;
						case 3:
							cell.setBackground(new Color(39, 174, 96));
							break;
						case 4:
							cell.setBackground(new Color(149, 165, 166));
							break;
						default:
							cell.setBackground(new Color(236, 240, 241));
							break;
					}
	 
	                add(cell);
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
	                jmap[x][y] = cell;
	                add(jmap[x][y]);
				}
       
            }
        }
    }
    
    /**
	 * this methode actualize the map to see the population
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
	 * this methode set the background the case (x,y) to color 
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
