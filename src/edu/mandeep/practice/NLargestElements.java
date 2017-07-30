/**
 * 
 */
package edu.mandeep.practice;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Set;
import java.util.TreeSet;

/**
 * @author mandeep
 *
 */
public class NLargestElements {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<Integer> listOfElements = new ArrayList<>();
		Random rand = new Random();

		int  randomNumber;
		for(int i = 0; i < 100; i++){
			randomNumber = rand.nextInt(50) + 1;
			listOfElements.add(randomNumber);
		}
			
		int n = 5;
		
		
		for (int integer : listOfElements) {
			System.out.print(integer + " ");
		}
		System.out.println("Largest "+n+" numbers are:\n");
		System.out.println(findTopNNumbersInLargeList(listOfElements, n ));
	}

	public static Set<Integer> findTopNNumbersInLargeList(final List<Integer> largeNumbersList, 
			  final int highestValCount) {

			  TreeSet<Integer> highestNNumbers = new TreeSet<Integer>();

			  for (int number : largeNumbersList) {
			    highestNNumbers.add(number);
			    if (highestNNumbers.size() > highestValCount) {
			      highestNNumbers.pollFirst();
			    }
			  }
			  return highestNNumbers;
			}
}
