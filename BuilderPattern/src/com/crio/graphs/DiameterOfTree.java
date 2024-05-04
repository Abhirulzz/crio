package com.crio.graphs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DiameterOfTree {
	private TreeNode root;

    public DiameterOfTree() {
        this.root = null;
    }
    
    public void constructBinaryTree(List<List<Integer> > edges) {
        if (edges == null || edges.size() == 0) {
            return;
        }

        Map<Integer, TreeNode> nodeMap = new HashMap<>();

        // Create nodes and populate nodeMap
        for (List<Integer> edge : edges) {
            int parentVal = edge.get(0);
            int childVal = edge.get(1);

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
    
    private static int diameterOfTree(int n,List<List<Integer> > edges)
	{
		return 2;
	}
	
    public void inorderTraversal(TreeNode node) {
        if (node == null) {
            return;
        }
        inorderTraversal(node.left);
        System.out.print(node.val + " ");
        inorderTraversal(node.right);
    }
	public static void main(String[] args) {
        // Example usage:
        //int[][] edges = { {1, 2}, {1, 3}, {2, 4}, {2, 5}, {3, 6} };
        List<List<Integer>> edges = new ArrayList<>();
        edges.add(Arrays.asList(1, 2));
        edges.add(Arrays.asList(1, 3));
        edges.add(Arrays.asList(2, 4));
        edges.add(Arrays.asList(2, 5));
        edges.add(Arrays.asList(3, 6));
        
        int nodes  =0;
        for (List<Integer> edge : edges) {
            nodes = Math.max(nodes, edge.get(0));
            nodes = Math.max(nodes, edge.get(1));
        }
        DiameterOfTree binaryTree = new DiameterOfTree();

        // Construct the binary tree from edges
        binaryTree.constructBinaryTree(edges);
        int diameter = diameterOfTree(nodes,edges);

        // Perform inorder traversal to verify the constructed tree
        System.out.println("Inorder traversal of the constructed binary tree:");
        binaryTree.inorderTraversal(binaryTree.root);
        
        System.out.println(diameter);
    }

}
