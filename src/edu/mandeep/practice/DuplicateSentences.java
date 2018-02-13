/**
 * 
 */
package edu.mandeep.practice;

import java.util.HashSet;
import java.util.Set;

/**
 * @author mandeep
 *
 */
public class DuplicateSentences {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		duplicateSentences();
	}

	private static void duplicateSentences(){
		String fullString = "this is a first sentence. hello my name is Chris . what's up man what's up man? today is tuesday";
		String[] words = fullString.split("\\W+");
		StringBuilder stringBuilder = new StringBuilder();
		Set<String> wordsHashSet = new HashSet<>();

		for (String word : words) {
		    // Check for duplicates
		    if (wordsHashSet.contains(word.toLowerCase())) continue;

		    wordsHashSet.add(word.toLowerCase());
		    stringBuilder.append(word).append(" ");
		}
		String nonDuplicateString = stringBuilder.toString().trim();
		System.out.println(nonDuplicateString);
	}
}
