/**
 * 
 */
package edu.mandeep.ctci.treesAndGraphs;

import java.util.LinkedList;

/**
 * @author mandeep
 *
 */
public class GraphUtil {
	static void addEdge(int v, int w, LinkedList<Integer> adj[]){
		adj[v].add(w);
	}
}