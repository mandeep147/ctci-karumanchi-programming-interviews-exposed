/**
 * 
 */
package edu.mandeep.practice.tfidf;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

/**
 * @author mandeep
 *
 */
public class TfidfMain {

	/**
	 * @param args
	 * @throws IOException 
	 * @throws FileNotFoundException 
	 */
	public static void main(String[] args) throws FileNotFoundException, IOException {
		DocumentParser dp = new DocumentParser();
		List<String> parsedFiles = dp.parseFiles("/Users/mandeep/Documents/Practice/coding-practice/src/edu/mandeep/interviewprep/tfidf/inputFiles");
		dp.tfIdfCalculator(); //calculates tfidf
		double[][] sim = dp.getCosineSimilarity(); //calculated cosine similarity  
		double max = Double.MIN_VALUE;
		int posi = 0, posj = 0;
        for(int i = 0; i < sim.length; i++){
        	for(int j = 0; j < sim[0].length; j++){
        		if(i != j && max < sim[i][j]){
	        			max = sim[i][j];
	        			posi = i;
	        			posj = j;
        		}
        	}
        }
        System.out.println("max is: "+max + "\nelement: " + parsedFiles.get(posi) + " and "+parsedFiles.get(posj));
	}
}