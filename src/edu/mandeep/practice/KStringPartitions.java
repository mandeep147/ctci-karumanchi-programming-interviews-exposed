/**
 * License Key Formatting
 */
package edu.mandeep.practice;

import java.util.Arrays;

/**
 * @author mandeep
 *
 */
public class KStringPartitions {
	public static void main(String[] args){
		//String str = "2-4A0r7-4k";
		//String str = "--a-a-a-a--";
		String str = "2-4ADr7-4k";
		int k = 3;
		System.out.println(kGroups(str, k));
	//System.out.println(LicenseKeyFormatting(str, k));
	}

	/**
	 * Complexity: O(n)
	 * @param str
	 * @param class1
	 * @return
	 */
	private static String kGroups(String str, int k) {
		StringBuilder result = new StringBuilder();
		int length = 0;
		for(int i = 0; i <str.length(); i++){
			if(str.charAt(i) != '-'){
				if(length % k == 0  && length > 0){
					result.append('-');
					length = 0;
				}
				result.append(str.charAt(i));
				length++;
			}
		}
		return result.toString().toUpperCase();
	}
	
	private static String LicenseKeyFormatting(String S, int K) 
    {
		S = S.replaceAll("[-]", "");
	    S = S.toUpperCase();

	    StringBuilder sb = new StringBuilder();
	    sb.append(S);

	    int i=sb.length()-K;
	    while(i>0) {
	        sb.insert(i, '-');
	        i = i-K;
	    }

	    return sb.toString();
    }
}