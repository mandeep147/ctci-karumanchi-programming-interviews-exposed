/**
 * Problem 10.2: Group Anagrams
 * Sort an array of strings so that all anagrams are next to each other.
 */
package edu.mandeep.ctci.sortingAndSearching;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * @author mandeep
 *
 */
public class GroupAnagrams {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String[] str = {"cat", "dog", "tac", "god", "act"};
		for(String s : str)
			System.out.print(s+" ");
		
		sort(str);
		System.out.println();
		for(String s : str)
			System.out.print(s+" ");
	}

	/**
	 * @param str
	 */
	private static void sort(String[] str) {
		HashMapList<String, String> mapList = new HashMapList<String, String>();
		for(String s: str){
			String key = sortChars(s);
			mapList.put(key, s);
		}
		
		//convert hashtable to array
		int index = 0;
		for(String key: mapList.keySet()){
			ArrayList<String> list = mapList.get(key);
			for(String t : list){
				str[index] = t;
				index++;
			}
		}
	}

	/**
	 * @param s
	 * @return
	 */
	private static String sortChars(String s) {
		char[] values = s.toCharArray();
		Arrays.sort(values);
		return new String(values);
	}

}