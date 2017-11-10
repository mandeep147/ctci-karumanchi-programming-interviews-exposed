/**
 * 
 */
package edu.mandeep.practice;

/**
 * @author mandeep
 *
 */
public class KEmptyGroups {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		//int[] p = {2, 5, 1, 4, 3};
		//int[] p = {2, 4, 3, 1, 5};
		int[] p = {2, 1, 4, 3};
		int k = 2;
		//int k = 1;
		System.out.println(kEmptyGroups(p, k));
	}
	
	private static int kEmptyGroups(int[] p, int k){
		int[] flag = new int[p.length];
		for(int i = 0; i < p.length; i++){
			int count = 0;
			flag[p[i] - 1] = 1;
			for(int j = 0; j < p.length; j++){
				if(flag[j] != 1)
					count++;
				else if(count == k)
					return i + 1 ;
				else 
					count = 0;
			}
		}
		return -1;
	}
}