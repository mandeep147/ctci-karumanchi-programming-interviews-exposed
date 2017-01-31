package edu.mandeep.practice;

import java.util.ArrayList;
import java.util.List;


public class IntSet {

	private static boolean contain(char[] arr, char value){
		
		for( char item : arr){
			if(item == value)
				return true;
		}
		
		return false;	
	}
	
	public static char[] union(char[] a, char[] b){
		List<Character> result = new ArrayList<Character>();
		
		for(char value : a){
			if(contain(b, value)){
				result.add(value);
			}
		}
		
		char[] resultArr = new char[result.size()];
		
		for(int i = 0; i < result.size(); i++){
			resultArr[i] = result.get(i);
		}
		
		return resultArr;
	}
	
	public static void main(String[] args){
		char a[] =  new char[] {1, 2, 3, 4, 5};
		char b[] = new char[] {1, 2, 3, 6, 7};
		
		System.out.println("intersection: ");
		for(char c: union(a,b))
			
			System.out.print((int) c + " ");
	}
}