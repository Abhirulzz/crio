package com.example.crio.dsa2;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BinaryTreeLevelOrderTraversal {



    public static List<List<Integer>> binaryTreeLevelOrderTraversal(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();

        if (root == null) {
            return result;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            int levelSize = queue.size();
            List<Integer> currentLevel = new ArrayList<>();

            for (int i = 0; i < levelSize; i++) {
                TreeNode currentNode = queue.poll();
                currentLevel.add((int)(currentNode.val));

                if (currentNode.left != null) {
                    queue.offer(currentNode.left);
                }

                if (currentNode.right != null) {
                    queue.offer(currentNode.right);
                }
            }

            result.add(currentLevel);
        }

        return result;
    }
    
    public static List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();

        if (root == null) {
            return result;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        boolean leftToRight = true;

        while (!queue.isEmpty()) {
            int levelSize = queue.size();
            List<Integer> currentLevel = new LinkedList<>(); // Use LinkedList for O(1) insertion at the beginning

            for (int i = 0; i < levelSize; i++) {
                TreeNode currentNode = queue.poll();

                if (leftToRight) {
                    currentLevel.add(currentNode.val);
                } else {
                    currentLevel.add(0, currentNode.val); // Insert at the beginning for reverse order
                }

                if (currentNode.left != null) {
                    queue.offer(currentNode.left);
                }

                if (currentNode.right != null) {
                    queue.offer(currentNode.right);
                }
            }

            result.add(currentLevel);
            leftToRight = !leftToRight;
        }

        return result;
    }
    
    public static void main(String[] args) {
       
        // Create a sample binary tree
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);

        // Perform level order traversal
        //List<List<Integer>> result = binaryTreeLevelOrderTraversal(root);
        List<List<Integer>> result = zigzagLevelOrder(root);
//zigzagLevelOrder
        // Print the result
        System.out.println("Level Order Traversal:");
        for (List<Integer> level : result) {
            System.out.println(level);
        }
    }
}

	
	


