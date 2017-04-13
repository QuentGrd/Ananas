package gui;

import java.awt.Dimension;

import javax.swing.BoxLayout;
import javax.swing.JPanel;

import character.NCharacter;
import city.Map;

public class GUICharacterInfo extends JPanel{
	
	private static final long serialVersionUID = 1313679868217650779L;
	
	private NCharacter currentCharacter;
	
	private GUIInfoPart parent;
	private Map map;
	
	private GUIGraphicCharacterID top;
	private GUICharacterID bot;

	public GUICharacterInfo(GUIInfoPart parent, Map map){
		this.parent = parent;
		this.setPreferredSize(new Dimension(400, 600));
		this.setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
		top = new GUIGraphicCharacterID();
		bot = new GUICharacterID(parent, map);
		this.add(top);
		this.add(bot);
	}
	
	public void setCharacter(NCharacter c){
		this.currentCharacter = c;
		top.setCharactert(c);
		bot.setCharacter(c);
	}

}
