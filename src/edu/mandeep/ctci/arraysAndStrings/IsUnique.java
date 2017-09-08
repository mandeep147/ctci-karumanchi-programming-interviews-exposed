/**
 * Determine if string has all unique characters
 */
package edu.mandeep.ctci.arraysAndStrings;

/**
 * @author mandeep
 *
 */
public class IsUnique {
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String str = "aaabbfde";
		String str1 = "abcdefghijk";
		String str2 = "qwo[pknahsjmczl;./WPKLQAM";
		System.out.println("String "+ str +"contains unique characters: "+ isUniqueChars(str));
		System.out.println("String "+ str1 +"contains unique characters: "+ isUniqueChars(str1));
		System.out.println("String "+ str2 +"contains unique characters: "+ isUniqueChars(str2));
	}
	//assumption: ASCII string
	static boolean isUniqueChars(String str){
		//if length of string is more than 128 it has duplicate values
		if(str.length() > 128)
			return false;
		
		//array of 128 chars
		boolean[] flag = new boolean[128];
		for(int i = 0; i < str.length(); i++){
			int val = str.charAt(i);
			
			//if ith index is previously set, duplicate entry of same char is encountered
			if(flag[val])
				return false;
			flag[val] = true;
		}	
		return true;
	}
}