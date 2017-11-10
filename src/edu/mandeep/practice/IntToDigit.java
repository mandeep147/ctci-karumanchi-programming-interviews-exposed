/**
 * 
 */
package edu.mandeep.practice;

/**
 * Converting an int into a string on individual digits in java
 * Input: 123
 * Output: One Two Three 
 * @author mandeep
 *
 */
public class IntToDigit {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int input = 1240974280;
		convertInt(input);
	}
	
	private static void convertInt(int num){
		char inputNumber[] = Integer.toString(num).toCharArray();
		StringBuilder sb = new StringBuilder();
		
		for(int i = 0; i < inputNumber.length; i++){
			switch(inputNumber[i]){
				case '0': sb.append("Zero ");
						break;
				case '1': sb.append("One ");
						break;
				case '2': sb.append("Two ");
						break;
				case '3': sb.append("Three ");
						break;
				case '4': sb.append("Four ");
						break;
				case '5': sb.append("Five ");
						break;
				case '6': sb.append("Six ");
						break;
				case '7': sb.append("Seven ");
						break;
				case '8': sb.append("Eight ");
						break;
				case '9': sb.append("Nine ");
						break;
			}
		}
		
		System.out.println(sb.toString());
	}
}