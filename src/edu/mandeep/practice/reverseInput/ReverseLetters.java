package edu.mandeep.practice.reverseInput;

public class ReverseLetters {
	
	public static void main(String[] args){
	
		String input = "coding is fun";
		System.out.println("string: " +input);
		
		reverseString(input);
	}
	static void reverseString(String input){
		
		String[] words = input.split(" ");
		String reversedString = "";
		
		for(int i = 0; i < words.length; i++){
			
			String word = words[i];
			String reversedWord = "";
			
			for(int j = word.length() - 1; j >= 0; j--){
				reversedWord += word.charAt(j);
			}
			
			reversedString += reversedWord + " ";
		}
		System.out.println(reversedString);
	}	
}