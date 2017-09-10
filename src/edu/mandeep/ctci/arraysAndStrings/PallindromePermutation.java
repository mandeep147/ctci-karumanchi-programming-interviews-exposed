/**
 * 1.4 Pallindrome Permuatation: 
 * check if given string is a permutation of a pallindrome
 * Input: Tact Coa
 * Output: True; (permutation: taco cat, atco cta)
 */
package edu.mandeep.ctci.arraysAndStrings;

/**
 * @author mandeep
 *
 */
public class PallindromePermutation {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String str = "Tact Coa";
		System.out.println(isPallindromePermutation(str.toLowerCase()));
	}
	/**
	 * Complexity: O(n)
	 * @param str
	 * @return
	 */
	private static boolean isPallindromePermutation(String str){
		int count = 0;
		int[] table = new int[Character.getNumericValue('z') - Character.getNumericValue('a') + 1];
		for(char c : str.toCharArray()){
			int x = getCharNumber(c);
			if(x != -1){
				table[x]++;
				if(table[x] % 2 == 1)
					count++;
				else 
					count--;
			}
		}
		return count <= 1;
	}

	/**
	 * @param c
	 * @return
	 */
	private static int getCharNumber(char c) {
		int a = Character.getNumericValue('a');
		int z = Character.getNumericValue('z');
		int val = Character.getNumericValue(c);
		if(val >= a && val <= z)
			return val - a;
		return -1;
	}
}