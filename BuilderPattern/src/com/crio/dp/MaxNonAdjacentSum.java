package com.crio.dp;

public class MaxNonAdjacentSum {
	public static int maxNonAdjacentSum(int[] nums) {
        int n = nums.length;
        if (n == 0) return 0;
        if (n == 1) return nums[0];

        int[] dp = new int[n];
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);

        for (int i = 2; i < n; i++) {
            dp[i] = Math.max(dp[i-1], nums[i] + dp[i-2]);
        }

        return dp[n-1];
    }

    public static void main(String[] args) {
        int[] nums = {3, 2, 7, 10};
        System.out.println("Maximum sum of non-adjacent elements: " + maxNonAdjacentSum(nums));
    }
}
