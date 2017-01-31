/*
 * given an unordered list of numbers find all pairs that add up to x 
 */

package edu.mandeep.practice;

import java.util.HashSet;
import java.util.Set;

public class TwoSumPairs {

	public static void main(String[] args){
		int[] arr = {0, 14, 0, 4, 7, 8, 3, 5, 7};		
		int target = 11;
		
		twoSum(arr, target);
		
		
	}

	private static void twoSum(int[] arr, int target) {
		if(arr.length < 2)
			return;
		
		Set set = new HashSet(arr.length);
		
		for(int item : arr){
			int diff = target - item;
			
			if(!set.contains(diff))
				set.add(item);
			else
				System.out.print(item+" "+ diff+ "\n");
		}
		
	}
}
