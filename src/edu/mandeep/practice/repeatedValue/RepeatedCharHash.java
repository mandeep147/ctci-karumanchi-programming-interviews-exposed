/*
 * first repeated char in the input string using HashMap
*/
package edu.mandeep.practice.repeatedValue;

import java.util.HashMap;

public class RepeatedCharHash {
	
	static void repeatedChar(String input){
		HashMap<Character, Integer> countMap = new HashMap<Character, Integer>();
		int flag = 0;
		char[] inputArr = input.toCharArray();
		
		for( char ch : inputArr){
			if(countMap.containsKey(ch))
				countMap.put(ch, countMap.get(ch)+1);
			else
				countMap.put(ch, 1);
		}
		
		//checking for first repeated char
		for( char ch : inputArr){
			if( countMap.get(ch) > 1){
				System.out.println("first repeated char: " +ch);
				flag = 1;
				break;
			}
		}
		if(flag == 0)
			System.out.println("no repeated char " );
		
	}
	
	public static void main(String[] args){
		//String input = "JAVA";
		String input = "code";
		repeatedChar(input);
	}
}
