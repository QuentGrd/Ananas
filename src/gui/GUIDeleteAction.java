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

import character.NCharacter;

public class GUIDeleteAction extends JFrame{

	private static final long serialVersionUID = -3665012827238467540L;
	
	private NCharacter c;
	
	private JPanel mainPanel;
	
	private JPanel actions;
	private JLabel actionsLabel;
	private JComboBox<String> actionsChoice;
	private DefaultComboBoxModel actionsList;
	
	private JButton add;
	
	public GUIDeleteAction(NCharacter c){
		this.c = c;
		this.initComponent();
		this.build();
		this.draw();
	}
	
	public void initComponent(){
		actions = new JPanel();
		
		actions.setLayout(new BoxLayout(actions, BoxLayout.PAGE_AXIS));
		
		Font font = new Font("Arial", Font.PLAIN, 15);
		actionsLabel = new JLabel("actions");
		actionsLabel.setFont(font);
		add = new JButton("Delete");
		
		this.initActionsList();
		actionsChoice = new JComboBox<String>(actionsList);
		
		add.addActionListener(new ActionDelete());
		
		actions.add(actionsLabel);
		actions.add(actionsChoice);
	}
	
	public void initActionsList(){
		String[] actions;
		actions = new String[c.getRoutine().getCurrentRoutine().size()];
		int i = 0;
		for(i=0; i<c.getRoutine().getCurrentRoutine().size(); i++)
			actions[i] = i+1 + ". " + c.getRoutine().getCurrentRoutine().get(i).getClass().getName();
		
		actionsList = new DefaultComboBoxModel(actions);
	}
	
	public void build(){
		mainPanel = new JPanel();
		mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.LINE_AXIS));
		mainPanel.add(actions);
		mainPanel.add(add);
		this.add(mainPanel);
	}
	
	public void draw(){
		this.pack();
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		this.setTitle("Delete action from " + c.getFirstName() + " " + c.getName() + "'s routine");
		this.setMinimumSize(new Dimension(650, 50));
		this.setResizable(false);
		this.setAlwaysOnTop(true);
		this.setLocationRelativeTo(null);
		this.setVisible(true);
	}
	
	class ActionDelete implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
			c.getRoutine().getCurrentRoutine().remove(actionsChoice.getSelectedIndex());
		}
	}

}
