package gui;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import character.NCharacter;
import chart.ChartActionRepartitionDaily;
import chart.ChartActionRepartitionFull;
import chart.ChartEmotionHistoricDaily;
import chart.ChartEmotionHistoricFull;
import chart.ChartRewardRepartitionFull;
import city.Map;
import run.Run;

public class GUICharacterID extends JPanel{
	
	private static final long serialVersionUID = -6800002715222904465L;
	
	private NCharacter charac;
	private GUIInfoPart parent;
	private Map map;
	private Run run;
	
	private JPanel id;
	private JLabel age;
	private JLabel homeCoord;
	private JLabel work;
	
	private JPanel chart;
	private JButton chartAction;
	private JButton chartEmotionFull;
	private JButton chartEmotionDay;
	private JButton chartRewardFull;
	private JButton chartActionDay;
	
	private JPanel routine;
	private JPanel routineButton;
	private JPanel actionList;
	private JLabel action[];
	private JButton addAction;
	private JButton refreshRoutine;
	
	private JButton back;

	public GUICharacterID(GUIInfoPart parent, Map map, Run run){
		this.run = run;
		this.parent = parent;
		this.map = map;
		this.setMaximumSize(new Dimension(400, 400));
		this.setBackground(GUIColor.background);
		//this.setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
		this.setLayout(new FlowLayout());
		this.init();
		this.build();
	}
	
	public void initLabel(){
		id = new JPanel();
		id.setBackground(GUIColor.background);
		id.setLayout(new BoxLayout(id, BoxLayout.Y_AXIS));
		id.setPreferredSize(new Dimension(350, 65));
		Font font = new Font("Arial", Font.PLAIN, 15);
		age = new JLabel("1. ");
		homeCoord = new JLabel("2. ");
		work = new JLabel("3. ");
		age.setFont(font);
		homeCoord.setFont(font);
		work.setFont(font);
		id.add(age);
		id.add(homeCoord);
		id.add(work);
	}
	
	public void initGraph(){
		chart = new JPanel();
		chart.setBackground(GUIColor.background);
		chart.setLayout(new BoxLayout(chart, BoxLayout.LINE_AXIS));
		chart.setPreferredSize(new Dimension(400, 40));
		chartAction = new JButton("F.Act");
		chartEmotionFull = new JButton("F.Emo");
		chartEmotionDay = new JButton("D.Emo");
		chartRewardFull = new JButton("F.Rew");
		chartActionDay = new JButton("D.Act");
		chartAction.addActionListener(new ActionShowChart());
		chartEmotionFull.addActionListener(new ActionShowChart());
		chartEmotionDay.addActionListener(new ActionShowChart());
		chartRewardFull.addActionListener(new ActionShowChart());
		chartActionDay.addActionListener(new ActionShowChart());
		chart.add(chartAction);
		chart.add(chartActionDay);
		chart.add(chartEmotionFull);
		chart.add(chartEmotionDay);
		chart.add(chartRewardFull);
	}
	
	public void initActionsList(){
		routine = new JPanel();
		actionList = new JPanel();
		routineButton = new JPanel();
		action = new JLabel[10];
		addAction = new JButton("Add");
		refreshRoutine = new JButton("Refresh");
		
		routine.setBackground(GUIColor.background);
		actionList.setBackground(GUIColor.background);
		routineButton.setBackground(GUIColor.background);
		
		addAction.addActionListener(new ActionAddRoutine());
		refreshRoutine.addActionListener(new ActionRefreshRoutine());
		
		//routine.setLayout(new BoxLayout(routine, BoxLayout.LINE_AXIS));
		routine.setLayout(new FlowLayout());
		actionList.setLayout(new BoxLayout(actionList, BoxLayout.Y_AXIS));
		routineButton.setLayout(new BoxLayout(routineButton, BoxLayout.PAGE_AXIS));
		actionList.setPreferredSize(new Dimension(175, 200));
		routineButton.setPreferredSize(new Dimension(175, 200));
		for (int i = 0; i < 10; i++){
			action[i] = new JLabel();
			actionList.add(action[i]);
		}
		
		routineButton.add(addAction);
		routineButton.add(refreshRoutine);
		
		routine.add(actionList);
		routine.add(routineButton);
	}
	
	public void refreshRoutineInfo(){
		int i;
		for (i = 0; i<charac.getRoutine().getCurrentRoutine().size() ||  i<10; i++){
			if (i >= charac.getRoutine().getCurrentRoutine().size())
				action[i].setText(i+1 + ". ");
			else
				action[i].setText(i+1 +". " + decryptRoutine(charac.getRoutine().getCurrentRoutine().get(i).getClass().getName()));
			
		}
	}
	
	public String decryptRoutine(String name){
		switch(name){
		case "actions.Chilling":
			return "Chilling";
		case "actions.Sleeping":
			return "Sleeping";
		case "actions.Entertain":
			return "Entertain";
		case "actions.Shifting":
			return "Shifting";
		case "actions.Working":
			return "Working";
		default:
			return "Unknown";
		}
	}
	
	public void init(){
		this.initLabel();
		this.initGraph();
		this.initActionsList();
	}
	
	public void build(){
		this.add(id);
		this.add(chart);
		this.add(routine);
		back = new JButton("Back");
		back.addActionListener(new ActionBack());
		this.add(back);
	}
	
	public void setCharacter(NCharacter c){
		this.charac = c;
		this.refresh();
	}
	
	public void refresh(){
		age.setText("Age: " + charac.getAge());
		homeCoord.setText("Home: " + charac.getHome().getAddress().toString());
		work.setText("Work: " + charac.getWork().getName());
		this.refreshRoutineInfo();
	}
	
	class ActionBack implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
			parent.showList();
		}	
	}
	
	class ActionAddRoutine implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
			GUIAddAction window = new GUIAddAction(charac, map, run);
		}
	}
	
	class ActionRefreshRoutine implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
			refreshRoutineInfo();
		}
	}
	
	class ActionShowChart implements ActionListener{
		public void actionPerformed(ActionEvent e){
			
			System.out.println(e.getActionCommand());
			
			if(charac.getData().getEmotionHistoric().size()>0){
				//ChartActionRepartition chart = new ChartActionRepartition(currentCharacter);
				//ChartEmotionHistoricFull chart = new ChartEmotionHistoricFull(currentCharacter);
				//ChartEmotionHistoricDaily chart = new ChartEmotionHistoricDaily(currentCharacter);
				//ChartRewardRepartitionFull chart = new ChartRewardRepartitionFull(currentCharacter);
				//ChartActionRepartitionDaily chart = new ChartActionRepartitionDaily(currentCharacter);
				switch(e.getActionCommand()){
					case "D.Act":
						ChartActionRepartitionDaily chart = new ChartActionRepartitionDaily(charac);
						break;
					case "F.Emo":
						ChartEmotionHistoricFull chart1 = new ChartEmotionHistoricFull(charac);
						break;
					case "D.Emo":
						ChartEmotionHistoricDaily chart2 = new ChartEmotionHistoricDaily(charac);
						break;
					case "F.Rew":
						ChartRewardRepartitionFull chart3 = new ChartRewardRepartitionFull(charac);
						break;
					case "F.Act":
						ChartActionRepartitionFull chart4 = new ChartActionRepartitionFull(charac);
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
