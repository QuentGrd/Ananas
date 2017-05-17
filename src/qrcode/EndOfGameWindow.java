package qrcode;

import java.awt.Desktop;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.net.URI;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;


public class EndOfGameWindow extends JFrame{
	
	private JPanel back;
	private String url;
	
	private JButton link ;
	
	private QRCodeGenerator generator;

	public EndOfGameWindow(QRCodeGenerator generator){

		this.generator = generator;
		url = generator.getUrl();
		
		this.initComponent();
		
		this.getContentPane().add(back);
		this.setMinimumSize(new Dimension(400, 600));
		this.setTitle("End of game");
		this.setResizable(false);
		this.setLocationRelativeTo(null);
		this.setVisible(true);
		this.setAlwaysOnTop(true);
	}
	
	public void initComponent(){
		back = new JPanel()
		{
			protected void paintComponent(Graphics g) 
            {
                super.paintComponent(g);
 
                ImageIcon m = new ImageIcon(new File(System.getProperty("user.dir") + "/qrcode/qrcode.png").getPath());
                Image monImage = m.getImage();
                g.drawImage(monImage, 0, 100,this);
 
            }
		};
		
		back.setLayout(null);
		
		JLabel title = new JLabel("Fin de la partie");
		Font font = new Font("Arial",Font.BOLD,35);
		title.setFont(font);
		back.add(title);
		title.setBounds(50, 10, 490, 100);
		
		link = new JButton("Link to register");
		link.addActionListener(new ActionRegisterListener());
		back.add(link);
		link.setBounds(110, 525, 180, 30);
		
	}
	
	class ActionRegisterListener implements ActionListener{
		public void actionPerformed(ActionEvent e){
			System.out.println(url);
			URI uri = URI.create(url);
			try {
				Desktop.getDesktop().browse(uri);
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
	}

}
