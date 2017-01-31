/*
 * to find first repeated character
 * using arrays	
*/
package edu.mandeep.karumanchi;

public class FirstRepeatedChar {
	public static void firstRepeatedChar(char[] str){
		int repeatedChar[] = new int[256];
		int flag = 0;
		for(int i = 0; i < 256; i++){
			repeatedChar[i] = 0;
		}
		
		for(int i = 0; i < str.length; i++){
			
			if(repeatedChar[str[i]] == 1){
				System.out.println(str[i]+ " is repeated at position: " + (i+1));
				flag = 1;
			}
			else 
				repeatedChar[str[i]]++;		
		}
		
		if(flag == 0)
			System.out.println("No character is repeated");
			
	}
	
	public static void main(String[] args){
		 //String str = "JavaConcept";
		 String str = "nil";
		 char input[] = str.toCharArray();
		 
		 firstRepeatedChar(input);
	}
}
