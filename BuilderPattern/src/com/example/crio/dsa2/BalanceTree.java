package com.example.crio.dsa2;

public class BalanceTree {
	
	
	    TreeNode root;

	    // Helper function to check height balance
	    private class HeightBalance {
	        int height;
	        boolean balanced;

	        HeightBalance(int height, boolean balanced) {
	            this.height = height;
	            this.balanced = balanced;
	        }
	    }

	    // Recursive function to check height balance
	    private HeightBalance checkHeightBalance(TreeNode node) {
	        if (node == null)
	            return new HeightBalance(0, true);

	        HeightBalance left = checkHeightBalance(node.left);
	        HeightBalance right = checkHeightBalance(node.right);

	        boolean balanced = left.balanced && right.balanced && Math.abs(left.height - right.height) <= 1;
	        int height = 1 + Math.max(left.height, right.height);

	        return new HeightBalance(height, balanced);
	    }

	    // Function to check if tree is balanced
	    boolean isBalanced(TreeNode node) {
	        return checkHeightBalance(node).balanced;
	    }

	    public static void main(String[] args) {
	    	BalanceTree tree = new BalanceTree();
	        tree.root = new TreeNode(1);
	        tree.root.left = new TreeNode(2);
	        tree.root.right = new TreeNode(3);
	        tree.root.left.left = new TreeNode(4);
	        tree.root.left.right = new TreeNode(5);
	        tree.root.right.right = new TreeNode(6);
	        tree.root.left.left.left = new TreeNode(7);

	        if (tree.isBalanced(tree.root))
	            System.out.println("The tree is balanced");
	        else
	            System.out.println("The tree is not balanced");
	    }
	}



