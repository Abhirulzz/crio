package com.crio.graphs;

import java.util.ArrayList;
import java.util.List;

class Node1 {
	    int val;
	    List<Node1> children;

	    public Node1(int val) {
	        this.val = val;
	        this.children = new ArrayList<>();
	    }
	}

	public class NAryTree {
	    int maxDiameter;

	    public int diameter(Node1 root) {
	        if (root == null) return 0;
	        maxDiameter = 0;
	        dfs(root);
	        return maxDiameter;
	    }

	    private int dfs(Node1 Node1) {
	        if (Node1 == null) return 0;

	        // Keep track of the two maximum depths from this Node1
	        int firstMaxDepth = 0;
	        int secondMaxDepth = 0;

	        for (Node1 child : Node1.children) {
	            int childDepth = dfs(child);
	            if (childDepth > firstMaxDepth) {
	                secondMaxDepth = firstMaxDepth;
	                firstMaxDepth = childDepth;
	            } else if (childDepth > secondMaxDepth) {
	                secondMaxDepth = childDepth;
	            }
	        }

	        // Update the maximum diameter found so far
	        int currentDiameter = firstMaxDepth + secondMaxDepth;
	        maxDiameter = Math.max(maxDiameter, currentDiameter);

	        // Return the maximum depth from this Node1
	        return 1 + firstMaxDepth;
	    }

	    public static void main(String[] args) {
	        // Example usage
	        Node1 root = new Node1(1);
	        root.children.add(new Node1(2));
	        root.children.add(new Node1(3));
	        root.children.get(0).children.add(new Node1(4));
	        root.children.get(0).children.add(new Node1(5));
	        root.children.get(1).children.add(new Node1(6));

	        NAryTree treeDiameter = new NAryTree();
	        int result = treeDiameter.diameter(root);
	        System.out.println("Diameter of the tree: " + result);
	    }
	}



