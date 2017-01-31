/*
 *Given an array sort 
 * in a manner such that you first have the even numbers 
 * followed by odd numbers. 
*/
package edu.mandeep.practice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SortEvenOdd {
	
	public static void sortEvenOdd(int arr[]){
		int leftptr = 0, rightptr = arr.length - 1;
		
		while(leftptr < rightptr){
			while(arr[leftptr] % 2 == 0 && leftptr < rightptr)
				leftptr++;
			while(arr[rightptr] % 2 == 1 && leftptr < rightptr)
				rightptr--;
			
			if(leftptr < rightptr){
				int temp = arr[leftptr];
				arr[leftptr] = arr[rightptr];
				arr[rightptr] = temp;
				leftptr++;
				rightptr--;
			}
		}

		for( int i = 0; i < arr.length; i++)
			System.out.print(arr[i]+ " ");
}
	
	public static void main(String[] args){
		int[] arr = {5,12,3,21,8,7,19,102,201};
		sortEvenOdd(arr);
	
	}
}
