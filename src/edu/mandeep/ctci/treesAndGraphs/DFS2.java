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
public class DFS2 {

	//no of vertices
	private int v;
	
	//array of lists for adjacency list representation
	private static LinkedList<Integer> adj[];
	
	@SuppressWarnings("unchecked")
	public DFS2(int v){
		this.v = v;
		adj = new LinkedList[v];
		
		for(int i = 0; i < v; i++)
			adj[i] = new LinkedList<>();
	}
	
	
	/**
	 * 
	 * @param v
	 * @param visited
	 */
	private void DFSUtil(int v , boolean visited[]){
		visited[v] = true;
		System.out.print(v + " ");
		
		Iterator<Integer> adjVertex = adj[v].listIterator();
		
		while(adjVertex.hasNext()){
			int n = adjVertex.next();
			
			if(!visited[n])
				DFSUtil(n, visited);
		}
	}
	
	/**
	 * Complexity: O(V+E)
	 */
	private void dfsTraversal(){
		boolean[] visited = new boolean[v];
		
		for(int i = 0; i < v; i++){
			if(visited[i] == false)
				DFSUtil(i, visited);
		}
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		DFS2 g = new DFS2(4);
		
		GraphUtil.addEdge(0, 1, adj);
		GraphUtil.addEdge(0, 2, adj);
		GraphUtil.addEdge(1, 2, adj);
		GraphUtil.addEdge(2, 0, adj);
		GraphUtil.addEdge(2, 3, adj);
		GraphUtil.addEdge(3, 3, adj);
		
		System.out.println("DFS Traversal: ");
		
		g.dfsTraversal();
	}

}