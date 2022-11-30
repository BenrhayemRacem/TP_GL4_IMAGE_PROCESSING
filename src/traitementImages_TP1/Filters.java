package traitementImages_TP1;

import java.util.Collections;
import java.util.Random;
import java.util.Vector;

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
		pgmImage.writeImage("afterBruit.pgm");

		
	}
	
	public void addPaddingToImage() {
		int width = pgmImage.lx ;
		int height = pgmImage.ly ;
		short[][] imageWithPadding = new short[width+2] [height+2] ;

//		imageWithPadding[0] = pgmImage.image[0] ;
//		imageWithPadding[width+1] = pgmImage.image[width-1] ;
//		for(int i =0 ; i < width ; i++) {
//			imageWithPadding[i+1][0] = pgmImage.image[i][0] ;
//			imageWithPadding[i+1][height+1] = pgmImage.image[i][height-1];
//			
//		}
		for(int i=0 ; i<width ; i++) {
			for(int j=0 ; j<height ; j++) {
				imageWithPadding[i+1][j+1] = pgmImage.image[i][j];
			}
		}
		
		for(int j=0 ; j<height ; j++) {
			imageWithPadding[0][j+1]=pgmImage.image[0][j];
			imageWithPadding[width+1][j+1]=pgmImage.image[width-1][j];

		}
		
		for(int i=0 ; i< width ; i++) {
			imageWithPadding[i+1][0]= pgmImage.image[i][0];
			imageWithPadding[i+1][height+1] = pgmImage.image[i][height-1];
			
		}
		imageWithPadding[0][0] = pgmImage.image[0][0];
		imageWithPadding[0][height+1] = pgmImage.image[0][height-1];
		imageWithPadding[width+1][0] = pgmImage.image[width-1][0];
		imageWithPadding[width+1][height+1] = pgmImage.image[width-1][height-1];
		
		try {
			pgmImage.writeImage("imageWithPadding.pgm" ,width+2 ,height+2 , imageWithPadding);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	public void meanFilter(int taille) {
		int boundary = (taille -1) /2 ;
		for(int i=0 ; i< pgmImage.lx; i++) {
			for(int j=0 ; j<pgmImage.ly ; j++) {
				int rowStart = i -boundary ; 
				int rowEnd = i+ boundary;
				int columnStart = j-boundary;
				int columnEnd = j+boundary ;
				if((rowStart <0)||(rowEnd >= pgmImage.lx) || (columnStart<0) 
						||(columnEnd>=pgmImage.ly)) {
					continue;
				}
				
				Vector<Short> values = new Vector<Short>();
				for (int ii=rowStart ; ii<=rowEnd ; ii++) {
					for(int jj=columnStart ; jj <=columnEnd ; jj++) {
						values.add(pgmImage.image[ii][jj]);
					}
				}
				short meanValue =this.calculerMean(values);
				pgmImage.image[i][j] = meanValue;
			}
		}
		
		try {
			pgmImage.writeImage("afterMeanFilter.pgm");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void medianFilter(int taille) {
		
		int boundary = (taille -1) /2 ;
		for(int i=0 ; i< pgmImage.lx; i++) {
			for(int j=0 ; j<pgmImage.ly ; j++) {
				int rowStart = i -boundary ; 
				int rowEnd = i+ boundary;
				int columnStart = j-boundary;
				int columnEnd = j+boundary ;
				if((rowStart <0)||(rowEnd >= pgmImage.lx) || (columnStart<0) 
						||(columnEnd>=pgmImage.ly)) {
					continue;
				}
				//short []values = new short [taille*taille];
				Vector<Short> values = new Vector<Short>();
				for (int ii=rowStart ; ii<=rowEnd ; ii++) {
					for(int jj=columnStart ; jj <=columnEnd ; jj++) {
						values.add(pgmImage.image[ii][jj]);
					}
				}
				short medianValue =this.calculerMedian(values);
			//	System.out.println(medianValue);
				pgmImage.image[i][j] = medianValue;
			}
		}
		
		try {
			pgmImage.writeImage("afterMedianFilter.pgm");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public short calculerMedian(Vector<Short> values) {
		

		Collections.sort(values);
		System.out.println(values);
		return values.get(values.size()/2);
		
	}
	public short calculerMean(Vector<Short> values) {
		short sum =0 ;
		for(int i=0 ; i<values.size() ; i++) {
			sum+=values.get(i);
		}
		return (short) (sum/values.size());
	}
}
