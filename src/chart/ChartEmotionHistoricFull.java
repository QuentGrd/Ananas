package chart;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

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
public class ChartEmotionHistoricFull extends JFrame{

	private static final long serialVersionUID = -8881399308101213332L;
	private NCharacter character;
	
	private JPanel fond;
	private JButton refresh;
	
	private XYSeriesCollection dataset = null;
	
	public ChartEmotionHistoricFull(NCharacter character){
		super("Character : " + character.getFirstName());
		
		this.character = character;
		
		
		fond = new JPanel();
		fond.setLayout(new BorderLayout());
	    setContentPane(fond);
	    
	    dataset = new XYSeriesCollection();
	      
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
  
  		for(int i=0; i<character.getData().getEmotionHistoric().size(); i++){
  			ArrayList<Integer> rewards = character.getData().getEmotionHistoric(i);
  			final XYSeries series = new XYSeries(character.getData().getRewardType(i));
  			System.out.println(character.getData().getEmotionHistoric(i).toString());
  			for (int j = 0; j < rewards.size(); j++) {
  	 	  		series.add(j, character.getData().getEmotionHistoric(i).get(j));
			}
  			dataset.addSeries(series);
  		}
 	  	return dataset;
   }
	
	class ActionRefreshChart implements ActionListener{
		public void actionPerformed(ActionEvent e){
			dataset.removeAllSeries();
			for(int i=0; i<character.getData().getEmotionHistoric().size(); i++){
	  			ArrayList<Integer> rewards = character.getData().getEmotionHistoric(i);
	  			final XYSeries series = new XYSeries(character.getData().getRewardType(i));
	  			for (int j = 0; j < rewards.size(); j++) {
	  	 	  		series.add(j, character.getData().getEmotionHistoric(i).get(j));
				}
	  			dataset.addSeries(series);
	  		}
		}
	}
}
