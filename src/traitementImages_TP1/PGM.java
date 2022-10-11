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
}
