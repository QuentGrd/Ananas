package gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import run.NRun;
import run.QRun;

public class GUIMainMenu extends JFrame{

	private static final long serialVersionUID = 6386363257594856967L;
	
	private JPanel buttonPanel;
	private JButton normal;
	private JButton auto;
	private JButton exitButton;
	
	private static int mode;
	private static boolean choose;
	private static boolean exit;

	public GUIMainMenu(){
		this.initComponent();
		this.addListener();
		this.getContentPane().add(buttonPanel);
		this.pack();
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		//this.setMinimumSize(new Dimension(600, 600));
		this.setTitle("MainMenu");
		this.setResizable(false);
		this.setLocationRelativeTo(null);
		this.setVisible(true);
		exit = false;
	}
	
	public void initComponent(){
		buttonPanel = new JPanel();
		buttonPanel.setLayout(new BoxLayout(buttonPanel, BoxLayout.PAGE_AXIS));
		normal = new JButton("Normal mode");
		auto = new JButton("Auto mode");
		exitButton = new JButton("Exit");
		buttonPanel.add(normal);
		buttonPanel.add(auto);
		buttonPanel.add(exitButton);
	}
	
	public void addListener(){
		normal.addActionListener(new NormalModeListener());
		auto.addActionListener(new AutoModeListener());
		exitButton.addActionListener(new ExitListener());
	}
	
	class NormalModeListener implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
			/*NRun run = new NRun();
			run.initialisation();
			run.run();*/
			mode = 1;
			choose = true;
		}
	}
	
	class AutoModeListener implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
			/*QRun run = new QRun();
			run.initialisation();
			run.run();*/
			mode = 2;
			choose = true;
		}
	}
	
	class ExitListener implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
			exit = true;
		}
	}
	
	public static void main(String[] args){
		GUIMainMenu menu = new GUIMainMenu();
		while (!exit){
			System.out.print(" "); //Il faut trouver une autre instruction (orienté poubelle)
			switch(mode){
				case 1:
					menu.setVisible(false);
					NRun nrun = new NRun();
					nrun.initialisation();
					nrun.run();
					menu.setVisible(true);
					choose = false;
					mode = 0;
					break;
				case 2:
					menu.setVisible(false);
					QRun qrun = new QRun();
					qrun.initialisation();
					qrun.run();
					menu.setVisible(true);
					choose = false;
					mode = 0;
					break;
			}
		}
		System.exit(0);
	}
	
}
