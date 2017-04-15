package gui;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import clock.Clock;
import run.NRun;
import run.QRun;

public class GUIClockInfo extends JPanel{
	
	private Clock clock;
	
	private JPanel clockPart;
	private static Font clockFont = new Font(Font.MONOSPACED, Font.BOLD, 20);
	private JLabel minLabel;
	private JLabel hourLabel;
	private JLabel dayLabel;
	private JLabel monthLabel;
	private JLabel yearLabel;
	private JButton playPause;
	private JButton menu;
	
	private JButton x1speed;
	private JButton x2speed;
	private JButton x5speed;
	
	public GUIClockInfo(Clock clock){
		this.clock = clock;
		this.initClockPart();
		this.setBackground(GUIMain.background);
		this.setPreferredSize(new Dimension(800, 50));
		this.add(clockPart);
	}
	
	public void initClockPart(){
		clockPart = new JPanel();
		clockPart.setBackground(GUIMain.background);
		clockPart.setLayout(new FlowLayout());
		
		clockPart.setFont(clockFont);
		
		menu = new JButton("Menu");
		menu.addActionListener(new MenuAction());
		clockPart.add(menu);
		
		playPause = new JButton("Pause");
		playPause.addActionListener(new PlayPauseAction());
		clockPart.add(playPause);
		
		hourLabel = new JLabel(Clock.transform(clock.getHours().getCounter()));
		hourLabel.setFont(clockFont);
		clockPart.add(hourLabel);
		clockPart.add(new JLabel(" : "));
		minLabel = new JLabel(Clock.transform(clock.getMin().getCounter()));
		minLabel.setFont(clockFont);
		clockPart.add(minLabel);
		clockPart.add(new JLabel(" - "));
		
		clockPart.add(new JLabel("("));
		dayLabel = new JLabel(Clock.transform(clock.getDays().getCounter()));
		dayLabel.setFont(clockFont);
		clockPart.add(dayLabel);
		clockPart.add(new JLabel("/"));
		monthLabel = new JLabel(Clock.transform(clock.getMonths().getCounter()));
		monthLabel.setFont(clockFont);
		clockPart.add(monthLabel);
		clockPart.add(new JLabel("/"));
		yearLabel = new JLabel(Clock.transform(clock.getYears().getCounter()));
		yearLabel.setFont(clockFont);
		clockPart.add(yearLabel);
		clockPart.add(new JLabel(")"));
		
		x1speed = new JButton(">");
		x2speed = new JButton(">>");
		x5speed = new JButton(">>>");
		
		x1speed.addActionListener(new ActionChangeSpeed());
		x2speed.addActionListener(new ActionChangeSpeed());
		x5speed.addActionListener(new ActionChangeSpeed());
		
		clockPart.add(x1speed);
		clockPart.add(x2speed);
		clockPart.add(x5speed);
		
	}
	
	public void refreshClock(Clock clock){
		hourLabel.setText(Clock.transform(clock.getHours().getCounter()));
		minLabel.setText(Clock.transform(clock.getMin().getCounter()));
		dayLabel.setText(Clock.transform(clock.getDays().getCounter()));
		monthLabel.setText(Clock.transform(clock.getMonths().getCounter()));
		yearLabel.setText(Clock.transform(clock.getYears().getCounter()));
	}
	
	class PlayPauseAction implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
			NRun.switchPlayStatus();
			QRun.switchPlayStatus();
			if (NRun.isPlay())
				playPause.setText("Pause");
			else
				playPause.setText("Play");
		}
	}
	
	class MenuAction implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
			NRun.switchRun();
			QRun.switchRun();
		}
	}
	
	class ActionChangeSpeed implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
			switch(e.getActionCommand()){
				case ">":
					NRun.setSpeed(500);
					QRun.setSpeed(500);
					break;
				case ">>":
					NRun.setSpeed(100);
					QRun.setSpeed(100);
					break;
				case ">>>":
					NRun.setSpeed(50);
					QRun.setSpeed(50);
					break;
			}
		}
	}

	public void setMinLabel(JLabel minLabel) {
		this.minLabel = minLabel;
	}

	public void setHourLabel(JLabel hourLabel) {
		this.hourLabel = hourLabel;
	}

	public void setDayLabel(JLabel dayLabel) {
		this.dayLabel = dayLabel;
	}

	public void setMonthLabel(JLabel monthLabel) {
		this.monthLabel = monthLabel;
	}

	public void setYearLabel(JLabel yearLabel) {
		this.yearLabel = yearLabel;
	}

	public static Font getClockFont() {
		return clockFont;
	}

}
