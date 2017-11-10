/**
 * 
 */
package edu.mandeep.practice;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * If you're given a list of countries and its corresponding population, 
 * write a function that will return a random country 
 * but the higher the population of the country, 
 * the more likely it is to be picked at random.
 * 
 * https://www.careercup.com/question?id=14582824
 * @author mandeep
 */
public class HighestPopulationCountry {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
	}
	
	private static void highestPopulation(HashMap<String, Integer> countries){
		int totalPop = 0;
		HashMap<String, HashMap<Integer, Integer>> popCount = new HashMap<String, HashMap<Integer, Integer>>();
		for(String key : countries.keySet())
			totalPop += countries.get(key);
		
	}
}