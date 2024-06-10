package com.crio.tree;

import com.example.crio.dsa2.TreeNode;

public class KthLargestBST {
	

	    TreeNode root;
	    int count = 0;
	    int result = -1;

	    // Helper function to perform reverse in-order traversal
	    private void reverseInOrder(TreeNode node, int k) {
	        if (node == null || count >= k) {
	            return;
	        }

	        // Traverse the right subtree first
	        reverseInOrder(node.right, k);

	        // Increment the count of visited nodes
	        count++;

	        // If count is equal to k, we've found our Kth largest element
	        if (count == k) {
	            result = node.val;
	            return;
	        }

	        // Traverse the left subtree
	        reverseInOrder(node.left, k);
	    }

	    // Function to find the Kth largest element
	    public int findKthLargest(TreeNode node, int k) {
	        reverseInOrder(node, k);
	        return result;
	    }

	    public static void main(String[] args) {
	    	KthLargestBST tree = new KthLargestBST();
	        tree.root = new TreeNode(50);
	        tree.root.left = new TreeNode(30);
	        tree.root.right = new TreeNode(70);
	        tree.root.left.left = new TreeNode(20);
	        tree.root.left.right = new TreeNode(40);
	        tree.root.right.left = new TreeNode(60);
	        tree.root.right.right = new TreeNode(80);

	        int k = 3;
	        int kthLargest = tree.findKthLargest(tree.root, k);
	        if (kthLargest != -1) {
	            System.out.println("The " + k + "rd largest element is " + kthLargest);
	        } else {
	            System.out.println("The tree does not have " + k + " elements.");
	        }
	    }
	}



