package com.crio.dp;

public class RobingHouse {
	
	public static long houseThief(int n, int []arr) {
		
		if (arr.length == 0)
			return 0;
		if (arr.length == 1)
			return arr[0];
		if (arr.length == 2)
			return Math.max(arr[0], arr[1]);
		int dp[] = new int[arr.length];
		dp[0] =arr[0];
		dp[1] = Math.max(arr[0], arr[1]);
		
		for(int i=2;i<arr.length;i++)
		{
			dp[i] = Math.max(arr[i]+dp[i-2], dp[i-1]);
		}
		
		return dp[n-1];
	}
	
	 public static void main(String[] args) {
	        int n = 7;
	        int arr[] = {2 ,5, 1, 3, 6, 2, 4};
	        System.out.println("max" + n + " steps: " + houseThief(n,arr));
	    }

}
