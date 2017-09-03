/**
 * 
 */
package edu.mandeep.interview;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 * compare two text files line by line.
 * @author mandeep
 */
public class CompareTextFiles {

	/**
	 * @param args
	 * @throws IOException 
	 */
	@SuppressWarnings("resource")
	public static void main(String[] args) throws IOException {
		BufferedReader first = new BufferedReader(new FileReader("./firstFile.txt"));
		BufferedReader second = new BufferedReader(new FileReader("./secondFile.txt"));
		
		String firstInput = first.readLine();
		String secondInput = second.readLine();
		
		int count = 1;
		boolean flag = true;
		
		while(firstInput != null || secondInput != null){
			if(firstInput == null || secondInput == null){
				flag = false;
				break;
			}else if(!firstInput.equalsIgnoreCase(secondInput)){
				flag = false;
				break;
			}
			
			firstInput = first.readLine();
			secondInput = second.readLine();
			count++;
		}
		if(!flag){
			System.out.println("Files have different content at line " +count);
			 System.out.println("File1 has "+firstInput+" and File2 has "+secondInput+" at line "+count);
		}
		else
			System.out.println("Both files have same content");
	}
}