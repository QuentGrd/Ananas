package qrcode;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Hashtable;

import javax.imageio.ImageIO;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.WriterException;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.QRCodeWriter;
import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;
import com.sun.javafx.css.CalculatedValue;

public class QRCodeGenerator {

	private String begin;
	private String end;
	private String score;
	
	private String lvl;
	
	private String url;
	
	public QRCodeGenerator(String begin, String end, String lvl){
		this.begin = begin;
		this.end = end;
		score = calculScore(begin, end);
		
		this.lvl = lvl;
		
		generateImage(begin, end);
	}
	
	public void generateImage(String timeBegin, String timeEnd){
		String score = calculScore(timeBegin, timeEnd);
		System.out.println("SCORE = " + score);
		url = "https://10.40.128.22/~qgerard/glpweb/enregistrement.php?lvl="+lvl+"&score="+score;/*/?b="+timeBegin+"&?e="+timeEnd;*/
		String filePath = "./qrcode/qrcode.png";
		int size = 400;
		String fileType = "png";
		File qrFile = new File(filePath);
		try {
			createQRImage(qrFile, url, size, fileType);
		} catch (WriterException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	private static void createQRImage(File qrFile, String qrCodeText, int size, String fileType) throws WriterException, IOException {
		// Create the ByteMatrix for the QR-Code that encodes the given String
		Hashtable hintMap = new Hashtable();
		hintMap.put(EncodeHintType.ERROR_CORRECTION, ErrorCorrectionLevel.L);
		QRCodeWriter qrCodeWriter = new QRCodeWriter();
		BitMatrix byteMatrix = qrCodeWriter.encode(qrCodeText,BarcodeFormat.QR_CODE, size, size, hintMap);
		// Make the BufferedImage that are to hold the QRCode
		int matrixWidth = byteMatrix.getWidth();
		BufferedImage image = new BufferedImage(matrixWidth, matrixWidth,BufferedImage.TYPE_INT_RGB);
		image.createGraphics();

		Graphics2D graphics = (Graphics2D) image.getGraphics();
		graphics.setColor(Color.WHITE);
		graphics.fillRect(0, 0, matrixWidth, matrixWidth);
		// Paint and save the image using the ByteMatrix
		graphics.setColor(Color.BLACK);

		for (int i = 0; i < matrixWidth; i++) {
			for (int j = 0; j < matrixWidth; j++) {
				if (byteMatrix.get(i, j)) {
					graphics.fillRect(i, j, 1, 1);
				}
			}
		}
		ImageIO.write(image, fileType, qrFile);
	}
	
	public String calculScore(String begin, String end){
		String[] tabB = begin.split(" "); 
		String[] tabE = end.split(" ");
		
		String[] timeB = tabB[1].split(":");
		String[] timeE = tabE[1].split(":");
		
		int flag = 0;
		
		int score = 0 ;
		int minute = Integer.parseInt(timeE[1]) - Integer.parseInt(timeB[1]);	
		int hour = Integer.parseInt(timeE[0]) - Integer.parseInt(timeB[0]);
		if(minute < 0){
			score = hour*60 - Math.abs(minute);
		}
		else{
			score = Math.abs(minute) + 60*hour;
		}
		
		return String.valueOf(score);
	}

	public String getBegin() {
		return begin;
	}

	public void setBegin(String begin) {
		this.begin = begin;
	}

	public String getEnd() {
		return end;
	}

	public void setEnd(String end) {
		this.end = end;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}
}
