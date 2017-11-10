package edu.mandeep.practice.largestElement;

import java.util.Arrays;
import java.util.PriorityQueue;

public class NthLargestElement {

	/*
	 * Time: O(nlogn)
	 */
	public static int kthLargestElement(int[] arr, int k){
		Arrays.sort(arr);
		return arr[arr.length - k];
	}

	/*
	 * using quick sort
	 * Time: O(n)
	 */
	public static int kthLargeQuick(int arr[], int k){
		if( k < 1 || arr == null)
			return 0;
		return getKthElement(arr.length - k + 1, arr, 0, arr.length - 1);
	}

	private static int getKthElement(int k, int[] arr, int start, int end) {
		int pivot = arr[end];
		int left = start;
		int right = end;
		
		while(true){
			while(arr[left] < pivot && left < right)
				left++;
			while(arr[right] >= pivot && right > left)
				right--;
			
			if(left == right)
				break;
			
			swap(arr, left, right);
		}
		
		swap(arr, left, end);
		
		if(k == left + 1)
			return pivot;
		else if(k < (left + 1))
			return getKthElement(k, arr, start, (left - 1));
		else
			return getKthElement(k, arr, (left + 1), end);
	}

	private static void swap(int[] arr, int left, int right) {
		int temp = arr[left];
		arr[left] = arr[right];
		arr[right] = temp;
		
	}

	/*
	 * using heap sort
	 * Time: O( n log k)
	 */
	public static int kthLargeHeap(int[] arr, int k){
		PriorityQueue<Integer> queue = new PriorityQueue<Integer>(k);

		/*
		 * Inserts the specified element into this priority queue.
		 */
		for( int i : arr)
		{	
			queue.offer(i); 
			/*Retrieves and removes the head of this queue, or returns null 
			 * if this queue is empty.
			 * Returns:
			 * the head of this queue, or null if this queue is empty
			 */
			if(queue.size() > k)
				queue.poll();
		}
		
		/*
		 * Retrieves, but does not remove, the head of this queue, or returns null if this queue is empty.
		 * Returns:
		 * the head of this queue, or null if this queue is empty
		*/
		return queue.peek();
	}

	public static void main(String[] args){
		int[] arr= {14, 4, 7, 8, 3, 5};

		System.out.println(kthLargestElement(arr, 3));
		
		System.out.println(kthLargeHeap(arr, 3));
		
		System.out.println(kthLargeQuick(arr, 3));
	}
}
