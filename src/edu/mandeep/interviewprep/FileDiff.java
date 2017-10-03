/**
 * 
 */
package edu.mandeep.interviewprep;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import MessageDigest.BLAKE512;

/**
 * Read two text files and output if they are same or not
 * 
 * using BLAKE-512 hash to compare the files
 * @author mandeep
 */
public class FileDiff {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		File f1 = new File("./firstFile.txt");
		File f2 = new File("./secondFile.txt");
		System.out.println("Two files have same content: "+compareFiles(f1, f2));

	}
	
	private static boolean compareFiles(File f1, File f2){
		int i = 0;
	    int step = 4096;
	    boolean equal = false;

		if(f1.length() != f2.length())
			return equal;
		else{
			
			try {
				FileInputStream fs1 = new FileInputStream(f1);
				FileInputStream fs2 = new FileInputStream(f2);
				
				 byte[] fi1Content = new byte[step];
				 byte[] fi2Content = new byte[step];
				 
				 while(i * step < f1.length()){
					 fs1.read(fi1Content, 0, step);
					 fs2.read(fi2Content, 0, step);
					 
					 equal = BLAKE512.isEqual(fi1Content, fi2Content);
					 
					 if(!equal){
						 break;
					 }
					 ++i;
					 
				 }
				 fs1.close();
				 fs2.close();
				
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			}catch(IOException e){
				e.printStackTrace();
			}
		}
		return equal;
	}
}