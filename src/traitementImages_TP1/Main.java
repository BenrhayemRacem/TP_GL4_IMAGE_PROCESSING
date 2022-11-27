package traitementImages_TP1;

public class Main {

	public static void main(String[] args) {
		PGM pgmObj = new PGM( );
		
		try {
//			pgmObj.readImage();
//			pgmObj.writeImage("writeImage.pgm");
//			pgmObj.calculateMean();
//			pgmObj.calculateStandardDesviation();
//			pgmObj.calculateHistogram();
//			pgmObj.calculateCumulativeHistogram();
			Stats pgmStats = new Stats();
			pgmStats.calculerProbabiliteCumulee();
			pgmStats.calculerHistogrammeLegalise();
			pgmStats.contraste_LUT(120, 120, 200, 200);
			pgmStats.newImageAfterContraste();
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
