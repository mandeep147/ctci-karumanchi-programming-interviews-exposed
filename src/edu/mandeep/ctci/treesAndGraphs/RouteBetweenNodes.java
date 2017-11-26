/**
 * Problem 4.1: Given a directed graph, design an algorithm to find out whether there is a route between two nodes.
 */
package edu.mandeep.ctci.treesAndGraphs;

import java.util.Iterator;
import java.util.LinkedList;

/**
 * @author mandeep
 *
 */
public class RouteBetweenNodes {

	private int v;
	static LinkedList<Integer>[] adj;
	
	@SuppressWarnings("unchecked")
	public RouteBetweenNodes(int v){
		this.v = v;
		adj = new LinkedList[v];
		
		for(int i = 0; i < v; i++)
			adj[i] = new LinkedList<>();
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		RouteBetweenNodes g = new RouteBetweenNodes(4);
		
		GraphUtil.addEdge(0, 1, adj);
		GraphUtil.addEdge(0, 2, adj);
		GraphUtil.addEdge(1, 2, adj);
		GraphUtil.addEdge(2, 0, adj);
		GraphUtil.addEdge(2, 3, adj);
		GraphUtil.addEdge(3, 3, adj);
		
		//int u = 1, v = 3;
		int u = 3, v = 1;
		if(g.isReachable(u, v))
			System.out.println("Path exists between: "+ u +" and "+v);
		else
			System.out.println("Path does not exists between: "+ u +" and "+v);
	}

	/**
	 * @param u
	 * @param v2
	 * @return
	 */
	private boolean isReachable(int source, int dest) {
		boolean[] visited = new boolean[v];
		
		LinkedList<Integer> queue = new LinkedList<Integer>();
		
		visited[source] = true;
		queue.add(source);
		
		Iterator<Integer> adjVertices;
		
		while(queue.size() != 0){
			source = queue.poll();
			
			int n;
			adjVertices = adj[source].listIterator();
			
			while(adjVertices.hasNext()){
				n = adjVertices.next();
				
				if(n == dest)
					return true;
				
				if(!visited[n]){
					visited[n] = true;
					queue.add(n);
				}
			}
		}
		return false;
	}

}