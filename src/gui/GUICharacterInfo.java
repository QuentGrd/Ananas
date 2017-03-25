package gui;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextPane;

import character.Character;

public class GUICharacterInfo extends JPanel{
	
	private static final long serialVersionUID = -2871374449425310547L;
	
	private Character currentCharacter;
	
	private JPanel infoPart;
	private JTextPane infoText;
	private String textDefault = "First Name:\nName:\nID:\nEmotion:\nHome:\nWork:\n";
	
	private JPanel buttonPart;
	private JButton list;
	private JButton info;
	private JButton chart;
	private JButton addAction;
	
	public GUICharacterInfo(){
		this.setPreferredSize(new Dimension(400, 600));
		this.setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
		this.initButtonPart();
		this.initInfoPanel();
		this.add(infoPart);
	}
	
	public void setCurrentCharacter(Character c){
		this.currentCharacter = c;
		infoText.setText(getCharacInfo(currentCharacter));
	}
	
	public void initInfoPanel(){
		infoPart = new JPanel();
		infoText = new JTextPane();
		infoText.setEditable(false);
		infoText.setText(textDefault);
		infoText.setPreferredSize(new Dimension(390, 550));
		infoPart.add(infoText);
		infoPart.add(buttonPart);
	}
	
	public void initButtonPart(){
		buttonPart = new JPanel();
		info = new JButton("_info");
		list = new JButton("Back");
		chart = new JButton("Chart");
		addAction = new JButton("Add Action");
		info.addActionListener(new DisplayInfoAction());
		list.addActionListener(new DisplayListAction());
		chart.addActionListener(new ActionShowChart());
		addAction.addActionListener(new AddButtonAction());
		buttonPart.setLayout(new FlowLayout());
		buttonPart.add(list);
		//buttonPart.add(info);
		buttonPart.add(chart);
		buttonPart.add(addAction);
		
	}
	
	public String getCharacInfo(Character c){
		String info = null;
		if (c == null)
			info = "This character is dead !";
		else{
			info = "First Name: \t" + c.getFirstName();
			info += "\nName: \t" + c.getName();
			info += "\nID: \t" + c.getId();
			info += "\nEmotion: \t" + c.getEmotion().getCounter();
			info += "\nHome: \t" + c.getHome().getAddress().toString();
			info += "\nWork: \t" + c.getWork().getAddress().toString();
			info += "\nRoutine: \t" + c.getRoutine().getCurrentRoutine().toString();
		}
		return info;
	}
	
	class DisplayInfoAction implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
		}
	}
	
	class DisplayListAction implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
		}	
	}
	
	class AddButtonAction implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
		}
	}
	
	class ActionShowChart implements ActionListener{
		public void actionPerformed(ActionEvent e){
			
			if(currentCharacter.getEmotionHistoric().size()>0){
				GUICharacterChart chart = new GUICharacterChart(currentCharacter);
			}
			else{
				JOptionPane error = new JOptionPane();

				error.showMessageDialog(null, "Nous ne parvenons pas à determiner l'historique de ce perosnnage", "Error", JOptionPane.ERROR_MESSAGE);

			}
		}
	}
	
}
