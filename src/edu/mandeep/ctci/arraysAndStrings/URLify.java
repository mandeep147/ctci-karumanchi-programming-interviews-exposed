/**
 * 1.3 URLify: replace all spaces in a string with "%20", original length of string is given
 * using character array
 * input: "Mr John SMith", 13
 * output: "Mr%20John%20Smith"
 */
package edu.mandeep.ctci.arraysAndStrings;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * @author mandeep
 *
 */
public class URLify {

	/**
	 * @param args
	 */
	public static void main(String[] args) throws Exception{
		URLify url = new URLify();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String input = br.readLine();
		char[] content = input.toCharArray();
		int trueLength = input.trim().length();
	
		content = url.replaceSpaces(content, trueLength);
		for(int i = 0; i < content.length; i++)
			System.out.print(content[i]);
	}
	
	//2-scan approach
	private char[] replaceSpaces(char[] str, int trueLength){
		int spaces = 0, index, i = 0;
		
		//counting number of spaces in the character array
		for(i = 0; i< trueLength; i++){
			if(str[i] == ' ')
				spaces++;
		}
		
		//final length will be truelength + twice the spaces
		index = trueLength + 2 * spaces;
		char[] res = new char[index];
		if(trueLength < str.length)
			str[trueLength] = '\0';
		
		for( i = trueLength - 1; i >= 0; i--){
			if(str[i] == ' '){
				res[index - 1] = '0';
				res[index - 2] = '2';
				res[index - 3] = '%';
				index = index - 3;
			}else{
				res[index - 1] = str[i];
				index--;
			}
		}
		return res;
	}
}