package traitementImages_TP1;

import java.util.Random;

public class Filters {
	PGM pgmImage = new PGM();
	
	Filters() {
		try {
			pgmImage.readImage("chat2.pgm");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void bruit() throws Exception {
		Random rand = new Random();
		for (int i = 0; i < pgmImage.lx; i++) {
			for (int k = 0; k < pgmImage.ly; k++) {
				int random_number = rand.nextInt(21);
				if(random_number == 0) {
					pgmImage.image[i][k]  = 0;
				}
				if(random_number ==20) {
					pgmImage.image[i][k]  = 20;
				}
				
			}

		}
		pgmImage.writeImage("afterContrasteModif.pgm");

		
	}
	
	public void medianFilter(int taille) {
		short[][] imageWithPadding = new short[pgmImage.lx+2] [pgmImage.ly+2] ;
		imageWithPadding[0] = pgmImage.image[0] ;
		imageWithPadding[pgmImage.lx+1] = pgmImage.image[pgmImage.lx-1] ;
		for(int i =0 ; i < pgmImage.ly ; i++) {
			imageWithPadding[i+1][0] = pgmImage.image[i][0] ;
			imageWithPadding[i+1][pgmImage.ly+1] = pgmImage.image[i][pgmImage.lx-1];
			
		}
		
	}
}
