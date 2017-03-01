package gui;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import city.Population;
import clock.Clock;

/**
 * 
 * @author matthieu
 *
 */
public class InfoPart extends JPanel{

	private Population pop;
	
	public InfoPart(Population pop){
		this.pop = pop;
		this.setPreferredSize(new Dimension(400, 600));
	}
	
	
}
