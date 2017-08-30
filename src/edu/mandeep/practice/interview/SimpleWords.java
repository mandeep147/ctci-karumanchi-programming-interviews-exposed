package edu.mandeep.practice.interview;

import java.util.ArrayList;
import java.util.List;

/**
 * Given a set of words, say {"sales", "person", "salesperson"}, 
 * determine which words are compound (that is, it is the combination of 2 or more words in the list). 
 * So in this case, salesperson = sales + person, and is compound.
 * Input: chat, ever, snapchat, snap, salesperson, per, person, sales, son, whatsoever, what, so
 * Output: chat, ever, snap, per, sales, son, what, so
 * @author mandeep
 */
public class SimpleWords {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String[] words = {"mobile","samsung","sam","sung","man","mango",
                "icecream","and","go","i","like","ice","cream"};
			//{"chat", "ever", "snapchat", "snap", "salesperson", "per", 
			//	"person", "sales", "son", "whatsoever", "what", "so"};
		
		String[] result = simpleWords(words);		
		for(int i = 0; i < result.length; i++)
			System.out.print(result[i]+", ");
	}
	
	public static String[] simpleWords(String[] data) {
	    List<String> list = new ArrayList<>();
	    for (String word : data) {
	    	System.out.println("word: "+word);
	        if (!isCompound(data, word)) {
	        	System.out.println("Not compound, word: "+word);
	            list.add(word);
	        }
	    }
	    return list.toArray(new String[list.size()]);
	}

	public static boolean isCompound(String[] data, String word) {
	    return isCompound(data, word, 0);
	}

	public static boolean isCompound(String[] data, String word, int iteration) {
	    if (data == null || word == null || word.trim().isEmpty()) {
	        return false;
	    }
	    System.out.print("data:");
	    for(int i = 0; i < data.length; i++){
	    	System.out.print(data[i]+", ");
	    }
	    System.out.println();
	    for (String str : data) {
	    	System.out.println("str: "+str);
	        if (str.equals(word) && iteration > 0) {
	        	System.out.println("str equals word, str: "+str+" ,word: "+word);
	            return true;
	        }
	        if (word.startsWith(str)) {
	            String subword = word.substring(str.length());       
	            System.out.println("subword: "+subword+" ,str: "+str+" ,word: "+word);
	            if (isCompound(data, subword, iteration + 1)) {
	            	System.out.println("str equals word, word: "+word+" ,subword: "+subword);
	                return true;
	            }
	        }
	    }
	    System.out.println("word isCompound: "+word);
	    return false;
	}
}