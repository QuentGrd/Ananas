package gui;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextPane;

import actions.Actions;
import actions.Entertain;
import actions.Shifting;
import actions.Sleeping;
import character.Character;
import chart.ChartActionRepartitionDaily;
import chart.ChartActionRepartitionFull;
import chart.ChartEmotionHistoricDaily;
import chart.ChartEmotionHistoricFull;
import chart.ChartRewardRepartitionFull;
import city.Map;
import clock.Schedule;
import run.Run;
import utils.Coordinates;

public class GUICharacterInfo extends JPanel{
	
	private static final long serialVersionUID = -2871374449425310547L;
	
	private Character currentCharacter;
	
	private Map map;
	
	private JPanel infoPart;
	private JTextPane infoText;
	private String textDefault = "First Name:\nName:\nID:\nEmotion:\nHome:\nWork:\n";
	
	private JPanel buttonPart;
	private JButton list;
	private JButton info;
	
	private JButton chartAction;
	private JButton chartEmotionFull;
	private JButton chartEmotionDay;
	private JButton chartRewardFull;
	private JButton chartActionDay;
	
	private JPanel characRoutine;
	private JButton addAction;
	private JComboBox<String> actionType;
	private JComboBox<String> infra;
	private String[] actionList = {"Chilling", "Entertainment", "Shifting", "Sleeping", "Working"};
	private DefaultComboBoxModel homeList;
	private DefaultComboBoxModel workList;
	private DefaultComboBoxModel enterList;
	
	private GUIInfoPart parent;
	
	public GUICharacterInfo(GUIInfoPart parent, Map map){
		this.map = map;
		this.parent = parent;
		this.setPreferredSize(new Dimension(400, 600));
		this.setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
		this.initLists();
		this.initButtonPart();
		this.initRoutinePanel();
		this.initInfoPanel();
		this.add(infoPart);
		this.add(characRoutine);
		this.add(buttonPart);
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
		infoText.setPreferredSize(new Dimension(390, 170));
		infoPart.setPreferredSize(new Dimension(390, 250));
		infoPart.add(infoText);
		infoPart.add(chartRewardFull);
		infoPart.add(chartAction);
		infoPart.add(chartActionDay);
		infoPart.add(chartEmotionFull);
		infoPart.add(chartEmotionDay);
	}
	
	public void initButtonPart(){
		buttonPart = new JPanel();
		info = new JButton("_info");
		list = new JButton("Back");
		chartAction = new JButton("Full Action Repartition");
		chartEmotionFull = new JButton("Full Emotion Repartition");
		chartEmotionDay = new JButton("Daily Emotion Repartition");
		chartRewardFull = new JButton("Full Reward Repartition");
		chartActionDay = new JButton("Daily Action Repartition");
		info.addActionListener(new DisplayInfoAction());
		list.addActionListener(new DisplayListAction());
		chartAction.addActionListener(new ActionShowChart());
		chartEmotionFull.addActionListener(new ActionShowChart());
		chartEmotionDay.addActionListener(new ActionShowChart());
		chartRewardFull.addActionListener(new ActionShowChart());
		chartActionDay.addActionListener(new ActionShowChart());
		buttonPart.setLayout(new FlowLayout());
		buttonPart.add(list);
		//buttonPart.add(info);
		//buttonPart.add(chart);
		
	}
	
	public void initRoutinePanel(){
		characRoutine = new JPanel();
		addAction = new JButton("Add Action");
		actionType = new JComboBox<String>(actionList);
		infra = new JComboBox<String>();
		actionType.addActionListener(new ActionTypeAction());
		addAction.addActionListener(new AddButtonAction());
		characRoutine.add(actionType);
		characRoutine.add(infra);
		characRoutine.add(addAction);
	}
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public void initLists(){
		String[] home = new String[map.getHomeList().size()];
		String[] work = new String[map.getWorkList().size()];
		String[] enter = new String[map.getEntertainmentList().size()];
		
		int i = 0;
		for(i=0; i<map.getHomeList().size(); i++)
			home[i] = map.getHomeList().get(i).getName();
		for(i=0; i<map.getWorkList().size(); i++)
			work[i] = map.getWorkList().get(i).getName();
		for(i=0; i<map.getEntertainmentList().size(); i++)
			enter[i] = map.getEntertainmentList().get(i).getName();
		
		homeList = new DefaultComboBoxModel(home);
		workList = new DefaultComboBoxModel(work);
		enterList = new DefaultComboBoxModel(enter);
	}
	
