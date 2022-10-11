package traitementImages_TP1;

public class Main {

	public static void main(String[] args) {
		PGM pgmObj = new PGM( );
		try {
			pgmObj.readImage();
			pgmObj.writeImage();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
