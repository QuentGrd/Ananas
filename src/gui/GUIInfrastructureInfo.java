package gui;

import java.awt.FlowLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;

import building.Entertainment;
import building.Home;
import building.Work;
import trace.Road;

public class GUIInfrastructureInfo extends JPanel{

	private static final long serialVersionUID = 4621083481921805583L;
	
	private static JLabel type;
	private static JLabel name;
	private static JLabel opening;
	private static JLabel closing;

	public GUIInfrastructureInfo(){
		this.setBackground(GUIMain.background);
		this.setLayout(new FlowLayout());
		this.initLabel();
		this.add(type);
		this.add(name);
		this.add(opening);
		this.add(closing);
	}
	
	public void initLabel(){
		type = new JLabel("Type: ");
		name = new JLabel("Name: ");
		opening = new JLabel("Opening: ");
		closing = new JLabel("Closing: ");
	}
	
	public static void setInfo(Home home){
		type.setText("Type: Home");
		name.setText("\tA Home has no name");
		opening.setText(" ");
		closing.setText(" ");
	}
	
	public static void setInfo(Work work){
		type.setText("Type: Work");
		name.setText("\tName: " + work.getName());
		opening.setText("\tOpening: " + work.getOpeningTime());
		closing.setText("\tClosing: " + work.getClosingTime());
	}
	
	public static void setInfo(Entertainment enter){
		type.setText("Type: Entertainment");
		name.setText("\tName: " + enter.getName());
		opening.setText("\tOpening: " + enter.getOpeningTime());
		closing.setText("\tClosing: " + enter.getClosingTime());
	}
	
	public static void setInfo(Road road){
		type.setText("Type: Road\t");
		name.setText("A Road has no name\t");
		opening.setText(" \t");
		closing.setText(" \t");
	}
	
}
