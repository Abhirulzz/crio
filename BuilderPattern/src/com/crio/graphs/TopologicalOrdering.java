package com.crio.graphs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class TopologicalOrdering {
	private static List<Integer> topologicalOrdering(int numCourses,List<List<Integer> > prerequisites)
	{
	
	        // Step 1: Build the graph representation
	        List<List<Integer>> adjList = new ArrayList<>();
	        int[] inDegree = new int[numCourses +1];

	        for (int i = 0; i <= numCourses; i++) {
	            adjList.add(new ArrayList<>());
	        }

	        for (List<Integer> edge : prerequisites) {
	            int from = edge.get(1);
	            int to = edge.get(0);
	            adjList.get(from).add(to);
	            inDegree[to]++;
	        }

	        // Step 2: Perform topological sorting using Kahn's algorithm
	        Queue<Integer> queue = new LinkedList<>();
	        for (int i = 1; i <= numCourses; i++)
	            if (inDegree[i] == 0) {
	                queue.offer(i);
	            }
	        

	        List<Integer> result = new ArrayList<>();
	        int index = 0;

	        while (!queue.isEmpty()) {
	            int node = queue.poll();
	            result.add(node);

	            for (int neighbor : adjList.get(node)) {
	                inDegree[neighbor]--;
	                if (inDegree[neighbor] == 0) {
	                    queue.offer(neighbor);
	                }
	            }
	        }

	        // Step 3: Check for cycle (if all nodes are included in the result)
	        if (index != numCourses) {
	            return new ArrayList<>(); // Cycle detected, return empty array
	        }
	        System.out.println();
	        return result;
	    }

	    public static void main(String[] args) {
	        //TopologicalSort topologicalSort = new TopologicalSort();

	        // Example: Finding order of courses with prerequisites
	        int numCourses = 5;
	        //int[][] prerequisites = {{1, 0}, {2, 0}, {3, 1}, {3, 2}};
	        List<List<Integer>> edges = new ArrayList<>();
	       
	        //edges.add(Arrays.asList(5, 3));
	        edges.add(Arrays.asList(1, 2));
	        edges.add(Arrays.asList(1, 3));
	        edges.add(Arrays.asList(4, 5));
	        //edges.add(Arrays.asList(2, 5));
	        List<Integer> order = topologicalOrdering(numCourses, edges);

	        if (order.size()== 0) {
	            System.out.println("Cycle detected, topological order not possible.");
	        } else {
	            System.out.println("Topological order of courses:");
	            for (int course : order) {
	                System.out.print(course + " ");
	            }
	            System.out.println();
	        }
	    }
	}



