/**
 * Problem 10.10: Rank from Stream
 * Imagine you are reading in a stream of integers. Periodically, you wish to be able to look up the rank of a number x (the
 * number of values less than or equal to x). Implement the data structures and algorithms to support these operations.
 * That is, implement the method track(int x), which is called when each number is generated, and the method getRankOfNumber(int x), which returns the number of values
 * less than or equal to x (not including x itself).
 *
 * EXAMPLE
 * Stream (in order of appearance): 5, 1, 4, 4, 5, 9, 7, 13, 3
 * getRankOfNumber(l) = 0
 * getRankOfNumber(3) = 1
 * getRankOfNumber(4) = 3
 */
package edu.mandeep.ctci.sortingAndSearching;


/**
 * @author mandeep
 *
 */
public class RankFromStream {
	static RankNode root = null;

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int arr[] = {5, 1, 4, 4, 5, 9,  7, 13, 3};
		for (int a : arr)
			track(a);
		
		System.out.println(getRankOfNumber(1));
		System.out.println(getRankOfNumber(3));
		System.out.println(getRankOfNumber(4));
	}
	
	static void track(int x){
		if(root == null)
			root = new RankNode(x);
		else 
			root.insert(x);
	}

	static int getRankOfNumber(int x){
		return root.getRank(x);
	}
}

class RankNode{

	public int leftSize = 0;
	public RankNode left, right;
	public int data = 0;
	
	/**
	 * @param x
	 */
	public RankNode(int x) {
		data = x;
	}

	/**
	 * @param x
	 * @return
	 */
	public int getRank(int x) {
		if( x == data)
			return leftSize;
		else if(x < data ){
			if(left == null)
				return -1;
			else 
				return left.getRank(x);
		}else{
			int rightRank = right == null? -1 : right.getRank(x);
			if(rightRank == -1)
				return -1;
			else
				return leftSize + 1 + rightRank;
		}
	}

	/**
	 * @param x
	 */
	public void insert(int x) {
		if(x <= data){
			if(left != null)
				left.insert(x);
			else 
				left = new RankNode(x);
			leftSize++;
		}else{
			if(right != null)
				right.insert(x);
			else
				right = new RankNode(x);
		}
	}
	
}