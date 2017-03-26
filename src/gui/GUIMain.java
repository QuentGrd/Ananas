package gui;

import java.awt.Dimension;

import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;

import city.Map;
import city.Population;
import clock.Clock;
/**
 * This class represent the GUI
 * @author quentin
 * @version 31012017
 *
 */
public class GUIMain extends JFrame{
	
	private static final long serialVersionUID = 8220592859191502808L;
	
	private JPanel back = new JPanel();
	private JPanel front = new JPanel();
	
	private GUIMap gmap;
	private GUIClockInfo clockInfo;
	private GUIInfoPart info;
	
	public GUIMain(Map map, Clock clock, Population pop){
		gmap = new GUIMap(map, pop);
		clockInfo = new GUIClockInfo(clock);
		info = new GUIInfoPart(pop, map);
		draw();
	}
	
	public void draw(){
		//back.setLayout(new GridLayout(1, 2));
		back.setLayout(new BoxLayout(back, BoxLayout.LINE_AXIS));
		back.add(gmap);
		back.add(info);
		front.setLayout(new BoxLayout(front, BoxLayout.PAGE_AXIS));
		front.add(clockInfo);
		front.add(back);
		this.getContentPane().add(front);
		this.pack();
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setMinimumSize(new Dimension(600, 600));
		this.setTitle("Urban");
		this.setResizable(false);
		this.setLocationRelativeTo(null);
		this.setVisible(true);
	}

	public GUIMap getGmap() {
		return gmap;
	}
	
	public void refreshGUI(Population pop, Clock clock){
		gmap.refreshMap(pop);
		clockInfo.refreshClock(clock);
		info.refesh();
	}
}
