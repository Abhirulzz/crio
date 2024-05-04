package com.crio.graphs;

import java.util.*;

class TreeNode {
    int val;
    List<TreeNode> neighbors;

    public TreeNode(int val) {
        this.val = val;
        this.neighbors = new ArrayList<>();
    }

    public void addNeighbor(TreeNode neighbor) {
        this.neighbors.add(neighbor);
    }
}

public class TreeDiameterDFS {

    // Global variables to track diameter and farthest node
    private int diameter;
    private TreeNode farthestNode;

    public TreeDiameterDFS() {
        this.diameter = 0;
        this.farthestNode = null;
    }

    // Function to find the diameter of the tree using DFS
    public int treeDiameter(TreeNode root) {
        if (root == null) {
            return 0;
        }

        // Perform DFS from an arbitrary node (e.g., root)
        dfs(root, 0, null);

        // Reset for the second DFS from the farthest node
        this.diameter = 0;
        dfs(this.farthestNode, 0, null);

        return this.diameter;
    }

    // DFS traversal to find the farthest node and calculate the diameter
    private void dfs(TreeNode node, int depth, TreeNode parent) {
        if (node == null) {
            return;
        }

        // Update diameter if current depth is greater
        if (depth > this.diameter) {
            this.diameter = depth;
            this.farthestNode = node;
        }

        // Recursively visit neighbors
        for (TreeNode neighbor : node.neighbors) {
            if (neighbor != parent) { // Avoid revisiting the parent node
                dfs(neighbor, depth + 1, node);
            }
        }
    }

    public static void main(String[] args) {
        // Example usage:
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(4);
        TreeNode node5 = new TreeNode(5);

        node1.addNeighbor(node2);
        node1.addNeighbor(node3);
        node2.addNeighbor(node4);
        node2.addNeighbor(node5);

        TreeDiameterDFS treeDiameterDFS = new TreeDiameterDFS();
        int diameter = treeDiameterDFS.treeDiameter(node1);

        System.out.println("Diameter of the tree: " + diameter);
    }
}

