package gui;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;

import utils.Coordinates;

public class Cell extends JPanel{

	public static final int CELL_SIZE = 1;
    private Coordinates coord;
    private JLabel info;

    public Cell (int x, int y) {
        coord = new Coordinates(x, y);
        setOpaque(true);
        setBorder(BorderFactory.createLineBorder(Color.BLACK));
        setBackground(new Color(105, 120, 105));
        setPreferredSize(new Dimension(CELL_SIZE, CELL_SIZE));
        info = new JLabel("");
        this.add(info);
    }

	public Coordinates getCoord() {
		return coord;
	}

	public void setCoord(Coordinates coord) {
		this.coord = coord;
	}

	public JLabel getInfo() {
		return info;
	}

	public void setInfo(JLabel info) {
		this.info = info;
	}
}
