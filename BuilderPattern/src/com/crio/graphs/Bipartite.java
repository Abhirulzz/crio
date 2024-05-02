package com.crio.graphs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Bipartite {
	private static String possibleBipartition(int n, List<List<Integer> > edges) {
		HashMap<Integer, List<Integer>> adj = new HashMap<Integer, List<Integer>>();
		for (int i = 1; i <= n; i++) {
			adj.put(i, new ArrayList<>());
		}

		for (List<Integer> src : edges) {
			adj.get(src.get(0)).add(src.get(1));
			adj.get(src.get(1)).add(src.get(0));
			// adj.put(src.get(0),new ArrayList<>());
		}

		int[] color = new int[n + 1];
		Arrays.fill(color, -1);

        // Check each component in case the graph is disconnected
        for (int i = 1; i <= n; i++) {
            if (color[i] == -1) { // Unvisited node
                if (!isBipartiteUtil(i, color,adj)) {
                    return "Possible";
                }
            }
        }
        return "NotPossible";
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
        Bipartite pathFinder = new Bipartite();

          String result = pathFinder.possibleBipartition(nodes,edges);
            System.out.println(result);
        
    }

}
