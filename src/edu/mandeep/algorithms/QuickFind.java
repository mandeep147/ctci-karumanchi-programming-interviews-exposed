package edu.mandeep.algorithms;

import java.util.Scanner;

public class QuickFind {

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
	 * change all entries with id[p] to id[q]
	*/
	private static void union(int p, int q) {
		int pid = arr[p];
		int qid = arr[q];
		
		for(int i = 0; i < arr.length; i++){
			if(pid == arr[i])					//at most 2N+2 array access
				arr[i] = qid;
		}
	}

	/*
	 * check whether p and q are in same (connected) component
	*/
	private static boolean isConnected(int p, int q) {
		return arr[p] == arr[q];
	}
}