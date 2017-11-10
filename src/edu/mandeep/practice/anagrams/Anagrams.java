///generate anagrams of a string
package edu.mandeep.practice.anagrams;
public class Anagrams { 
	
	public static void main(String args[]) { 
		permutation("abc"); 		
	} 
	
	public static void permutation(String input){
		permutation(" ", input);
	}
	
	private static void permutation(String perm, String input){
		if(input.isEmpty())
			System.out.print(perm);
		else{
			for(int i = 0; i < input.length(); i++)
				permutation(perm + input.charAt(i), input.substring(0, i) + input.substring(i + 1, input.length()));
		}
	}
}