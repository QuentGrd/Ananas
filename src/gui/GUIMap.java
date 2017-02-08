package gui;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;

import com.sun.xml.internal.ws.api.Component;

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
	private JPanel[][] jmap;
	
	public GUIMap(Map map){
		this.map = map;
		jmap = new JPanel[map.getSize() + 1][map.getSize() + 1];
		this.setLayout(new GridLayout(map.getSize() + 1, map.getSize() + 1));
		this.initMap();
	}
	
	/**
	 * This method initialize the JPanel Map
	 */
	public void initMap(){
		int i, j;
		int size = map.getSize();
		System.out.println(size);
		for (i=0; i<size + 1; i++){
			for (j=0; j<size + 1; j++){
				JPanel p = new JPanel();
				if (i == size){
					JLabel label = new JLabel(String.valueOf(j));
					p.add(label);
				}
				else if (j == size){
					JLabel label = new JLabel(String.valueOf(i));
					p.add(label);
				}
				else{
					switch(map.getInfrastructure(i, j).getType()){
						case 1:
							p.setBackground(new Color(52, 152, 219));
							p.setBorder(BorderFactory.createLineBorder(Color.BLACK));
							break;
						case 2:
							p.setBackground(new Color(231, 76, 60));
							p.setBorder(BorderFactory.createLineBorder(Color.BLACK));
							break;
						case 3:
							p.setBackground(new Color(39, 174, 96));
							p.setBorder(BorderFactory.createLineBorder(Color.BLACK));
							break;
						case 4:
							p.setBackground(new Color(149, 165, 166));
							p.setBorder(BorderFactory.createLineBorder(Color.BLACK));
							break;
						default:
							p.setBackground(new Color(236, 240, 241));
							p.setBorder(BorderFactory.createLineBorder(Color.BLACK));
							break;
					}
				}
				jmap[i][j] = p;
				add(jmap[i][j]);
			}
		}
		
	}
}