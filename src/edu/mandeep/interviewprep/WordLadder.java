/**
 * 
 */
package edu.mandeep.interviewprep;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

/**
 * Given a dictionary, and two words ‘start’ and ‘target’ (both of same length). 
 * Find length of the smallest chain from ‘start’ to ‘target’ if it exists, 
 * such that adjacent words in the chain only differ by one character and each word in the chain is a valid word 
 * i.e., it exists in the dictionary. It may be assumed that the ‘target’ word exists in dictionary 
 * and length of all dictionary words is same.
 * 
 * using BFS approach --> queue
 * http://www.geeksforgeeks.org/word-ladder-length-of-shortest-chain-to-reach-a-target-word/
 * @author mandeep
 *
 */
public class WordLadder {

	/**
	 * Runtime: O(26n) 
	 * Space: O(n) 
	 * @param args
	 */
	public static void main(String[] args) {
		Set<String> dictionary = new HashSet<String>();
		  dictionary.add("CAT");
		  dictionary.add("BAT");
		  dictionary.add("COT");
		  dictionary.add("CON");
		  dictionary.add("COW");
		  dictionary.add("RAT");
		  dictionary.add("BUT");
		  dictionary.add("CUT");
		  dictionary.add("DOG");
		  dictionary.add("WEB");
		 
		  String startWord = "CAT";
		  String endWord = "DOG";
		  System.out.println("shortest length of path from "+startWord+" to "+endWord+" is "+ ladderLength(startWord, endWord, dictionary));
	}
	
	private static int ladderLength(String begin, String end, Set<String> word){
		int count = 1;
		
		Queue<String> queue = new LinkedList<String>();
		queue.add(begin);
		
		while(!queue.isEmpty()){
			int size = queue.size();
			
			for(int j = 0; j < size; j++){
				String current = queue.remove();
				if(current.equals(end))
					return count;
				
				for(int i = 0; i < current.length(); i++){
					for(char c = 'A'; c <= 'Z'; c++){
						if(c != current.charAt(i)){
							char[] charSet = current.toCharArray();
							charSet[i] = c;
							
							String transform = new String(charSet);
							if(word.contains(transform)){
								queue.add(transform);
								word.remove(transform);
							}
						}
					}
				}
			}
			count++;
		}
		
		return 0;
	}
}