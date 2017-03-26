package chart;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

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
public class ChartActionRepartition extends JFrame{

	private static final long serialVersionUID = -8881399308101213332L;
	private Character character;
	
	private JPanel fond;
	private JButton refresh;
	
	DefaultCategoryDataset dataset;
	
	public ChartActionRepartition(Character character){
		super("Character : " + character.getFirstName());
		
		this.character = character;
		
		
		fond = new JPanel();
		fond.setLayout(new BorderLayout());
	    setContentPane(fond);
	    
	    dataset = new DefaultCategoryDataset();
	      
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
		JFreeChart barChart = ChartFactory.createBarChart("Repartition of "+character.getFirstName()+"'s actions","Actions","",createDataset(),PlotOrientation.VERTICAL,true,true,false);
		
		ChartPanel chartPanel = new ChartPanel( barChart );
	    chartPanel.setPreferredSize( new java.awt.Dimension( 560 , 367 ) );
	    fond.add(chartPanel, BorderLayout.CENTER);
	}
	private void initButton(){
		refresh = new JButton("Refresh");
		refresh.addActionListener(new ActionRefreshChart());
		
		fond.add(refresh, BorderLayout.SOUTH);
	}
	
	private DefaultCategoryDataset createDataset( ){
  
  		for(int i=0; i<character.getData().getActionRepartition().size(); i++)
	  		dataset.addValue(character.getData().getActionRepartition().get(i) , "Action Repartition" , character.getData().getActionName(i) );
  		return dataset;
   }
	
	class ActionRefreshChart implements ActionListener{
		public void actionPerformed(ActionEvent e){
			dataset.clear();
			for(int i=0; i<character.getData().getActionRepartition().size(); i++)
		  		dataset.addValue(character.getData().getActionRepartition().get(i) , "Action Repartition" , character.getData().getActionName(i) );
		}
	}
}
