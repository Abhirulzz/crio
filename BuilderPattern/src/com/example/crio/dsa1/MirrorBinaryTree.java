package com.example.crio.dsa1;

public class MirrorBinaryTree {
	public static TreeNode createMirror(TreeNode root) {
        if (root == null) {
            return null;
        }

        // Swap left and right subtrees for the current node
        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;

        // Recursively create mirrors for the left and right subtrees
        createMirror(root.left);
        createMirror(root.right);

        return root;
    }
	
	public static void main(String[] args) {
        // Example usage:
        // Constructing a sample binary tree
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);

        // Displaying the original tree
        System.out.println("Original tree (Inorder Traversal):");
        root.treePrinter(root);
        System.out.println();

        // Creating the mirror of the binary tree
        TreeNode mirrorRoot = createMirror(root);

        // Displaying the mirrored tree
        System.out.println("Mirror tree (Inorder Traversal):");
        mirrorRoot.treePrinter(mirrorRoot);
    }

}
