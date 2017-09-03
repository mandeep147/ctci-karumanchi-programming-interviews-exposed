package edu.mandeep.coursera.AlgortihmsToolBox.week3;
import java.util.Arrays;
import java.util.Comparator;

/**
 * What is the largest number that consists of digits 3, 9, 5, 9, 7, 1? Use all digits.
 * Posible solutions: 359179, 537991, 913579, . . .
 * Correct answer: 997531.
 * @author mandeep
 */
public class LargestNumber {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int a[] = {3, 3, 5, 9, 7, 1};
		findLargestDigit(a);
	}
	
	private static void findLargestDigit(int[] arr){
		String[] newArr = new String[arr.length];
		for(int i = 0; i < arr.length; i++)
			newArr[i] = String.valueOf(arr[i]);
		
		Arrays.sort(newArr, new Comparator<String>(){
			public int compare(String a, String b){
				return (b + a).compareTo(a + b);
			}
		});
		
		StringBuilder sb = new StringBuilder();
		
		for(String str : newArr)
			sb.append(str);
		
		while(sb.charAt(0) == '0' && sb.length() > 1)
			sb.deleteCharAt(0);
		
		System.out.println(sb.toString());
	}
}