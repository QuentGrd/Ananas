package qrcode;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Hashtable;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.WriterException;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.QRCodeWriter;
import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;


public class EndOfGameWindow extends JFrame{
	
	private JPanel back;
	private String url;

	public EndOfGameWindow(){

		this.initComponent();
		
		this.getContentPane().add(back);
		this.pack();
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setMinimumSize(new Dimension(400, 600));
		this.setTitle("End of game");
		this.setResizable(false);
		this.setLocationRelativeTo(null);
		this.setVisible(true);
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
		
	}
	
	

}
