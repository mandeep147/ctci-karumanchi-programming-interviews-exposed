
/*
 * Alternate sorting: Given an array of integers, rearrange the array in such a way 
 * that the first element is first maximum and second element is first minimum. 
 * Eg.) Input : {1, 2, 3, 4, 5, 6, 7} 
 * Output : {7, 1, 6, 2, 5, 3, 4}
*/
// Assuming given array is sorted
package edu.mandeep.practice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class AlternateSorting {

	public static void main(String[] args) {
		
		ArrayList<Integer> input = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6, 7));
		Collections.sort(input);
		int lastIndex = input.size() - 1;
		
		ArrayList<Integer> output = new ArrayList<>(lastIndex);
		
		for(int i = 0; i <= lastIndex / 2; i++){
			output.add(input.get(lastIndex));
			output.add(input.get(i));
			lastIndex--;
		}
		
		System.out.println(output);
	}
}