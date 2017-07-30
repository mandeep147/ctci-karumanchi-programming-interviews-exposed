package edu.mandeep.karumanchi.searching;

public class BinarySearch {

	public static void main(String[] args) {
		int A[] = {2, 3, 4, 7, 10, 35, 90};
		System.out.println(BinarySearchIterative(A, 4));
	}
	
	public static int BinarySearchIterative(int[] A, int value){
		int low = 0, high = A.length - 1;
		int mid ;
		while (low <= high ){
			mid = low + (high - low)/2;
			if(A[mid] == value)
				return mid;
			else if (A[mid] < value)
				low = mid +1;
			else high = mid - 1;
		}
		return -1;
	}
}