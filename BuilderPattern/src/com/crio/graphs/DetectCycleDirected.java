package com.crio.graphs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class DetectCycleDirected {

	public int FindCycle(int nodes, List<List<Integer>> edges) {
		HashMap<Integer, List<Integer>> adj = new HashMap<Integer, List<Integer>>();
		for (int i = 1; i <= nodes; i++) {
			adj.put(i, new ArrayList<>());
		}

		for (List<Integer> src : edges) {
			adj.get(src.get(0)).add(src.get(1));
			// adj.get(src.get(1)).add(src.get(0));
			// adj.put(src.get(0),new ArrayList<>());
		}

		boolean[] vis = new boolean[nodes + 1];
		boolean[] pathVis = new boolean[nodes + 1];
		for (int i = 1; i <= nodes; i++) {
			if (!vis[i])
				if (hasCycle(i, adj, vis, pathVis)) {
					return 1;
				}

		}
		return 0;
	}

	public static boolean hasCycle(int src, HashMap<Integer, List<Integer>> adj, boolean[] vis, boolean[] pathVis) {

		vis[src] = true;
		pathVis[src] = true;

		for (int nbr : adj.get(src)) {
			if (!vis[nbr]) {
				if (hasCycle(nbr, adj, vis, pathVis)) {
					return true;
				}
			} else if (pathVis[nbr]) {
				return true;
			}
		}

		

		pathVis[src] = false;

		return false;
	}

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
		DetectCycleDirected pathFinder = new DetectCycleDirected();

		int result = pathFinder.FindCycle(nodes, edges);
		System.out.println(result);

	}

}
