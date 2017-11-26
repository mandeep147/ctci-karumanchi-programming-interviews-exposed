package edu.mandeep.coursera.AlgortihmsToolBox.week2;

import java.util.Scanner;

/**
 * 
 */

/**
 * @author mandeep
 *Given a sequence of non-negative integers a0,…,an−1, 
 *find the maximum pairwise product, that is, 
 *the largest integer that can be obtained by multiplying two different 
 *elements from the sequence (or, more formally, max0≤i≠j≤n−1aiaj). 
 *Different elements here mean ai and aj with i≠j (it can be the case that ai=aj).
 */
public class MaximumPairwiseProduct {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		Integer arr[] = new Integer[n];
		for(int i = 0; i < n ; i++){
			arr[i] = sc.nextInt();
		}
		getMaxProduct(arr);
		sc.close();
	}
	
	public static void getMaxProduct(Integer[] arr){
		/*List<Integer> list = Arrays.asList(arr);
		
		int largest = list.get(0);
		int secondLargest = list.get(0);*/
		int largest = Integer.MIN_VALUE ;
		int secondLargest = Integer.MIN_VALUE;
		
		for(int element : arr){
			if(element > largest){
				secondLargest = largest;
				largest = element;
			} else if(element > secondLargest)
				secondLargest = element;
		}
		
		System.out.println("Maximum product is: " + (largest * secondLargest));
		
	}
}