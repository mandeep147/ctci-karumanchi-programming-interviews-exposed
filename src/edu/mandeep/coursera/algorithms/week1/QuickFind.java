/**
 * 
 */
package edu.mandeep.coursera.algorithms.week1;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * union: connect 2 objs
 * find: is there a path connecting 2 objects?
 * @author mandeep
 *
 */
public class QuickFind {
	static int arr[];
	/**
	 * @param args
	 * @throws IOException 
	 * @throws NumberFormatException 
	 */
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		String[] strArr = str.split("\\s+");
		
		int numberOfNodes = Integer.parseInt(strArr[0]);
		int numberOfQueries = Integer.parseInt(strArr[1]);
		arr = new int[numberOfNodes];
		arr = quickFind(numberOfNodes, arr);
		
		while(numberOfQueries > 0){
			String input = br.readLine();
			String[] inputArr = input.split("\\s+");		
			int p = Integer.parseInt(inputArr[0]);
			int q = Integer.parseInt(inputArr[1]);
			if(!isConnected(p,q))
				union(p,q);
			numberOfQueries--;
		}
		
		for(int i = 0; i < arr.length; i++){
			System.out.print(arr[i]+ " ");
		}
	}
	
	private static boolean isConnected(int p, int q) {
		return arr[p] == arr[q];
	}

	/*
	 * change all entries with id[p] to id[q]
	 * O(n*n)
	*/
	private static void union(int p, int q) {	
		int pid = arr[p];
		int qid = arr[q];
		for(int i = 0; i < arr.length; i++){
			if(arr[i] == pid)
				arr[i] = qid;
		}
	}

	private static int[] quickFind(int n, int[] arr){
		for(int i = 0; i < n; i++)
			arr[i] = i;
		return arr;
	}
}