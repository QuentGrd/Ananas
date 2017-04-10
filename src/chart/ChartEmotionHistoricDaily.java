package chart;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;
import org.jfree.ui.RefineryUtilities;

import character.NCharacter;

/**
 * 
 * @author matthieu
 *
 */
public class ChartEmotionHistoricDaily extends JFrame{

	private static final long serialVersionUID = -8881399308101213332L;
	private NCharacter character;
	
	private JPanel fond;
	private JButton refresh;
	
	private XYSeriesCollection data;
	
	public ChartEmotionHistoricDaily(NCharacter character){
		super("Character : " + character.getFirstName());
		
		this.character = character;
		
		
		fond = new JPanel();
		fond.setLayout(new BorderLayout());
	    setContentPane(fond);
	    
	    data = new XYSeriesCollection();
	      
	    initChart();
	    initButton();
	    
		this.pack();
		//position centrale
		RefineryUtilities.centerFrameOnScreen(this);
		//ferme la fenetre et non l'application
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.setVisible(true);
	}
	
	private void initChart(){
		JFreeChart lineChart = ChartFactory.createXYLineChart("Evolution of "+character.getFirstName()+"'s emotion","Time","Emotion",createDataset(),PlotOrientation.VERTICAL,true,true,false);
		
		ChartPanel chartPanel = new ChartPanel( lineChart );
	    chartPanel.setPreferredSize( new java.awt.Dimension( 560 , 367 ) );
	    fond.add(chartPanel, BorderLayout.CENTER);
	}
	private void initButton(){
		refresh = new JButton("Refresh");
		refresh.addActionListener(new ActionRefreshChart());
		
		fond.add(refresh, BorderLayout.SOUTH);
	}
	
	private XYSeriesCollection createDataset( ){
  
		
		XYSeries yesterdaySerie = new XYSeries("Yesterday");
  		for(int i=0; i<character.getData().getEmotionHistoricYesterday(0).size(); i++)
	  		yesterdaySerie.add(i,character.getData().getEmotionHistoricYesterday(0).get(i));
  		
  		XYSeries todaySerie = new XYSeries("Today");
  		for (int i = 0; i < character.getData().getEmotionHistoricToday(0).size(); i++)
			todaySerie.add(i, character.getData().getEmotionHistoricToday(0).get(i));
  			
  		data.addSeries(yesterdaySerie);
  		data.addSeries(todaySerie);
  		return data;
   }
	
	class ActionRefreshChart implements ActionListener{
		public void actionPerformed(ActionEvent e){
			data.removeAllSeries();
			XYSeries yesterdaySerie = new XYSeries("Yesterday");
	  		for(int i=0; i<character.getData().getEmotionHistoricYesterday(0).size(); i++)
		  		yesterdaySerie.add(i,character.getData().getEmotionHistoricYesterday(0).get(i));
	  		
	  		XYSeries todaySerie = new XYSeries("Today");
	  		for (int i = 0; i < character.getData().getEmotionHistoricToday(0).size(); i++)
				todaySerie.add(i, character.getData().getEmotionHistoricToday(0).get(i));
	  			
	  		data.addSeries(yesterdaySerie);
	  		data.addSeries(todaySerie);
		}
	}
}
