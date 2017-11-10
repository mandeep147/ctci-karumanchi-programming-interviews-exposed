/**
 * 
 */
package edu.mandeep.practice;

import java.util.HashMap;
import java.util.Random;

/**
 * @author mandeep
 *
 */
public class RandomNumberString {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		//============================Method - 1========================================//
		
		String[] str = { "Hello", "Cat", "Hello", "Java", "Danal" };
		HashMap<String, Integer> randomNumbers = getRandomNumbers(str);
		for (String name : randomNumbers.keySet()) {
			System.out.println(name + " " + randomNumbers.get(name).toString());
		}
		
		//============================Method - 2========================================//		
		
		generateRandomNumbers("Hello");
		generateRandomNumbers("Cat");
		generateRandomNumbers("Hello");
		generateRandomNumbers("Java");
		generateRandomNumbers("Danal");
	}

	/**
	 * Method - 1
	 * taking the input in form of an array
	 * and maintaining a hashmap of string and integer
	 * if key exists in hashmap, it is skipped else a random number is generated for it
	 * @param str
	 * @return
	 */
	private static HashMap<String, Integer> getRandomNumbers(String[] str) {

		HashMap<String, Integer> randomString = new HashMap<>(str.length);

		for (int i = 0; i < str.length; i++) {
			if (!randomString.containsKey(str[i])) {
				Random random = new Random();
				int n = random.nextInt(0 + str[i].length());
				randomString.put(str[i], n);
			}
		}

		return randomString;
	}
	
	/**
	 * Method - 2
	 * replacing each character with it's ASCII value and 
	 * then rotating the value finite times, 
	 * that will give the same value everytime for same string.
	 * @param str
	 */
	
	private static void generateRandomNumbers(String str){
		 char[] ascii1 = str.toCharArray();
		 int val = 0;
		 for(char ch:ascii1){
		   val += (int)ch;
		 }
		 val *= 3;
		 System.out.println(Integer.rotateLeft(val, 3));
	}

}
