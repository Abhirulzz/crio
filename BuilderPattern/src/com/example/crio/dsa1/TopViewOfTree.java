package com.example.crio.dsa1;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.TreeMap;

public class TopViewOfTree {
	

	    public static List<Long> topView(TreeNode root) {
	        ArrayList<Long> result = new ArrayList<>();
	        if (root == null) {
	            return result;
	        }

	        // Use a TreeMap to store nodes based on their horizontal distance
	        TreeMap<Integer, Long> map = new TreeMap<>();
	        Queue<Pair> queue = new LinkedList<>();
	        queue.add(new Pair(root, 0));

	        while (!queue.isEmpty()) {
	            Pair current = queue.poll();
	            TreeNode node = current.node;
	            int hd = current.hd;

	            // If the horizontal distance is not present in the map, add it
	            if (!map.containsKey(hd)) {
	                map.put(hd, node.val);
	            }

	            // Add the child nodes with updated horizontal distance to the queue
	            if (node.left != null) {
	                queue.add(new Pair(node.left, hd - 1));
	            }
	            if (node.right != null) {
	                queue.add(new Pair(node.right, hd + 1));
	            }
	        }

	        // Populate the result list from the TreeMap
	        result.addAll(map.values());

	        return result;
	    }

	    public static void main(String[] args) {
	        // Example usage:
	        // Constructing a sample binary tree
	        TreeNode root = new TreeNode(1);
	        root.left = new TreeNode(2);
	        root.right = new TreeNode(3);
	        root.left.left = new TreeNode(4);
	        root.left.right = new TreeNode(5);
	        root.right.left = new TreeNode(6);
	        root.right.right = new TreeNode(7);
	        root.treePrinter(root);
	        // Finding the top view
	        List<Long> result = topView(root);

	        // Output: [4, 2, 1, 3, 7]
	        System.out.println(result);
	    }
	}



