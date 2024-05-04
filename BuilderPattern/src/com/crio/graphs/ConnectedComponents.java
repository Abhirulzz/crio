package com.crio.graphs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class ConnectedComponents {
	int connectedComponentsInGraph(int n,  List<List<Integer>> edges) {
		HashMap<Integer, List<Integer>> adj = new HashMap<Integer, List<Integer>>();
		for (int i = 1; i <= n; i++) {
			adj.put(i, new ArrayList<>());
		}

		for (List<Integer> src : edges) {
			adj.get(src.get(0)).add(src.get(1));
			adj.get(src.get(1)).add(src.get(0));
			// adj.put(src.get(0),new ArrayList<>());
		}

		boolean[] vis = new boolean[n + 1];
		int count =0 ;
		for(int i =1;i<=n;i++)
		{
			if(vis[i])
				continue;
			dfs(i,vis,adj);
			count++;
		}
		return count;
    }
	private void dfs(int idx,boolean[] vis,HashMap<Integer, List<Integer>> adj)
	{

		if(vis[idx])
			return;
		vis[idx] = true;
		if(!adj.containsKey(idx))
			return;
		
		for(int nbr:adj.get(idx))
		{
			dfs(nbr, vis, adj);
		}
		
	}
	
	public static void main(String[] args) {
        // Example input: list of edges represented as list of lists
        List<List<Integer>> edges = new ArrayList<>();
        edges.add(Arrays.asList(1, 2));
        edges.add(Arrays.asList(3, 4));
        edges.add(Arrays.asList(4, 5));
        //edges.add(Arrays.asList(4, 2));
        //edges.add(Arrays.asList(2, 5));
        
      
        int nodes  =0;
        for (List<Integer> edge : edges) {
            nodes = Math.max(nodes, edge.get(0));
            nodes = Math.max(nodes, edge.get(1));
        }
        ConnectedComponents pathFinder = new ConnectedComponents();

          int result = pathFinder.connectedComponentsInGraph(nodes,edges);
            System.out.println(result);
        
    }

}
