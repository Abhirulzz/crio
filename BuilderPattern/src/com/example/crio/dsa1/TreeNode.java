package com.example.crio.dsa1;

public class TreeNode {

	public long val;
	public TreeNode left;
	public TreeNode right;

	public  TreeNode (int x) {
	        val = x;
	        left = null;
	        right = null;
	}
	
	public  void treePrinter(TreeNode tree) {
        int h = height1(tree);
        int col = getcol(h);
        long[][] M = new long[h][col];
        printTree(M, tree, col / 2, 0, h);
        for (int i = 0; i < h; i++) {
            for (int j = 0; j < col; j++) {
                if (M[i][j] == 0)
                    System.out.print("  ");
                else
                    System.out.print(M[i][j] + " ");
            }
            System.out.println();
        }
    }
	
	public static int height1(TreeNode root) {
        if (root == null)
            return 0;
        return Math.max(height1(root.left), height1(root.right)) + 1;
    }
 
    public static int getcol(int h) {
        if (h == 1)
            return 1;
        return getcol(h - 1) + getcol(h - 1) + 1;
    }
 
    public static void printTree(long[][] M, TreeNode root, int col, int row, int height) {
        if (root == null)
            return;
        M[row][col] = root.val;
        printTree(M, root.left, col - (int)Math.pow(2, height - 2), row + 1, height - 1);
        printTree(M, root.right, col + (int)Math.pow(2, height - 2), row + 1, height - 1);
    }
 
	    

}
