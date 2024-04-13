package com.example.crio.dsa1;

public class DiameterOfBinaryTree {
	
	public static int diameterOfBinaryTree(TreeNode root) {
	     // base case if tree is empty
	        if (root == null)
	            return 0;
	 
	        // get the height of left and right sub-trees
	        System.out.println(root.val);
	        int lheight = height(root.left);
	        int rheight = height(root.right);
	 
	        // get the diameter of left and right sub-trees
	        int ldiameter = diameterOfBinaryTree(root.left);
	        int rdiameter = diameterOfBinaryTree(root.right);
	 
	        /* Return max of following three
	          1) Diameter of left subtree
	          2) Diameter of right subtree
	          3) Height of left subtree + height of right
	          subtree + 1
	         */
	        return Math.max(lheight + rheight ,
	                        Math.max(ldiameter, rdiameter));
	    }
	
	 static int height(TreeNode node)
	    {
	        // base case tree is empty
		 if (node != null)
		   System.out.println("height" +node.val);
	        if (node == null)
	            return 0;
	 
	        // If tree is not empty then height = 1 + max of
	        //  left height and right heights
	        return (1
	                + Math.max(height(node.left),
	                           height(node.right)));
	    }
	 public static void main(String args[])
	 
	 /*
	  * 8 7 4 5 10
1 -1 2
2 3 4
3 5 -1
4 -1 -1
5 -1 -1
	  */
	    {
	        // creating a binary tree and entering the nodes
		   TreeNode tree = new TreeNode(8);
	        //TreeTreeNode tree = new TreeNode();
	        //tree.root = new TreeNode(1);
	        tree.left = new TreeNode(2);
	        tree.right = new TreeNode(7);
	        tree.right.left = new TreeNode(4);
	        tree.right.right = new TreeNode(5);
	        tree.left.left = new TreeNode(4);
	        tree.left.right = new TreeNode(5);
	        tree.right.left.left = new TreeNode(10);
	        tree.left.left.left = new TreeNode(10);
	        tree.treePrinter(tree);
	        // Function Call
	        System.out.println(
	            "The diameter of given binary tree is : "
	            + diameterOfBinaryTree(tree));
	    }
	 
	
}
