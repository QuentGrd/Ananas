package gui;

import java.awt.CardLayout;
import java.awt.Dimension;

import javax.swing.DefaultListModel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;

import city.Population;

/**
 * 
 * @author matthieu
 *
 */
public class GUIInfoPart extends JPanel{

	private Population pop;
	
	private JPanel buttonPart;
	private JPanel cardsContainer;
	private JPanel infoPart;
	private JPanel characterListPanel;
	private CardLayout cl;
	private static final String INFOPANEL = "Information Panel";
	private static final String CHARACTERPANEL = "Character list Panel";
	private JScrollPane listScroller;
	
	private JList characterList;
	
	public GUIInfoPart(Population pop){
		this.pop = pop;
		this.initCharacterListPanel();
		this.initCardLayout();
		this.setPreferredSize(new Dimension(400, 600));
		this.add(cardsContainer);
	}
	
	public void initCardLayout(){
		cl = new CardLayout();
		infoPart = new JPanel();
		cardsContainer = new JPanel();
		characterListPanel = new JPanel();
		cardsContainer.setLayout(cl);
		cardsContainer.add(characterListPanel, CHARACTERPANEL);
		cardsContainer.add(infoPart, INFOPANEL);
		cl.show(cardsContainer, CHARACTERPANEL);
	}
	
	public void initCharacterListPanel(){
		DefaultListModel<String> model = new DefaultListModel<String>();
		String[] list = this.transform();
		for (int i = 0; i < list.length; i++) {
			model.addElement(list[i]);
		}
		characterList = new JList<String>(model);
		characterList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		characterList.setLayoutOrientation(JList.HORIZONTAL_WRAP);
		characterList.setVisibleRowCount(-1);
		listScroller = new JScrollPane(characterList);
		listScroller.setPreferredSize(new Dimension(400, 600));
	}
	
	public String[] transform(){
		character.Character[] list = pop.getCharacterTab();
		String nameList[];
		nameList = new String[list.length];
		int i;
		for (i=0; i<list.length; i++){
			nameList[i] = list[i].getFirstName() + list[i].getName();
		}
		return nameList;
	}
	
}
