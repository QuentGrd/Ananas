package gui;

import java.awt.CardLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.BoxLayout;
import javax.swing.JPanel;

import character.NCharacter;
import city.Map;
import city.Population;
import run.Run;

/**
 * 
 * @author Quentin - matthieu
 *
 */
public class GUIInfoPart extends JPanel{

	private static final long serialVersionUID = -560584172594140952L;

	private Population pop;
	
	private boolean printCircle;
	
	private CardLayout cl;
	private JPanel cardsContainer;
	
	private GUIGraphicsList ginfo;
	private GUICharacterInfo cinfo;
	private static final String INFOPANEL = "Information Panel";
	private static final String CHARACTERPANEL = "Character list Panel";
	
	public GUIInfoPart(Population pop, Map map, int mode, Run run){
		this.pop = pop;
		this.printCircle = false;
		ginfo = new GUIGraphicsList(pop);
		cinfo = new GUICharacterInfo(this, map, run);
		this.initCardLayout(mode);
		this.setPreferredSize(new Dimension(400, 600));
		this.setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
		this.add(cardsContainer);
	}
	
	public void initCardLayout(int mode){
		if (mode == 0)
			ginfo.addMouseListener(new MouseListListener());
		cl = new CardLayout();
		cardsContainer = new JPanel();
		cardsContainer.setLayout(cl);
		cardsContainer.add(ginfo, CHARACTERPANEL);
		cardsContainer.add(cinfo, INFOPANEL);
		cl.show(cardsContainer, CHARACTERPANEL);
	}
	
	public void refesh(){
		ginfo.repaint();
	}
	
	public void showList(){
		this.cl.show(cardsContainer, CHARACTERPANEL);
		this.printCircle = false;
	}
	
	public boolean isPrintCircle() {
		return printCircle;
	}

	public void setPrintCircle(boolean printCircle) {
		this.printCircle = printCircle;
	}
	
	public NCharacter getCharacter(){
		return cinfo.getCharacter();
	}

	class MouseListListener implements MouseListener{
		@Override
		public void mouseClicked(MouseEvent e) {
			System.out.println("Index: " + ginfo.getPopIndex(e.getX(), e.getY()));
			NCharacter charac = (NCharacter) pop.getListCharacter().get(ginfo.getPopIndex(e.getX(), e.getY()));
			cinfo.setCharacter(charac);
			printCircle = true;
			cl.show(cardsContainer, INFOPANEL);
		}

		@Override
		public void mousePressed(MouseEvent e) {
		}

		@Override
		public void mouseReleased(MouseEvent e) {
		}

		@Override
		public void mouseEntered(MouseEvent e) {
		}

		@Override
		public void mouseExited(MouseEvent e) {
		}
		
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
