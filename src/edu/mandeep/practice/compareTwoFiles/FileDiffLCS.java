/**
 * 
 */
package edu.mandeep.practice.compareTwoFiles;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;

/**
 * Read two text files and output if they are same or not using LCS algo
 * 
 * @author mandeep
 */
public class FileDiffLCS {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		File f1 = new File("./firstFile.txt");
		File f2 = new File("./secondFile.txt");
		
		System.out.println("Two files have same content: ");
		compareFiles(f1, f2);
	}
	
	private static void compareFiles(File f1, File f2){
		try {
			
			Object[] input1 = Files.readAllLines(f1.toPath(), StandardCharsets.US_ASCII).toArray();
			Object[] input2 = Files.readAllLines(f2.toPath(), StandardCharsets.US_ASCII).toArray();
			
			int len1 = input1.length;
			int len2 = input2.length;
			
			int output[][] = new int[len1 + 1][len2 + 1];
			
			for(int i = len1 - 1; i >= 0; i--){
				for(int j = len2 - 1; j >= 0; j--){
					if(input1[i].equals(input2[j]))
						output[i][j] = output[i + 1][j + 1] + 1;
					else
						output[i][j] = Math.max(output[i + 1][j],output[i][j + 1]);
				}
			}
			
			int i = 0, j = 0;
			while(i < len1 && j < len2){
				
				if(input1[i].equals(input2[j])){
					i++;
					j++;
				}else if(output[i + 1][j] >= output[i][j + 1])
					System.out.println("1 <" + " " + input1[i++]);
				else
					System.out.println("2 >" + input2[j++]);
			}
			
			while(i < len1 || j < len2){
				if( i == len1)
					System.out.println("1 <" + input1[i++]);
				else if(j == len2)
					System.out.println("2 >" + input2[j++]);
			}
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}