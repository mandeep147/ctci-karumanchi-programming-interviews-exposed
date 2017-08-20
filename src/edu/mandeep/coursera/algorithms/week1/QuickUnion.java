package edu.mandeep.coursera.algorithms.week1;

import java.util.Scanner;

public class QuickUnion {
	static int arr[];
	public static void main(String[] args) {
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
		int numberOfNodes = sc.nextInt();
		int numberOfQueries = sc.nextInt();
		arr = new int[numberOfNodes];
		
		/*
		 * set id of each object to itself
		 * N array access
		*/
		for (int i = 0; i < numberOfNodes; i++){
			arr[i] = i;
		}
		
		while(numberOfQueries > 0){
			int p = sc.nextInt();
			int q = sc.nextInt();
			//System.out.println(p+ " "+q + "is connected" + isConnected(p, q));
			if(!isConnected(p,q)){	
				union(p,q);
				//System.out.println(p+ " "+ q+ " is connected" + isConnected(p, q));				
			}
			numberOfQueries--;
		}
		for(int i = 0; i < arr.length; i++){
			System.out.print(arr[i]+ " ");
		}
	}

	/*
	 * change root of p to point to the root of q
	 * depth of p and q array access
	*/
	private static void union(int p, int q) {
		int pid = root(p);
		int qid = root(q);
		arr[pid] = qid;		
	}

	/*
	 * check whether p and q have same root
	 * depth of p and q array access
	*/
	private static boolean isConnected(int p, int q) {
		return root(p) == root(q);
	}

	/*
	 * chase parent pointer until reaches root
	 * depth of i array access
	*/
	private static int root(int q) {
		while(q != arr[q])
			q = arr[q];
		return q;
	}
}