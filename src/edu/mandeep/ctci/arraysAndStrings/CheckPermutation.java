/**
 * 1.2 Check Permuattion: if one string is permutation of the other string?
 */
package edu.mandeep.ctci.arraysAndStrings;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * @author mandeep
 *
 */
public class CheckPermutation {

	/**
	 * @param args
	 * @throws Exception 
	 */
	public static void main(String[] args) throws Exception {
		CheckPermutation check = new CheckPermutation();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String input1 = br.readLine();
		String input2 = br.readLine();
		System.out.println(input1 +" is permutation of "+input2 +" ?: "+check.checkPermutation(input1, input2));
		System.out.println(input1 +" is permutation of "+input2 +" ?: "+check.permutation(input1, input2));
	}
	
	//method-1
	private boolean checkPermutation(String str1, String str2){
		if(str1.length() != str2.length())
			return false;
		return sortString(str1).equals(sortString(str2));
	}

	private String sortString(String str1) {
		char[] strArray = str1.toCharArray();
		java.util.Arrays.sort(strArray);
		return new String(strArray);
	}
	
	//method-2
	private boolean permutation(String s1, String s2){
		if(s1.length() != s2.length())
			return false;
		
		int[] letters = new int[128];
		char[] stringArray = s1.toCharArray();
		
		for(char c: stringArray)
			letters[c]++;
		
		for(int i = 0; i < s2.length(); i++){
			int c = (int)s2.charAt(i);
			letters[c]--;
			if(letters[c] < 0)
				return false;
		}
		
		return true;
	}

}