package com.crio.graphs;

import java.util.*;

class TreeNode1 {
    int val;
    TreeNode left;
    TreeNode right;

    public TreeNode1(int val) {
        this.val = val;
        this.left = null;
        this.right = null;
    }
}

public class BinaryTree {
    private TreeNode root;

    public BinaryTree() {
        this.root = null;
    }

    // Method to construct the binary tree from edges
    public void constructBinaryTree(int[][] edges) {
        if (edges == null || edges.length == 0) {
            return;
        }

        Map<Integer, TreeNode> nodeMap = new HashMap<>();

        // Create nodes and populate nodeMap
        for (int[] edge : edges) {
            int parentVal = edge[0];
            int childVal = edge[1];

            TreeNode parent = nodeMap.computeIfAbsent(parentVal, TreeNode::new);
            TreeNode child = nodeMap.computeIfAbsent(childVal, TreeNode::new);

            if (parent.left == null) {
                parent.left = child;
            } else {
                parent.right = child;
            }
        }

        // Find the root node (assuming there's only one node without a parent)
        for (TreeNode node : nodeMap.values()) {
            if (node.left != null && !nodeMap.containsValue(node.left)) {
                this.root = node;
                break;
            }
        }
    }

    // Method to print the binary tree using inorder traversal
    public void printTree() {
        System.out.println("Binary Tree:");
        printTreeHelper(root, 0);
    }

    private void printTreeHelper(TreeNode node, int level) {
        if (node == null) {
            return;
        }

        printTreeHelper(node.right, level + 1);

        for (int i = 0; i < level; i++) {
            System.out.print("    "); // Indent based on the current level
        }
        System.out.println(node.val); // Print the node value

        printTreeHelper(node.left, level + 1);
    }

    public static void main(String[] args) {
        // Example usage:
        int[][] edges = { {1, 2}, {1, 3}, {2, 4}, {2, 5}, {3, 6} };

        BinaryTree binaryTree = new BinaryTree();

        // Construct the binary tree from edges
        binaryTree.constructBinaryTree(edges);

        // Print the binary tree
        binaryTree.printTree();
    }
}
