package gui;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import actions.Actions;
import actions.Chilling;
import actions.Entertain;
import actions.Shifting;
import actions.Sleeping;
import actions.Working;
import building.Entertainment;
import character.NCharacter;
import city.Map;
import clock.Schedule;
import run.Run;
import utils.Coordinates;

/**
 * GUI for routine's action adding
 * @author quentin
 *
 */

public class GUIAddAction extends JFrame{

	private static final long serialVersionUID = -3665012827238467540L;
	
	private NCharacter c;
	private Map map;
	private Run run;
	
	private JPanel mainPanel;
	
	private JPanel type;
	private JLabel typeLabel;
	private JComboBox<String> typeChoice;
	private String[] typeList = {"Go Home", "Go Work", "Entertain"};
	
	private JPanel detail;
	private JLabel detailLabel;
	private JComboBox<String> detailChoice;
	private DefaultComboBoxModel homeChoices;
	private DefaultComboBoxModel workChoices;
	private DefaultComboBoxModel enterList;
	
	private JPanel position;
	private JLabel positionLabel;
	private JComboBox<String> positionChoice;
	private String[] positionList = {"First", "End"};
	
	private JButton add;
	
	public GUIAddAction(NCharacter c, Map map, Run run){
		this.run = run;
		this.c = c;
		this.map = map;
		this.initChoices();
		this.initComponent();
		this.build();
		this.draw();
	}
	
	public void initComponent(){
		type = new JPanel();
		detail = new JPanel();
		position = new JPanel();
		
		type.setLayout(new BoxLayout(type, BoxLayout.PAGE_AXIS));
		detail.setLayout(new BoxLayout(detail, BoxLayout.PAGE_AXIS));
		position.setLayout(new BoxLayout(position, BoxLayout.PAGE_AXIS));
		
		Font font = new Font("Arial", Font.PLAIN, 15);
		typeLabel = new JLabel("Type");
		detailLabel = new JLabel("Detail");
		positionLabel = new JLabel("Position");
		add = new JButton("Add");
		typeLabel.setFont(font);
		detailLabel.setFont(font);
		positionLabel.setFont(font);
		
		typeChoice = new JComboBox<String>(typeList);
		detailChoice = new JComboBox<String>(homeChoices);
		positionChoice = new JComboBox<String>(positionList);
		
		typeChoice.addActionListener(new ActionSelect());
		add.addActionListener(new ActionAdd());
		
		type.add(typeLabel);
		type.add(typeChoice);
		detail.add(detailLabel);
		detail.add(detailChoice);
		position.add(positionLabel);
		position.add(positionChoice);
	}
	
	public void initChoices(){
		String[] home = {"Chill", "Sleep"};
		String[] work = {"1h", "2h", "3h", "4h", "5h"};
		String[] enter;
		enter = new String[map.getEntertainmentList().size()];
		int i;
		for(i=0; i<map.getEntertainmentList().size(); i++)
			enter[i] = map.getEntertainmentList().get(i).getName();
		
		homeChoices = new DefaultComboBoxModel(home);
		workChoices = new DefaultComboBoxModel(work);
		enterList = new DefaultComboBoxModel(enter);
	}
	
	public void build(){
		mainPanel = new JPanel();
		mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.LINE_AXIS));
		mainPanel.add(type);
		mainPanel.add(detail);
		mainPanel.add(position);
		mainPanel.add(add);
		this.add(mainPanel);
	}
	
	public void draw(){
		this.pack();
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		this.setTitle("Add action to " + c.getFirstName() + " " + c.getName() + "'s routine");
		this.setMinimumSize(new Dimension(650, 50));
		this.setResizable(false);
		this.setAlwaysOnTop(true);
		this.setLocationRelativeTo(null);
		this.setVisible(true);
	}
	
	class ActionSelect implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
			switch(typeChoice.getSelectedIndex()){
			case 0:
				detailChoice.setModel(homeChoices);
				break;
			case 1:
				detailChoice.setModel(workChoices);
				break;
			case 2:
				detailChoice.setModel(enterList);
				break;
			}
		}
	}
	
	class ActionAdd implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
			
			Actions action = null;
			Coordinates rendezVous = null;
			switch(typeChoice.getSelectedIndex()){
			case 0:
				if (detailChoice.getSelectedIndex() == 0)
					action = new Chilling(c.getHome(), run.getClockTime(), new Schedule("3"));
				else
					action = new Sleeping(c.getHome(), run.getClockTime(), new Schedule("3"));
				rendezVous = c.getHome().getAddress();
				System.out.println("Adding Home Action");
				break;
			case 1:
				action = new Working(c.getWork(), run.getClockTime(), new Schedule(detailChoice.getSelectedItem().toString()));
				System.out.println(detailChoice.getSelectedItem().toString());
				rendezVous = c.getWork().getAddress();
				System.out.println("Adding Work Action");
				break;
			case 2:
				Entertainment enter = map.getEntertainmentList().get(detailChoice.getSelectedIndex());
				System.out.println(enter);
				action = new Entertain(enter, run.getClockTime(), enter.getAverageUsageTime());
				rendezVous = enter.getAddress();
				System.out.println("Adding Entertainment Action");
				break;
			}
			
			switch(positionChoice.getSelectedIndex()){
			case 0:
				c.getRoutine().addFirstToCR(action);
				c.getRoutine().addFirstToCR(new Shifting(run.getClockTime(), c.getPosition(), rendezVous));
				break;
			case 1:
				c.getRoutine().addEndToCR(new Shifting(run.getClockTime(), c.getPosition(), rendezVous));
				c.getRoutine().addEndToCR(action);
				break;
			}
		}
	}

}
