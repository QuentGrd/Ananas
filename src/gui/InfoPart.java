package gui;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;

import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;

import city.Population;
import clock.Clock;

/**
 * 
 * @author matthieu
 *
 */
public class InfoPart extends JPanel{

	private Clock clock;
	private Population pop;
	
	private JPanel clockPart;
	private static Font clockFont = new Font(Font.MONOSPACED, Font.BOLD, 20);
	private JLabel secLabel;
	private JLabel minLabel;
	private JLabel hourLabel;
	private JLabel dayLabel;
	private JLabel monthLabel;
	private JLabel yearLabel;
	
	
	public InfoPart(Clock clock, Population pop){
		this.clock = clock;
		this.pop = pop;
		
		this.setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
		
		initClockPart();
		this.add(clockPart);
		this.setPreferredSize(new Dimension(400, 600));
	}
	
	public void initClockPart(){
		clockPart = new JPanel();
		clockPart.setLayout(new FlowLayout());
		
		clockPart.setFont(clockFont);
		
		hourLabel = new JLabel(String.valueOf(clock.getHours().getCounter()));
		hourLabel.setFont(clockFont);
		clockPart.add(hourLabel);
		clockPart.add(new JLabel(" : "));
		minLabel = new JLabel(String.valueOf(clock.getMin().getCounter()));
		minLabel.setFont(clockFont);
		clockPart.add(minLabel);
		clockPart.add(new JLabel(" : "));
		secLabel = new JLabel(String.valueOf(clock.getSec().getCounter()));
		secLabel.setFont(clockFont);
		clockPart.add(secLabel);
		clockPart.add(new JLabel(" - "));
		
		clockPart.add(new JLabel("("));
		dayLabel = new JLabel(String.valueOf(clock.getDays().getCounter()));
		dayLabel.setFont(clockFont);
		clockPart.add(dayLabel);
		clockPart.add(new JLabel("/"));
		monthLabel = new JLabel(String.valueOf(clock.getMonths().getCounter()));
		monthLabel.setFont(clockFont);
		clockPart.add(monthLabel);
		clockPart.add(new JLabel("/"));
		yearLabel = new JLabel(String.valueOf(clock.getYears().getCounter()));
		yearLabel.setFont(clockFont);
		clockPart.add(yearLabel);
		clockPart.add(new JLabel(")"));
	}
	
	public void refreshInfoPart(Clock clock){
		hourLabel.setText(String.valueOf(clock.getHours().getCounter()));
		minLabel.setText(String.valueOf(clock.getMin().getCounter()));
		secLabel.setText(String.valueOf(clock.getSec().getCounter()));
		dayLabel.setText(String.valueOf(clock.getDays().getCounter()));
		monthLabel.setText(String.valueOf(clock.getMonths().getCounter()));
		yearLabel.setText(String.valueOf(clock.getYears().getCounter()));
	}

	public void setSecLabel(JLabel secLabel) {
		this.secLabel = secLabel;
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
