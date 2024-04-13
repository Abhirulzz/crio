package com.example.crio.dsa1;

public class FindInorderSuccessor {
	
	
	    public static int findInorderSuccessor(TreeNode root, TreeNode node) {
	        // Case 1: If the right subtree is not null
	        if (node.right != null) {
	            return findMin(node.right);
	        }

	        // Case 2: If the right subtree is null and the node has a parent
	        TreeNode successor = null;
	        while (root != null) {
	            if (node.val < root.val) {
	                successor = root;
	                root = root.left;
	            } else if (node.val > root.val) {
	                root = root.right;
	            } else {
	            	return -1;
	            }
	        }

	        return (int) successor.val;
	    }

	    // Helper method to find the leftmost node in a subtree
	    private static int findMin(TreeNode node) {
	        while (node.left != null) {
	            node = node.left;
	        }
	        return (int)node.val;
	    }

	    public static void main(String[] args) {
	        //InorderSuccessor tree = new InorderSuccessor();
	        TreeNode root = new TreeNode(20);
	        root.left = new TreeNode(10);
	        root.right = new TreeNode(30);
	        root.left.left = new TreeNode(5);
	        root.left.right = new TreeNode(15);
	        root.right.left = new TreeNode(25);
	        root.right.right = new TreeNode(35);

	        TreeNode node = root.right.right; // Node for which we want to find the inorder successor
	        root.treePrinter(root);
	         int successor =findInorderSuccessor(root, node);

	        if (successor != -1) {
	            System.out.println("Inorder successor of " + node.val + " is: " + successor);
	        } else {
	            System.out.println("Inorder successor does not exist.");
	        }
	    }
	}



