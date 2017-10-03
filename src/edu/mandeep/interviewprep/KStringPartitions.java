/**
 * License Key Formatting
 */
package edu.mandeep.interviewprep;


/**
 * @author mandeep
 *
 */
public class KStringPartitions {
	public static void main(String[] args){
		//String str = "2-4A0r7-4k";
		String str = "--a-a-a-a--";
		
		int k = 2;
		System.out.println(kGroups(str, k));
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
				if(length == k){
					result.append('-');
					length = 0;
				}
				result.append(str.charAt(i));
				length++;
			}
		}
		return result.toString().toUpperCase();
	}
}