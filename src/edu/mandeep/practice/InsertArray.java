//insert elements in sorted order 
package edu.mandeep.practice;

import java.util.Arrays;
import java.util.Scanner;

public class InsertArray {

	public static void main(String[] args) {

		 Scanner in = new Scanner(System.in);
	        String _input;
	        try {
	            _input = in.nextLine();
	        } catch (Exception e) {
	            _input = null;
	        }
	        String arr[] = new String[10];
	       // for(int i = 0; i < 10; i++){
	        	insertIntoSortedArray(arr, _input);
	        	System.out.println(Arrays.toString(arr));
	        	_input = in.nextLine();
	        	insertIntoSortedArray(arr, _input);
	        	System.out.println(Arrays.toString(arr));
	        	_input = in.nextLine();
	        	insertIntoSortedArray(arr, _input);
	        	System.out.println(Arrays.toString(arr));
	        	_input = in.nextLine();
	        	insertIntoSortedArray(arr, _input);
	        	System.out.println(Arrays.toString(arr));
	        	_input = in.nextLine();
	        	insertIntoSortedArray(arr, _input);
	        	System.out.println(Arrays.toString(arr));

	}
	private static void insertIntoSortedArray(String arr[], String newObj) {
	   
	    	int i =0;
				// When my arr[i] is not null and we have to compare whether the newObj will come first or after arr[i]    
    			while(arr[i] != null && arr[i].compareTo(newObj) < 0) {
    				i++;
    			}
    			
    			if(arr[i] == null) {
    				arr[i] = newObj;
    			} else {
    				System.out.println("add element: "+i+" aa");
    				addElementToArray(arr, newObj, i);
    			}
	}

	private static void addElementToArray(String arr[], String newObj, int i) {
//		As we will be creating arrays such that we don't have to re-size them, this is needed just to handle a case
//		where arr= [1, 4, 9, null, null, null] and we have to insert 5
		for(int k=arr.length - 1; k>i; k--) {
			arr[k] = arr[k-1];
		}
		arr[i] = newObj;
	}
}
