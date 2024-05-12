package com.crio.dp;



	public class CountWaysToClimb {

	    public static long countWaysToClimb(int n) {
	        if (n <= 0) {
	            return 0;
	        }

	        // Use variables to store the previous three states (dp[i-1], dp[i-2], dp[i-3])
	        long prev3 = 1; // Represents dp[i-3]
	        long prev2 = 1; // Represents dp[i-2]
	        long prev1 = 2; // Represents dp[i-1]

	        if (n == 1) {
	            return prev1; // Only one way to reach step 1 (take one step of size 1)
	        }

	        if (n == 2) {
	            return prev1 + prev2; // Two ways to reach step 2 (1+1 or 2)
	        }

	        // Calculate dp[i] for i = 3 to n
	        for (int i = 3; i <= n; i++) {
	            long current = prev1 + prev2 + prev3;
	            prev3 = prev2;
	            prev2 = prev1;
	            prev1 = current;
	        }

	        return prev1%1000000007;
	    }

	    public static void main(String[] args) {
	        int n = 3;
	        System.out.println("Number of ways to climb " + n + " steps: " + countWaysToClimb(n));
	    }
	}


