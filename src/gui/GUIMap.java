package gui;

import java.awt.GridLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;

import city.Map;

/**
 * This class represent the Map in the GUI
 * @author quentin
 * @version 31012017
 *
 */

public class GUIMap extends JPanel{

	private static final long serialVersionUID = -7675152509176730289L;
	
	private Map map;
	
	public GUIMap(Map map){
		this.map = map;
		this.setLayout(new GridLayout(map.getSize(), map.getSize()));
		this.initMap();
	}
	
	public void initMap(){
		int i, j;
		int size = map.getSize();
		System.out.println(size);
		for (i=0; i<size; i++){
			for (j=0; j<size; j++){
				System.out.println(i + " " + j);
				switch(map.getInfrastructure(i, j).getType()){
					case 1:
						System.out.println("Home");
						add(new JLabel("H"));
						break;
					case 2:
						System.out.println("Work");
						add(new JLabel("W"));
						break;
					case 3:
						System.out.println("Entertainment");
						add(new JLabel("E"));
						break;
					case 4:
						System.out.println("Road");
						add(new JLabel("R"));
						break;
					default:
						System.out.println("Null");
						add(new JLabel("Null"));
						break;
				}
			}
		}
	}

}
