package edu.mandeep.practice;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class MinimumNumber {

	public static void main(String[] args) {
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
		
		int number = sc.nextInt();
		//int number = 23145;
		int k = sc.nextInt();
		//int k = 3;
		minimumNumber(number, k);
	}
	
	private static void minimumNumber(int n , int k){
		
		List<Integer> sorted = new ArrayList<>();
		int temp = n;
		int i = 0;
		while(temp > 0 ){
			sorted.add(temp % 10);
			temp /= 10;
			i++;
		}
		
		Collections.sort(sorted);
		
		for(i = 0; i < k - 1; i++){
			System.out.print(sorted.get(i));
		}
	}
}