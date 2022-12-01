package traitementImages_TP1;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;

public class Main {

	public static void main(String[] args) {
		PGM pgmObj = new PGM( );
		
		try {
//			pgmObj.readImage("balloons_noisy.ascii.pgm");
			//pgmObj.readImageV2("balloons_noisy.ascii.pgm");
			//pgmObj.writeImage("writeImage.pgm");
//			pgmObj.calculateMean();
//			pgmObj.calculateStandardDesviation();
//			pgmObj.calculateHistogram();
//			pgmObj.calculateCumulativeHistogram();
			//Stats pgmStats = new Stats();
			//pgmStats.calculerProbabiliteCumulee();
			//pgmStats.calculerHistogrammeLegalise();
			//pgmStats.contraste_LUT(20, 20, 50, 50);
			//pgmStats.newImageAfterContraste();
			
			Filters pgmFilters = new Filters();
			//pgmFilters.bruit();
			//pgmFilters.addPaddingToImage();
			pgmFilters.medianFilter(5);
			//pgmFilters.meanFilter(5);
			short[] values = {1,-2,1,-2,5,-2,1,-2,1};
			pgmFilters.rehausserContourFilter(values);
//			JFrame f=new JFrame();//creating instance of JFrame    
//			f.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
//			JButton b=new JButton("click");//creating instance of JButton  
//			b.setBounds(130,100,100,40);
//			f.add(b);//adding button in JFrame        
//			f.setSize(400,500);//400 width and 500 height  
//			//f.setLayout(null);//using no layout managers  
//			f.setVisible(true);//making the frame visible
//
//	        
//	        final BufferedImage image = ImageIO.read(new File("C:\\Users\\MSI\\Desktop\\ali.png"));
//
//	        JPanel pane = new JPanel() {
//	            /**
//				 * 
//				 */
//				private static final long serialVersionUID = 5499105979591387181L;
//
//				@Override
//	            protected void paintComponent(Graphics g) {
//	                super.paintComponent(g);
//	                g.drawImage(image, 0, 0, null);
//	            }
//	        };
//	        f.add(pane);
	   

			//BufferedImage myPicture = ImageIO.read(new File("path-to-file"));
//			try {                
//				BufferedImage  image = ImageIO.read(new File("chat2.pgm"));
//				JPanel j = new JPanel() ;
//				
//		       } catch (IOException ex) {
//		            // handle exception...
//		       }
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
