package com.crio.graphs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

public class Police {
	  public static ArrayList<Integer> townsAndPoliceStations(int n,List<List<Integer> >  edges,List<Integer> sources){

		  HashMap<Integer, List<Integer>> adj = new HashMap<Integer, List<Integer>>();
			for (int i = 1; i <= n; i++) {
				adj.put(i, new ArrayList<>());
			}

			for (List<Integer> src : edges) {
				adj.get(src.get(0)).add(src.get(1));
				adj.get(src.get(1)).add(src.get(0));
				// adj.put(src.get(0),new ArrayList<>());
			}

			Queue<Integer> queue = new LinkedList<>();
	        Set<Integer> visited = new HashSet<>();
	        Map<Integer, Integer> parent = new HashMap<>();

	        // Initialize BFS
	        queue.add(start);
	        visited.add(start);
	        parent.put(start, null);

	        // BFS traversal
	        while (!queue.isEmpty()) {
	            int current = queue.poll();

	            // Check if we've reached the end vertex
	            if (current == end) {
	                break;
	            }

	            // Explore neighbors
	            for (int neighbor : adj.getOrDefault(current, new ArrayList<>())) {
	                if (!visited.contains(neighbor)) {
	                    visited.add(neighbor);
	                    parent.put(neighbor, current);
	                    queue.add(neighbor);
	                }
	            }
	        }
		
	    }
	  
	  
	  private static boolean isBipartiteUtil(int src, int[] color,HashMap<Integer, List<Integer>> adj ) {
	        Queue<Integer> queue = new LinkedList<>();
	        queue.offer(src);
	        color[src] = 0; // Color the source node with color 0

	        while (!queue.isEmpty()) {
	            int u = queue.poll();

	            for (int v : adj.get(u)) {
	                if (color[v] == -1) { // Unvisited node
	                    color[v] = 1 - color[u]; // Color with opposite color of u
	                    queue.offer(v);
	                } else if (color[v] == color[u]) {
	                    return false; // Same color found for adjacent nodes, not bipartite
	                }
	            }
	        }
	        return true;
	    }
	  public static void main(String[] args) {
	        // Example input: list of edges represented as list of lists
	        List<List<Integer>> edges = new ArrayList<>();
	        edges.add(Arrays.asList(5, 4));
	        edges.add(Arrays.asList(2, 1));
	        edges.add(Arrays.asList(1, 3));
	        edges.add(Arrays.asList(4, 2));
	        edges.add(Arrays.asList(2, 5));
	        
	      
	        int nodes  =0;
	        for (List<Integer> edge : edges) {
	            nodes = Math.max(nodes, edge.get(0));
	            nodes = Math.max(nodes, edge.get(1));
	        }
	        //Bipartite pathFinder = new Bipartite();
	        ArrayList<Integer> src = new ArrayList<>();
	        src.add(2);
	        ArrayList<Integer> result = townsAndPoliceStations(nodes,edges,src);
	            System.out.println(result);
	        
	    }

}
