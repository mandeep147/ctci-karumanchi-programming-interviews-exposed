package edu.mandeep.practice;

public class ReverseString {
	
	/*static void reverseString(String input){
		
		 * by converting into  char array
		 * 
		char[] inputArr = input.toCharArray();
		
		for( int i = inputArr.length - 1; i >= 0; i-- ){
			System.out.print(inputArr[i]);
		}
		
		//direct way
		for(int i = input.length() - 1; i >= 0 ; i--){
			System.out.print(input.charAt(i));
		}
	}*/
	
	//using recursion
	static String reverseString(String input){
		if( input.length() == 0)
			return " ";
		return input.charAt(input.length() - 1) + reverseString(input.substring(0, input.length() - 1));
	}
	
	public static void main(String[] args){
		//String input = "JAVA";
		String input = "coding is fun";
		System.out.println("string: " +input);
		String reverse = reverseString(input);
		System.out.println("reversed string:" +reverse);
	}
}
