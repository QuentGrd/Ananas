package gui;

import java.awt.Dimension;

import javax.swing.BoxLayout;
import javax.swing.JPanel;

import character.NCharacter;
import city.Map;
import run.Run;

/**
 * This class build the complete character information part of the GUI
 * @author quentin
 *
 */

public class GUICharacterInfo extends JPanel{
	
	private static final long serialVersionUID = 1313679868217650779L;
	
	private NCharacter currentCharacter;
	
	private GUIInfoPart parent;
	private Map map;
	
	private GUIGraphicCharacterID top;
	private GUICharacterID bot;

	public GUICharacterInfo(GUIInfoPart parent, Map map, Run run){
		this.parent = parent;
		this.setBackground(GUIColor.background);
		this.setPreferredSize(new Dimension(400, 600));
		this.setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
		top = new GUIGraphicCharacterID();
		bot = new GUICharacterID(parent, map, run);
		this.add(top);
		this.add(bot);
	}
	
	public void setCharacter(NCharacter c){
		this.currentCharacter = c;
		top.setCharactert(c);
		bot.setCharacter(c);
	}
	
	public NCharacter getCharacter(){
		return this.currentCharacter;
	}

}
