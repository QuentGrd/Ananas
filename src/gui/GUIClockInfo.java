package gui;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JPanel;

import clock.Clock;

public class GUIClockInfo extends JPanel{
	
	private Clock clock;
	
	private JPanel clockPart;
	private static Font clockFont = new Font(Font.MONOSPACED, Font.BOLD, 20);
	private JLabel minLabel;
	private JLabel hourLabel;
	private JLabel dayLabel;
	private JLabel monthLabel;
	private JLabel yearLabel;
	
	public GUIClockInfo(Clock clock){
		this.clock = clock;
		this.initClockPart();
		this.setPreferredSize(new Dimension(800, 50));
		this.add(clockPart);
	}
	
	public void initClockPart(){
		clockPart = new JPanel();
		clockPart.setLayout(new FlowLayout());
		
		clockPart.setFont(clockFont);
		
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
	}
	
	public void refreshClock(Clock clock){
		hourLabel.setText(Clock.transform(clock.getHours().getCounter()));
		minLabel.setText(Clock.transform(clock.getMin().getCounter()));
		dayLabel.setText(Clock.transform(clock.getDays().getCounter()));
		monthLabel.setText(Clock.transform(clock.getMonths().getCounter()));
		yearLabel.setText(Clock.transform(clock.getYears().getCounter()));
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
