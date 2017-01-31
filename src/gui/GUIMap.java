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
		for (i=0; i<map.getSize(); i++){
			for (j=0; i<map.getSize(); j++){
				switch(map.getInfrastructure(i, j).getType()){
					case 1:
						System.out.println("Home");
						add(new JLabel("Home"));
						break;
					case 2:
						System.out.println("Work");
						add(new JLabel("Work"));
						break;
					case 3:
						System.out.println("Entertainment");
						add(new JLabel("Entertainement"));
						break;
					case 4:
						System.out.println("Road");
						add(new JLabel("Road"));
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
