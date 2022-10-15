package traitementImages_TP1;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PGM {

	public String format = "";
	public int lx = 0;
	public int ly = 0;
	public int maxPixelValue = 0;
	public short[][] image = null;
	public double mean = 0 ;
	public double standardDeviation = 0;
	public short[] greyLevelHistogram = null ;
	public int[] cumulativeHistogram = null ;

	public void readImage() throws Exception {
		int i = 0;
		File file = new File("chat.pgm");
		Scanner input = new Scanner(file);
		List<String> list = new ArrayList<String>();

		while (input.hasNextLine()) {
			list.add(input.nextLine());
		}
		format = list.get(0);
		for (i = 0; i < list.size(); i++) {
			if (i != 0) {
				if (list.get(i).charAt(0) != '#') {
					break;
				}
			}
		}

		ly = Integer.parseInt(list.get(i).substring(0, list.get(i).indexOf(' ')));
		lx = Integer.parseInt(list.get(i).substring(list.get(i).indexOf(' ') + 1));
		maxPixelValue = Integer.parseInt(list.get(i + 1));

		System.out.println(lx + "aaa" + ly + "aaaa" + maxPixelValue);

		int j = i + 2;
		image = new short[lx][ly];

		for (int ligne = j; ligne < list.size(); ligne++) {
			String[] lineStr = list.get(ligne).split("\\s+");

			for (int k = 0; k < ly; k++) {
				image[ligne - j][k] = Short.parseShort(lineStr[k]);

			}

		}

	}

	public void printMatrice() {

		for (int i = 0; i < lx; i++) {
			for (int k = 0; k < ly; k++) {
				System.out.print(image[i][k] + " ");
			}
			System.out.print("\n");

		}
	}
	
	public void writeImage() throws Exception {
		try (Writer writer = new BufferedWriter(new OutputStreamWriter(
	              new FileOutputStream("writeImage.pgm"), "utf-8"))) {
	   writer.write(format);writer.write("\n");
	   writer.write(lx+" "+ly+"\n");
	   writer.write(maxPixelValue+"\n");
	   
	  
	   for(int i=0 ; i<lx ; i++) {
		   String line="";
		   for (int k=0 ; k<ly ; k++) {
			   line+= image[i][k]+" " ;
		   }
		   line = line.substring(0, line.length()-1);
		   writer.write(line); writer.write("\n");
	   }


	   

	}
	}
	
	public void calculateMean() {
		long pixels = this.lx * this.ly ;
		double sum = 0 ;
		for(int i =0 ; i < this.lx ; i++) {
			for(int j=0 ; j< this.ly ; j++) {
				sum+=image[i][j];
			}
		}
		this.mean = sum /pixels ;
		System.out.println(this.mean);
	
	}
	
	public void calculateStandardDesviation() {
		long pixels = this.lx * this.ly ;
		double sum = 0 ;
		for(int i =0 ; i < this.lx ; i++) {
			for(int j=0 ; j< this.ly ; j++) {
				
				sum+=Math.pow( image[i][j]-this.mean,2);
			}
		}
		this.standardDeviation = Math.pow(sum/pixels , 0.5);
		System.out.println(this.standardDeviation);
	}
	
	
	public void calculateHistogram() {
		this.greyLevelHistogram= new short[this.maxPixelValue+1] ;
		
		for(int i =0 ; i < this.lx ; i++) {
			for(int j=0 ; j< this.ly ; j++) {
				
				this.greyLevelHistogram[image[i][j]]+=1;
			}
		}
		//this.printGreyLevelHistogram();
		
	}
	public void printGreyLevelHistogram() {
		System.out.println("n\tH(n)");
		//long sum =0;
		for(int i =0 ; i< this.greyLevelHistogram.length ; i++) {
			System.out.println(i +"\t"+this.greyLevelHistogram[i]);
			//sum+=this.greyLevelHistogram[i];
		}
		//System.out.println(sum==this.lx*this.ly);
	}
	
	public void calculateCumulativeHistogram() {
		this.cumulativeHistogram= new int[this.maxPixelValue+1] ;
		this.cumulativeHistogram[0] = this.greyLevelHistogram[0];
		for(int i =1 ; i< this.greyLevelHistogram.length ; i++) {
			this.cumulativeHistogram[i] = this.greyLevelHistogram[i]+this.cumulativeHistogram[i-1];
			
		}
	this.printCumulativeHistogram();
	}
	
	public void printCumulativeHistogram() {
		System.out.println("n\tHc(n)");
		for(int i =0 ; i< this.cumulativeHistogram.length ; i++) {
			System.out.println(i +"\t"+this.cumulativeHistogram[i]);
			
		}
		
	}
	
	
}