	public String getCharacInfo(Character c){
		String info = null;
		if (c == null)
			info = "This character is dead !";
		else{
			info = "First Name: \t" + c.getFirstName();
			info += "\nName: \t" + c.getName();
			info += "\nID: \t" + c.getId();
			info += "\nAge: \t" + c.getAge();
			info += "\nEmotion: \t" + c.getEmotion().getCounter();
			info += "\nHome: \t" + c.getHome().getAddress().toString();
			info += "\nWork: \t" + c.getWork().getName();
			//info += "\nRoutine: \t" + c.getRoutine().getCurrentRoutine().toString();
		}
		return info;
	}
	
	class ActionTypeAction implements ActionListener{
		@SuppressWarnings("unchecked")
		@Override
		public void actionPerformed(ActionEvent e) {
			switch(actionType.getSelectedIndex()){
				case 1:
					infra.setModel(enterList);
					break;
				case 2:
					infra.setModel(enterList);
					break;
				case 4:
					infra.setModel(workList);
					break;
			}
		}
	}
	
	class DisplayInfoAction implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
		}
	}
	
	class DisplayListAction implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
			parent.showList();
		}	
	}
	
	class AddButtonAction implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
			Actions action = null;
			Coordinates adress = null;
			switch(actionType.getSelectedIndex()){
				case 1:
					adress = map.getEntertainmentList().get(infra.getSelectedIndex()).getAddress();
					action = new Entertain(map.getEntertainmentList().get(infra.getSelectedIndex()), Run.getClockTime(), new Schedule("3"));
					break;
				case 2:
					adress = map.getEntertainmentList().get(infra.getSelectedIndex()).getAddress();
					action = new Shifting(Run.getClockTime(), currentCharacter.getPosition(), adress);
					break;
				case 3:
					adress = currentCharacter.getHome().getAddress();
					action = new Sleeping(currentCharacter.getHome(), Run.getClockTime(), new Schedule("3"));
					break;
			}
			currentCharacter.getRoutine().addFirstToCR(action);
			currentCharacter.getRoutine().addFirstToCR(new Shifting(Run.getClockTime(), currentCharacter.getPosition(), adress));
		}
	}
	
	class ActionShowChart implements ActionListener{
		public void actionPerformed(ActionEvent e){
			
			System.out.println(e.getActionCommand());
			
			if(currentCharacter.getData().getEmotionHistoric().size()>0){
				//ChartActionRepartition chart = new ChartActionRepartition(currentCharacter);
				//ChartEmotionHistoricFull chart = new ChartEmotionHistoricFull(currentCharacter);
				//ChartEmotionHistoricDaily chart = new ChartEmotionHistoricDaily(currentCharacter);
				//ChartRewardRepartitionFull chart = new ChartRewardRepartitionFull(currentCharacter);
				//ChartActionRepartitionDaily chart = new ChartActionRepartitionDaily(currentCharacter);
				switch(e.getActionCommand()){
					case "Daily Action Repartition":
						ChartActionRepartitionDaily chart = new ChartActionRepartitionDaily(currentCharacter);
						break;
					case "Full Emotion Repartition":
						ChartEmotionHistoricFull chart1 = new ChartEmotionHistoricFull(currentCharacter);
						break;
					case "Daily Emotion Repartition":
						ChartEmotionHistoricDaily chart2 = new ChartEmotionHistoricDaily(currentCharacter);
						break;
					case "Full Reward Repartition":
						ChartRewardRepartitionFull chart3 = new ChartRewardRepartitionFull(currentCharacter);
						break;
					case "Full Action Repartition":
						ChartActionRepartitionFull chart4 = new ChartActionRepartitionFull(currentCharacter);
						break;
				}
			}
			else{
				JOptionPane error = new JOptionPane();

				error.showMessageDialog(null, "Nous ne parvenons pas à determiner l'historique de ce perosnnage", "Error", JOptionPane.ERROR_MESSAGE);

			}
		}
	}
	
}
