package com.crio.dp;

public class BoundedKnapsack {
	
	    public static long knapsack(int W, long[] weights, long[] values) {
	        int n = weights.length;
	        long[][] dp = new long[n + 1][W + 1];

	        // Build table dp[][] in bottom-up manner
	        for (int i = 0; i <= n; i++) {
	            for (int w = 0; w <= W; w++) {
	                if (i == 0 || w == 0) {
	                    dp[i][w] = 0;
	                } else if (weights[i - 1] <= w) {
	                    dp[i][w] = Math.max(values[i - 1] + dp[i - 1][(int) (w - weights[i - 1])], dp[i - 1][w]);
	                } else {
	                    dp[i][w] = dp[i - 1][w];
	                }
	            }
	        }

	        return dp[n][W];
	    }

	    public static void main(String[] args) {
	        int W = 5;
	        int[] weights = {1,2, 3, 4};
	        int[] values = {6, 10,12,7};

	        System.out.println("Maximum value: " + knapsack(W, weights, values));
	    }
	}



