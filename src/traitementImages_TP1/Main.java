package traitementImages_TP1;

public class Main {

	public static void main(String[] args) {
		PGM pgmObj = new PGM( );
		
		try {
//			pgmObj.readImage("chat2.pgm");
//			pgmObj.writeImage("writeImage.pgm");
//			pgmObj.calculateMean();
//			pgmObj.calculateStandardDesviation();
//			pgmObj.calculateHistogram();
//			pgmObj.calculateCumulativeHistogram();
			Stats pgmStats = new Stats();
			pgmStats.calculerProbabiliteCumulee();
			pgmStats.calculerHistogrammeLegalise();
			pgmStats.contraste_LUT(20, 20, 50, 50);
			//pgmStats.newImageAfterContraste();
			
			Filters pgmFilters = new Filters();
			//pgmFilters.bruit();
			pgmFilters.addPaddingToImage();
			pgmFilters.medianFilter(5);
			pgmFilters.meanFilter(5);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
