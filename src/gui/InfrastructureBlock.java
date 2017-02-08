package gui;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JPanel;

import utils.Coordinates;

/**
 * This class represent an infrastructure in GUI
 * @author quentin
 *
 */

public class InfrastructureBlock extends JPanel implements MouseListener{

	private static final long serialVersionUID = -2105732907443618048L;
	
	Coordinates location;
	public InfrastructureBlock(int x, int y){
		location = new Coordinates(x, y);
		this.addMouseListener(this);
	}

	public int getX(){
		return location.getX();
	}
	
	public int getY(){
		return location.getY();
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		System.out.println(e.getComponent());
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

}
