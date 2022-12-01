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
			//short[] values = {1,-2,1,-2,5,-2,1,-2,1};
			//pgmFilters.rehausserContourFilter(values);
//			
			double result = pgmFilters.SNR("balloons_noisy.ascii.pgm", "afterMedianFilter.pgm");

			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
