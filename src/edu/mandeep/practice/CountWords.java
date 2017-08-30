/*
 * count occurrence of each word in a string, where the words are separated by space
 * without using split()
*/
package edu.mandeep.practice;

import java.util.HashMap;
import java.util.StringTokenizer;

public class CountWords {
	
	public static void repeatedWord(String input){
		HashMap<String, Integer> countMap = new HashMap<String, Integer>();
		
		StringTokenizer tokens = new StringTokenizer(input, " ");
		String[] inputSpace = new String[tokens.countTokens()];
		int i = 0;
		
		while(tokens.hasMoreTokens()){
			inputSpace[i] = tokens.nextToken();
			i++;
		}
		
		for(String word: inputSpace){
			if(countMap.containsKey(word))
				countMap.put(word, countMap.get(word)+1);
			else
				countMap.put(word, 1);
		}
		
		System.out.println(countMap);
	}
	
	public static void main(String[] args){
		
		String input = "coding is fun is coding";
		repeatedWord(input);
	}
}