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
import org.jfree.data.general.DefaultPieDataset;
import org.jfree.ui.RefineryUtilities;

import character.NCharacter;

/**
 * 
 * @author matthieu
 *
 */
public class ChartRewardRepartitionFull extends JFrame{

	private static final long serialVersionUID = -8881399308101213332L;
	private NCharacter character;
	
	private JPanel fond;
	private JButton refresh;
	
	private DefaultPieDataset dataset;
	
	public ChartRewardRepartitionFull(NCharacter character){
		super("Character : " + character.getFirstName());
		
		this.character = character;
		
		
		fond = new JPanel();
		fond.setLayout(new BorderLayout());
	    setContentPane(fond);
	    
	    dataset = new DefaultPieDataset();
	      
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
		JFreeChart chart = ChartFactory.createPieChart("Repartition of "+character.getFirstName()+"'s reward",createDataset(),true,true,false);
		
		ChartPanel chartPanel = new ChartPanel( chart );
	    chartPanel.setPreferredSize( new java.awt.Dimension( 560 , 367 ) );
	    fond.add(chartPanel, BorderLayout.CENTER);
	}
	private void initButton(){
		refresh = new JButton("Refresh");
		refresh.addActionListener(new ActionRefreshChart());
		
		fond.add(refresh, BorderLayout.SOUTH);
	}
	
	private DefaultPieDataset createDataset( ){
  
  		for(int i=0; i<character.getData().getRewardRepartition().size(); i++)
	  		dataset.setValue(character.getData().getRewardName(i), character.getData().getRewardRepartition().get(i));
  		return dataset;
   }
	
	class ActionRefreshChart implements ActionListener{
		public void actionPerformed(ActionEvent e){
			dataset.clear();
			for(int i=0; i<character.getData().getRewardRepartition().size(); i++)
		  		dataset.setValue(character.getData().getRewardName(i), character.getData().getRewardRepartition().get(i));
	  		
		}
	}
}
