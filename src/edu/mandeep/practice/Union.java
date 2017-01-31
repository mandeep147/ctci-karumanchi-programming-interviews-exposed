package edu.mandeep.practice;

import java.util.Set;
import java.util.TreeSet;

public class Union {
	public static void main(String[] args){
		char a[] =  new char[] {1, 2, 3, 4, 5};
		char b[] = new char[] {1, 2, 3, 6, 7};
		Set<Character> set1 = new TreeSet<Character>();
		Set<Character> set2 = new TreeSet<Character>();
		
		for( char i : a)
			set1.add(i);
		
		for( char i : b)
			set2.add(i);
		
		union(set1, set2);
		intersection(set1, set2);
		difference(set1, set2);
	}

	private static void union(Set<Character> set1, Set<Character> set2) {
		Set<Character> unionSet = new TreeSet<Character>(set1);
		unionSet.addAll(set2);
		
		System.out.print("union:");
		for(char i : unionSet)
			System.out.print((int)i+ " ");
	}
	
	/*
	 * difference A- B
	*/
	private static void difference(Set<Character> set1, Set<Character> set2) {
		Set<Character> intersectSet = new TreeSet<Character>(set1);
		intersectSet.removeAll(set2);
		System.out.println();
		System.out.print("difference:");
		for(char i : intersectSet)
			System.out.print((int)i+ " ");
	}
	
	private static void intersection(Set<Character> set1, Set<Character> set2) {
		Set<Character> intersectSet = new TreeSet<Character>();
		
		for(char c : set1 ){
			if(set2.contains(c))
				intersectSet.add(c);
		}
		System.out.println();
		System.out.print("intersection:");
		for(char i : intersectSet)
			System.out.print((int)i+ " ");
	}
}
