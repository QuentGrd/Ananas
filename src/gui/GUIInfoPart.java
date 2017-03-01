package gui;

import java.awt.CardLayout;
import java.awt.Dimension;

import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JTable;

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
	private static final String INFOPANEL = "Information Panel";
	private static final String CHARACTERPANEL = "Character list Panel";
	
	private JList characterList;
	
	public GUIInfoPart(Population pop){
		this.pop = pop;
		this.setPreferredSize(new Dimension(400, 600));
	}
	
	public void initCardLayout(){
		infoPart = new JPanel();
		cardsContainer = new JPanel();
		characterListPanel = new JPanel();
		cardsContainer.setLayout(new CardLayout());
		cardsContainer.add(characterListPanel, CHARACTERPANEL);
		cardsContainer.add(infoPart, INFOPANEL);
	}
	
	public void initCharacterListPanel(){
		characterList = new JList();
		
	}
	
	
}
