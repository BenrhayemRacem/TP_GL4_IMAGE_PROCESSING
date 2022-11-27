package traitementImages_TP1;

import java.util.Vector;

public class Stats {

	PGM pgmImage = new PGM();
	double [] probabiliteCumule = null;
	int [] n1Array = null;
	Vector<Integer> heg = new Vector<Integer>();
	int [] LUT_contraste = null ;
	//double [] afterContrasteImage = null ;
	
	Stats(){
		try {
			pgmImage.readImage();
			pgmImage.calculateHistogram();
			pgmImage.calculateCumulativeHistogram();
			probabiliteCumule = new double [pgmImage.maxPixelValue +1];
			n1Array = new int[pgmImage.maxPixelValue +1];
			pgmImage.printCumulativeHistogram();
			
			LUT_contraste = new int [256] ;
			
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public void printProbabiliteCumulee() {
		for(int i=0 ; i< probabiliteCumule.length ; i++) {
			
			System.out.println(probabiliteCumule[i]);
			//System.out.println(n1Array[i]);
		}
	}
	public void printn1Array() {
		System.out.println("n\tn1");
		for(int i=0 ; i< n1Array.length ; i++) {
			
			
			System.out.println( i + "\t"+ n1Array[i]);
		}
	}
	
	public void calculerProbabiliteCumulee() {
		
		for(int i=0 ; i< probabiliteCumule.length ; i++) {
			probabiliteCumule[i] = (double)pgmImage.cumulativeHistogram[i]/(double)(pgmImage.lx * pgmImage.ly);
			n1Array[i] = (int) (Math.floor(probabiliteCumule[i]*pgmImage.maxPixelValue));
		}
		
		this.printProbabiliteCumulee();
		this.printn1Array();
	}
	public void egalisationHistogramme() {
		this.printProbabiliteCumulee();
	}
	
	public void calculerHistogrammeLegalise() {
		
		int somme = pgmImage.greyLevelHistogram[0];
	for(int i=1 ; i<n1Array.length ; i++) {
		int k=n1Array[i] - n1Array[i-1] ;
		while(k>1) {
			heg.add(0);	
			k--;
		}
           if(n1Array[i] == n1Array[i-1]) {
			somme += pgmImage.greyLevelHistogram[i];
		} else {
			heg.add(somme);
			somme= pgmImage.greyLevelHistogram[i];
		}
		
		
	}
	this.printHeg();
		
}
	
	public void printHeg() {
		
		System.out.println("n1\tHeg");
		for(int i =0 ; i< heg.size() ; i++) {
			System.out.println(i + "\t" + heg.elementAt(i));
		}
	}
	
	public void contraste_LUT(int x1 , int y1 , int x2 , int y2) {
		//int x_pt0 , y_pt0 = 0 ;
		//int x_pt255 , y_pt255 = 255 ;
		
		int a_prePoint1 = 0 ;
		if(x1 != 0) {
			  a_prePoint1=y1/x1 ;
		}
		int b_prePoint1 = 0 ;
		
		int a_entre1_2 =  (y2 - y1) /(x2 - x1) ;
		int b_entre1_2 = y1 - a_entre1_2 * x1 ;
		
		int a_postPoint2 = (255-y2) /(255-y1) ;
		int b_postPoint2 =  255 - 255 * a_postPoint2 ;
		
		 
		for(int i =0 ; i< LUT_contraste.length ; i++) {
			//int value = pgmImage.greyLevelHistogram[i] ;
			if(i<=x1) {
				LUT_contraste[i] = a_prePoint1 * i + b_prePoint1 ;
			} if((i>x1) && (i<=x2)) {
				LUT_contraste[i] = a_entre1_2 * i + b_entre1_2 ;
			}if(i>x2) {
				LUT_contraste[i] = a_postPoint2 * i + b_postPoint2 ;
			}
		}
		
		
	}
	
	public void newImageAfterContraste() throws Exception {
		for (int i = 0; i < pgmImage.lx; i++) {
			for (int k = 0; k < pgmImage.ly; k++) {
				pgmImage.image[i][k]  = (short) LUT_contraste[pgmImage.image[i][k]];
			}
			pgmImage.writeImage("afterContrasteModif.pgm");

		}
	}
}
