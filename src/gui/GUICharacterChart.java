package gui;

import javax.swing.JFrame;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.ui.RefineryUtilities;

import character.Character;

/**
 * 
 * @author matthieu
 *
 */
public class GUICharacterChart extends JFrame{

	private static final long serialVersionUID = -8881399308101213332L;
	private Character character;
	
	public GUICharacterChart(Character character){
		super("Character : " + character.getFirstName());
		
		this.character = character;
		JFreeChart lineChart = ChartFactory.createLineChart("Evolution of "+character.getFirstName()+"'s emotion","Time","Emotion",createDataset(),PlotOrientation.VERTICAL,true,true,false);
		
		ChartPanel chartPanel = new ChartPanel( lineChart );
	    chartPanel.setPreferredSize( new java.awt.Dimension( 560 , 367 ) );
	    setContentPane( chartPanel );
	      
		this.pack();
		//position centrale
		RefineryUtilities.centerFrameOnScreen(this);
		//ferme la fenetre et non l'application
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.setVisible(true);
	}
	
	private DefaultCategoryDataset createDataset( ){
		DefaultCategoryDataset dataset = new DefaultCategoryDataset();
  
  		for(int i=0; i<character.getEmotionHistoric().size(); i++)
	  		dataset.addValue(character.getEmotionHistoric().get(i) , "Emotion" , String.valueOf(i) );
  		return dataset;
   }
}
