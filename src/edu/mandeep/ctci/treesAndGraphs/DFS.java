/**
 * implement DFS
 */
package edu.mandeep.ctci.treesAndGraphs;

import java.util.ArrayList;

/**
 * @author mandeep
 *
 */
public class DFS {
	
	static ArrayList<Node> nodes = new ArrayList<Node>();

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Node node40 = new Node(40);
		Node node10 = new Node(10);
		Node node20 = new Node(20);
		Node node30 = new Node(30);
		Node node60 = new Node(60);
		Node node50 = new Node(50);
		Node node70 = new Node(70);

		nodes.add(node40);
		nodes.add(node10);
		nodes.add(node20);
		nodes.add(node30);
		nodes.add(node60);
		nodes.add(node50);
		nodes.add(node70);
		int adjacency_matrix[][] = { { 0, 1, 1, 0, 0, 0, 0 }, // Node 1: 40
				{ 0, 0, 0, 1, 0, 0, 0 }, // Node 2 :10
				{ 0, 1, 0, 1, 1, 1, 0 }, // Node 3: 20
				{ 0, 0, 0, 0, 1, 0, 0 }, // Node 4: 30
				{ 0, 0, 0, 0, 0, 0, 1 }, // Node 5: 60
				{ 0, 0, 0, 0, 0, 0, 1 }, // Node 6: 50
				{ 0, 0, 0, 0, 0, 0, 0 }, // Node 7: 70
		};
		
		System.out.println("DFS: ");
		searchDFS(adjacency_matrix, node40);
	}

	/**
	 * Complexity: O(V+E)
	 * V: number of vertices
	 * E: number of edges
	 * @param root
	 */
	private static void searchDFS(int adj[][], Node root) {
		System.out.print(root.data +" ");
		ArrayList<Node> neighbours = findNeighbours(adj, root);
		for(int i = 0; i < neighbours.size(); i++){
			Node node = neighbours.get(i);
			if(node != null && !node.visited){
				searchDFS(adj, node);
				node.visited = true;
			}
		}
	}
	
	/**
	 * 
	 * @param adj
	 * @param x
	 * @return
	 */
	private static ArrayList<Node> findNeighbours(int adj[][], Node x){
		int nodeIndex = -1;
		ArrayList<Node> neighbours = new ArrayList<Node>();
		for(int i =0; i < nodes.size(); i++){
			if(nodes.get(i).equals(x)){
				nodeIndex = i;
				break;
			}
		}
		
		if(nodeIndex != -1){
			for(int i = 0; i < adj[nodeIndex].length; i++){
				if(adj[nodeIndex][i] == 1)
					neighbours.add(nodes.get(i));
			}
		}
		return neighbours;
	}
}

class Node{
	int data;
	boolean visited;
	
	Node(int data){
		this.data = data;
	}
}