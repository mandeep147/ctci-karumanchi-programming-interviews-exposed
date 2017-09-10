/**
 * Problem 1.6: perform basic string compression using ocunt of repeated chars
 * input: aabcccccaaa
 * output: a2b1c5a3
 */
package edu.mandeep.ctci.arraysAndStrings;

/**
 * @author mandeep
 */
public class StringCompression {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String str = "aabcccccaaa";
		System.out.println(compressString(str));
	}
	
	/**
	 * 
	 * @param str
	 * @return
	 */
	private static String compressString(String str){
		int finalLength = countCompression(str);
		
		if(finalLength >= str.length())
			return str;
		StringBuilder compressedStr = new StringBuilder(finalLength);
		int count = 0;
		for(int i = 0; i < str.length(); i++){
			count++;
			if(i + 1 >= str.length() || str.charAt(i) != str.charAt(i + 1)){
				compressedStr.append(str.charAt(i));
				compressedStr.append(count);
				count = 0;
			}
		}
		return compressedStr.toString();
	}

	/**
	 * @param str
	 * @return
	 */
	private static int countCompression(String str) {
		int compressedLength = 0;
		int count = 0;
		for(int i = 0; i < str.length(); i++){
			count++;
			if(i + 1 >= str.length() || str.charAt(i) != str.charAt(i + 1)){
				compressedLength += 1 + String.valueOf(count).length();
				count = 0;
			}
		}
		return compressedLength;
	}
}