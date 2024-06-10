package com.crio.dp;

public class SubSetSum {
	
	    public static boolean isSubsetSum(int[] nums, int target) {
	        int n = nums.length;
	        boolean[][] dp = new boolean[n + 1][target + 1];

	        // Initialize dp array for the case when sum is 0 (true for all subsets including the empty subset)
	        for (int i = 0; i <= n; i++) {
	            dp[i][0] = true;
	        }
	        
	     
	        System.out.println("--------------------------------------------------------------------");

	        // Fill the dp array
	        for (int i = 1; i <= n; i++) {
	            for (int j = 1; j <= target; j++) {
	                if (nums[i - 1] <= j) {
	                    dp[i][j] = dp[i - 1][j] || dp[i - 1][j - nums[i - 1]];
	                    System.out.println(i +""+ j + " " + (i-1) +""+j + " " + (i - 1)+ ""+(j - nums[i - 1]) );
	                } else {
	                    dp[i][j] = dp[i - 1][j];
	                }
	            }
	        }
	        
	        System.out.println("--------------------------------------------------------------------");
	        
			for (int i = 1; i <= n; i++) {
				for (int j = 1; j <= target; j++) {
					System.out.print(i+""+j + dp[i][j]);
				}
				System.out.println();
			}
	        

	        return dp[n][target];
	    }

	    public static void main(String[] args) {
	        int[] nums = {3, 34, 4, 12, 5, 2};
	        int target = 9;
	        System.out.println(isSubsetSum(nums, target));  // Output: true
	    }
	}


