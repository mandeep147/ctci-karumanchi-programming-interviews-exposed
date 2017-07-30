package edu.mandeep.practice;

import java.util.HashMap;

public class TargetSum {
		
		public static int[] twoSum(int[] arr, int sum){

			HashMap<Integer, Integer> twoSumMap = new HashMap<Integer, Integer>();	
			
			for(int i = 0; i < arr.length; i++){
				int diff = sum - arr[i];
				if(twoSumMap.containsKey(diff)){
					return new int[] {twoSumMap.get(diff), i};
				}
				twoSumMap.put(arr[i], i);
			}
			
			throw new IllegalArgumentException("No two sum solution");
			
		}
		
		public static void main(String[] args){
			int[] arr = {11, 15, 2, 7};
			
			int target = 9;
			
			int[] result = twoSum(arr, target);
			
			for(int i = 0; i < result.length; i++)
				System.out.println(arr[result[i]]);
		}
}