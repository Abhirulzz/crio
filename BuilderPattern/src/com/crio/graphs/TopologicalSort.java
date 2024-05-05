package com.crio.graphs;

import java.util.*;

public class TopologicalSort {

    public int[] findOrder(int numCourses, int[][] prerequisites) {
        // Step 1: Build the graph representation
        List<List<Integer>> adjList = new ArrayList<>();
        int[] inDegree = new int[numCourses];

        for (int i = 0; i < numCourses; i++) {
            adjList.add(new ArrayList<>());
        }

        for (int[] edge : prerequisites) {
            int from = edge[1];
            int to = edge[0];
            adjList.get(from).add(to);
            inDegree[to]++;
        }

        // Step 2: Perform topological sorting using Kahn's algorithm
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            if (inDegree[i] == 0) {
                queue.offer(i);
            }
        }

        int[] result = new int[numCourses];
        int index = 0;

        while (!queue.isEmpty()) {
            int node = queue.poll();
            result[index++] = node;

            for (int neighbor : adjList.get(node)) {
                inDegree[neighbor]--;
                if (inDegree[neighbor] == 0) {
                    queue.offer(neighbor);
                }
            }
        }

        // Step 3: Check for cycle (if all nodes are included in the result)
        if (index != numCourses) {
            return new int[0]; // Cycle detected, return empty array
        }

        return result;
    }

    public static void main(String[] args) {
        TopologicalSort topologicalSort = new TopologicalSort();

        // Example: Finding order of courses with prerequisites
        int numCourses = 5;
        int[][] prerequisites = {{0, 1}, {0, 2}, {3, 4}};

        int[] order = topologicalSort.findOrder(numCourses, prerequisites);

        if (order.length == 0) {
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


