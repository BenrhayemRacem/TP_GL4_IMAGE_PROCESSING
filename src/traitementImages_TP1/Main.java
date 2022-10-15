package traitementImages_TP1;

public class Main {

	public static void main(String[] args) {
		PGM pgmObj = new PGM( );
		try {
			pgmObj.readImage();
			pgmObj.writeImage();
			pgmObj.calculateMean();
			pgmObj.calculateStandardDesviation();
			pgmObj.calculateHistogram();
			pgmObj.calculateCumulativeHistogram();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
