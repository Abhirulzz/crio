package com.crio.graphs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

public class ShortestPath {
	
	public static List<Integer> shortestPath(int n,List<List<Integer>> edges,int start,int end){
		
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

        // Reconstruct path if end vertex is reachable
        if (visited.contains(end)) {
            List<Integer> path = new ArrayList<>();
            int step = end;
            while (step != start) {
                path.add(step);
                step = parent.get(step);
            }
            path.add(start);
            Collections.reverse(path);
            return path;
        } else {
            return null; // No path found
        }
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

          List<Integer> path= shortestPath(nodes,edges, 1,4);
            System.out.println(path.toString());
        
    }


}
