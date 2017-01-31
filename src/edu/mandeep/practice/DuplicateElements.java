package edu.mandeep.practice;

import java.util.HashSet;
import java.util.Set;

public class DuplicateElements {
	
	static void findDuplicates(int[] arr){
		int flag = 0;
		Set<Integer> duplicateSet = new HashSet<Integer>();
		
		for(int i = 0; i < arr.length; i++){
			if(duplicateSet.add(arr[i]) == false)
			{
				flag = 1;
				System.out.print(arr[i]+ " ");
			}			
		}
		if(flag == 0)
			System.out.println("no element is repeated");
	}
	
	public static void main(String[] args){
	
		int arr[] = {4, 2, 14, 5, 12, 3, 1};
		findDuplicates(arr);
	}
}