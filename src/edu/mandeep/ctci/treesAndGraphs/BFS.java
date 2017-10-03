/**
 * 
 */
package edu.mandeep.ctci.treesAndGraphs;

import java.util.Iterator;
import java.util.LinkedList;

/**
 * @author mandeep
 *
 */
public class BFS {

	// no of vertices
	private int v;

	// array of lists for adjacency list representation
	private static LinkedList<Integer> adj[];

	public BFS(int v) {
		this.v = v;
		adj = new LinkedList[v];

		for (int i = 0; i < v; i++)
			adj[i] = new LinkedList<>();
	}
	
	/**
	 * Complexity: O(V+E)
	 */
	private void bfsTraversal(int s) {
		boolean[] visited = new boolean[v];
		LinkedList<Integer> queue = new LinkedList<>();
		
		visited[s] = true;
		queue.add(s);
		
		while(queue.size() != 0){
			s = queue.poll();
			System.out.print(s+ " ");
			
			Iterator<Integer> adjVertex = adj[s].listIterator();
			while(adjVertex.hasNext()){
				int n = adjVertex.next();
				
				if(!visited[n]){
					visited[n] = true;
					queue.add(n);
				}
			}
		}
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		BFS g = new BFS(4);
		
		GraphUtil.addEdge(0, 1, adj);
		GraphUtil.addEdge(0, 2, adj);
		GraphUtil.addEdge(1, 2, adj);
		GraphUtil.addEdge(2, 0, adj);
		GraphUtil.addEdge(2, 3, adj);
		GraphUtil.addEdge(3, 3, adj);
		
		System.out.println("BFS Traversal starting from vertex 2: ");
		
		g.bfsTraversal(2);
	}
}