package gui;

import java.awt.CardLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextPane;
import javax.swing.ListSelectionModel;

import city.Population;

/**
 * 
 * @author Quentin - matthieu
 *
 */
public class GUIInfoPart extends JPanel{

	private Population pop;
	
	private JPanel buttonPart;
	private JButton list;
	private JButton info;
	
	private CardLayout cl;
	private JPanel cardsContainer;
	
	private JPanel infoPart;
	private JTextPane infoText;
	private String textDefault = "First Name:\nName:\nID:\nEmotion\nHome:\nWork:\n";
	
	private JPanel characterListPanel;
	private static final String INFOPANEL = "Information Panel";
	private static final String CHARACTERPANEL = "Character list Panel";
	private JScrollPane listScroller;
	
	private JList<String> characterList;
	
	public GUIInfoPart(Population pop){
		this.pop = pop;
		this.initButtonPart();
		this.initCardLayout();
		this.setPreferredSize(new Dimension(400, 600));
		this.setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
		this.add(buttonPart);
		this.add(cardsContainer);
	}
	
	public void initCardLayout(){
		cl = new CardLayout();
		cardsContainer = new JPanel();
		this.initInfoPanel();
		this.initCharacterListPanel();
		cardsContainer.setLayout(cl);
		cardsContainer.add(characterListPanel, CHARACTERPANEL);
		cardsContainer.add(infoPart, INFOPANEL);
		cl.show(cardsContainer, CHARACTERPANEL);
	}
	
	public void initButtonPart(){
		buttonPart = new JPanel();
		info = new JButton("_info");
		list = new JButton("_list");
		info.addActionListener(new DisplayInfoAction());
		list.addActionListener(new DisplayListAction());
		buttonPart.setLayout(new FlowLayout());
		buttonPart.add(list);
		buttonPart.add(info);
	}
	
	public void initInfoPanel(){
		infoPart = new JPanel();
		infoText = new JTextPane();
		infoText.setEditable(false);
		infoText.setText(textDefault);
		infoText.setPreferredSize(new Dimension(390, 550));
		infoPart.add(infoText);
	}
	
	public void initCharacterListPanel(){
		characterListPanel = new JPanel();
		DefaultListModel<String> model = new DefaultListModel<String>();
		String[] list = pop.transform();
		for (int i = 0; i < list.length; i++) {
			model.addElement(list[i]);
		}
		characterList = new JList<String>(model);
		characterList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		characterList.setLayoutOrientation(JList.VERTICAL);
		characterList.setVisibleRowCount(-1);
		listScroller = new JScrollPane(characterList);
		listScroller.setPreferredSize(new Dimension(390, 550));
		characterListPanel.add(listScroller);
	}
	
	class DisplayInfoAction implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			cl.show(cardsContainer, INFOPANEL);
		}
		
	}
	
	class DisplayListAction implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			cl.show(cardsContainer, CHARACTERPANEL);
		}
		
	}
	
}
