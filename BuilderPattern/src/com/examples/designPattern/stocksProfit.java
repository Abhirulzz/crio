package com.examples.designPattern;

public class stocksProfit {
	
	
		// Function to find the maximum profit possible by
		// buying and selling stocks any number of times
		static int maxProfit(int[] prices, int n)
		{

			if (n < 2)
				return 0;
			int sellingDate = 0;
			int buyingDate = 0;
			int totalProfit = 0;
			for (int i = 1; i < n; i++) {
				if (prices[i] >= prices[i - 1])
					sellingDate++;
				else {
					totalProfit += (prices[sellingDate]
									- prices[buyingDate]);
					sellingDate = buyingDate = i;
				}
			}
			totalProfit
				+= (prices[sellingDate] - prices[buyingDate]);
			return totalProfit;
		}

		public static void main(String[] args)
		{
			// Given prices
			//int[] prices = { 7, 1, 5, 3, 6, 4 };
			int[] prices = { 1,2,3,4,5 };

			// Function Call to calculate maximum profit
			// possible
			int ans = maxProfit(prices, 5);

			// Print the total profit
			System.out.print(ans);
		}
	}

	// This code is contributed by garg28harsh.



