package com.crio.graphs;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Queue;

public class ValidPathInGraph {
	
	public boolean routeBetweenNodes(int source , int destination ,int n,  List<List<Integer>> edges) {
		
		HashMap<Integer, List<Integer>> adj = new HashMap<Integer, List<Integer>>();
		for (int i = 1; i <= n; i++) {
			adj.put(i, new ArrayList<>());
		}

		for (List<Integer> src : edges) {
			adj.get(src.get(0)).add(src.get(1));
			adj.get(src.get(1)).add(src.get(0));
			// adj.put(src.get(0),new ArrayList<>());
		}
		boolean[] vis = new boolean[n+1];
		
		return bfs(source,destination,adj,vis);
		
    }
	
	public boolean bfs(int src , int dest ,HashMap<Integer, List<Integer>> adj,boolean[] vis) {
		Queue<Integer> q = new ArrayDeque<>();
		q.add(src);
		vis[src] = true;
		while(q.size()!=0)
		{
			src = q.remove();
			
			for (int nbr : adj.get(src)) {
				if (nbr == dest)
					return true;
				
				if (!vis[nbr])
				{
					vis[nbr] = true;
				
				q.add(nbr);
				}
			}
		}
		return false;
			
		}
	
	/*
	 * while (!queue.isEmpty()) {
            int node = queue.poll();

            for (int neighbor : adj[node]) {
                if (neighbor == end) {
                    return true; // Found a path to the end node
                }
                if (!visited[neighbor]) {
                    visited[neighbor] = true;
                    queue.offer(neighbor);
                }
            }
        }
	 */
	public static void main(String[] args) {
		// Example input: list of edges represented as list of lists
		List<List<Integer>> edges = new ArrayList<>();

		edges.add(Arrays.asList(1, 2));
		edges.add(Arrays.asList(4, 1));
		edges.add(Arrays.asList(2, 4));

		int nodes = 0;
		for (List<Integer> edge : edges) {
			nodes = Math.max(nodes, edge.get(0));
			nodes = Math.max(nodes, edge.get(1));
		}
		ValidPathInGraph pathFinder = new ValidPathInGraph();

		boolean result = pathFinder.routeBetweenNodes(1 , 4,nodes, edges);
		System.out.println(result);
	}

}
