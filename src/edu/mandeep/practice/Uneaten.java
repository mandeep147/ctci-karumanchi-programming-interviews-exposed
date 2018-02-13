/**
 * 
 */
package edu.mandeep.practice;

import java.util.ArrayList;

/**
 * @author mandeep
 *
 */
public class Uneaten {
	
	public static void main(String[] args){
		int[] arr = {4,2,3,5,7};
		int n = 20;
		System.out.println(findUneatenLeaves(arr, n));
	}
	
	public static int findUneatenLeaves(int[] array, int n) {
	    ArrayList<Integer> uneatenLeaves = new ArrayList<Integer>();
	    ArrayList<Integer> eatenLeaves = new ArrayList<Integer>();
	    for (int i = 0; i < n; i++) {
	        uneatenLeaves.add(i);
	    }
	    // 1. find the multiple of the eatenLeaves
	    for (int i = 0; i < array.length; i++) {
	        eatenLeaves.add(array[i]);
	        for (int j = 1; j < uneatenLeaves.size(); j++) {
	            if (array[i] * uneatenLeaves.get(j) < n) {
	                eatenLeaves.add(array[i] * uneatenLeaves.get(j));
	            }
	        }
	    }
	    for (int i = 0; i < eatenLeaves.size(); i++) {
	        for (int j = 1; j < uneatenLeaves.size(); j++) {
	            if (eatenLeaves.get(i) == uneatenLeaves.get(j)) {
	                uneatenLeaves.remove(uneatenLeaves.get(j));
	            }
	        }
	    }
	    System.out.println(uneatenLeaves.size());
	    return uneatenLeaves.size();
	}
}
