/**
 * Problem 10.1: Sorted Merge
 * Given 2 sorted arrays, A and B. Merge B into A in sorted order.
 */
package edu.mandeep.ctci.sortingAndSearching;

/**
 * @author mandeep
 *
 */
public class SortedMerge {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int[] arrayA = {1, 2, 4, 6, 24, 30, 0, 0, 0, 0};
		int[] arrayB = {5, 23, 25, 35};

		int lastB = arrayB.length;
		int lastA = arrayA.length - lastB;
		sortedmerge(arrayA, arrayB, lastA, lastB);
		SortingUtil.printArray(arrayA);
	}

	/**
	 * Complexity: O(indexB)
	 * @param array
	 * @param arrayB 
	 */
	private static void sortedmerge(int[] arrayA, int[] arrayB, int lastA, int lastB) {
		
		int indexB = lastB - 1;
		int indexA = lastA - 1;
		System.out.println(indexB+" "+indexA);
		
		int indexMerged = lastA + lastB - 1;
		
		while(indexB >= 0){
			if(indexA >= 0 && arrayA[indexA] > arrayB[indexB]){
				arrayA[indexMerged] = arrayA[indexA];
				indexA--;
			}else{
				arrayA[indexMerged] = arrayB[indexB];
				indexB--;
			}
			indexMerged--;
		}
	}

}