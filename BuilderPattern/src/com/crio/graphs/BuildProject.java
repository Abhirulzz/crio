package com.crio.graphs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.Stack;

public class BuildProject {
	
	
		
		    private static boolean dfs(int node, Set<String> vis , Stack<String> st,
					HashMap<String, List<String>> adj, List<String> proj) {
		    	
		    	if (vis.contains(proj.get(node))) 
		   		 
		   		 return true;
		   		 
				vis.add(proj.get(node));
				for (String it : adj.get(proj.get(node))) {
					for (int i = 0; i < proj.size(); i++) {
						if (proj.get(i).equals(it)) {
							if (!vis.contains(it)) {
								if (dfs(i, vis, st, adj, proj))
									return true;
							} else {
								return true;
							}
							//break;
						}
						break;
					}
				}
				st.push(proj.get(node));
				return false;
			}

		    // Function to return list containing vertices in Topological order.
		    static  ArrayList<String>topoSort( ArrayList<String> proj,List<List<String>> edges) {

		    	int V = proj.size();
		    	HashMap<String, List<String>> adj = new HashMap<String, List<String>>();
				for (int i = 0; i <V; i++) {
					adj.put(proj.get(i), new ArrayList<>());
				}

				for (List<String> src : edges) {
					adj.get(src.get(0)).add(src.get(1));
					//adj.get(src.get(1)).add(src.get(0));
					// adj.put(src.get(0),new ArrayList<>());
				}
				boolean hasCycle = false;
				Set<String> vis = new HashSet<>();
		        Stack<String> st = new Stack<String>();
		        for (int i = 0; i < V; i++) {
		            if (!vis.contains(proj.get(i))) {
		                if(dfs(i, vis, st, adj,proj))
		                	hasCycle = true;
		            }
		        }

		        ArrayList<String> ans = new ArrayList<>();
				if (!hasCycle) {
					while (!st.isEmpty()) {
						ans.add(st.peek());
						st.pop();
					}
					return ans;
				}
		       else
		    
		       {
		        ans.add("-1");
		        return ans;
		       }
		    }

		
		    public static void main(String[] args) {
		        // Example input: list of edges represented as list of lists
		        List<List<String>> edges = new ArrayList<>();
		        edges.add(Arrays.asList("3", "2"));
		        edges.add(Arrays.asList("5", "1"));
		        edges.add(Arrays.asList("2", "4"));
		        //edges.add(Arrays.asList("4", "2"));
		        //edges.add(Arrays.asList("2", "5"));
		        
		        ArrayList<String> proj = new ArrayList<>();
		        //proj.add("5");
		        proj.add("1");
		        proj.add("2");
		                
		        proj.add("3");
		        proj.add("4");
		        proj.add("5");
		       // int nodes  =0;
		        //for (List<String> edge : edges) {
		         //   nodes = Math.max(nodes, edge.get(0));
		          //  nodes = Math.max(nodes, edge.get(1));
		        //}
		        //Bipartite pathFinder = new Bipartite();
		  

		        ArrayList<String> result = topoSort(proj,edges);
		          for (String node : result) {
		              System.out.print(node + " ");
		          }
		          System.out.println("");
		        
		    }
		}






