package com.example.crio.dsa1;

public class RightViewBinaryView {
	static int maxLevel =0;
	public static void rightView(TreeNode root, int level) {
		
        if (root == null) {
            return;
        }

        // If the current level is greater than the max level seen so far,
        // it means this is the rightmost node for the current level.
        if (level > maxLevel) {
            System.out.println(root.val);
            maxLevel = level;
        }

        // Recursive calls for the right and left subtrees
        rightView(root.right, level + 1);
        rightView(root.left, level + 1);
    }
	
	public static void main(String[] args) {
        // Example usage:
        // Constructing a sample binary tree
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.right = new TreeNode(5);
        root.right.right = new TreeNode(4);
        root.treePrinter(root);
        // Finding the right view recursively
        System.out.println("Right View of the Binary Tree:");
        rightView(root, 1);
    }
}
