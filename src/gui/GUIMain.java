package gui;

import javax.swing.JFrame;

import city.Map;
/**
 * This class represent the GUI
 * @author quentin
 * @version 31012017
 *
 */
public class GUIMain extends JFrame{
	
	private static final long serialVersionUID = 8220592859191502808L;
	
	private GUIMap gmap;
	
	public GUIMain(Map map){
		gmap = new GUIMap(map);
		draw();
	}
	
	public void draw(){
		this.add(gmap);
		this.pack();
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setTitle("Urban");
		this.setResizable(false);
		this.setLocationRelativeTo(null);
		this.setVisible(true);
	}
}
