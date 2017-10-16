/**
 * Problem 10.8: Find Duplicates
 * Given an array with numbers from 1 to N; N <= 32000, which may or may not have duplicate entries.
 * Without knowing the N and only 4 Kilobytes of memory available, how would you print duplicate elements in the array?
 */
package edu.mandeep.ctci.sortingAndSearching;

/**
 * @author mandeep
 *
 */
public class FindDuplicates {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int[] arr = {1, 2, 3, 1, 2, 3, 4, 5, 1, 3, 5, 3, 6, 7 ,810, 32, 42, 67, 810};
		checkDuplicates(arr);
	}

	/**
	 * @param arr
	 */
	private static void checkDuplicates(int[] arr) {

		BitSet bs = new BitSet(32000);
		for(int i = 0; i < arr.length; i++){
			int num = arr[i];
			int num0 = num - 1;	//bitset starts at 0 but number starts at 1
			
			if(bs.get(num0))
				System.out.print(num +" ");
			else
				bs.set(num0);
		}
		
	}

}

class BitSet{
	
	int[] bitset;
	
	public BitSet(int size){
		bitset = new int[(size >> 5) + 1]; //divide by 32
	}
	
	boolean get(int pos){
		int wordNumber = (pos >> 5); 	//divide by 32
		int bitNumber = (pos & 0x1F);	//mod by 32
		
		return (bitset[wordNumber] & (1 << bitNumber)) != 0;
	}
	
	void set(int pos){
		int wordNumber = (pos >> 5); 	//divide by 32
		int bitNumber = (pos & 0x1F);	//mod by 32
		
		bitset[wordNumber] |= (1 << bitNumber);
	}
}