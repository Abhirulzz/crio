package com.example.crio.dsa4;

import java.util.PriorityQueue;

import com.example.crio.dsa4.MaximumActivity.Activity;

public class MaxKnapsack {
	
	static class ItemValue {
        Double cost;
        double wt, val, ind;
  
        public ItemValue(int wt, int val)
        {
            this.wt = wt;
            this.val = val;
            
            cost = (double)((double)val/(double)wt);
        }

		@Override
		public String toString() {
			return "ItemValue [cost=" + cost + ", wt=" + wt + ", val=" + val + "]";
		}
        
        
    }
	static double fractionalKnapsack(int n, int capacity, int[] wt, int[] val)
    {
		
		double maximumProfit = 0;
		PriorityQueue<ItemValue> pq = new PriorityQueue<>((item1, item2) -> {

			if (item1.cost > item2.cost)
				return -1;
			else if (item1.cost < item2.cost)
				return 1;
			else
				return 0;
		});

		for (int i = 0; i < n; i++)
			pq.add(new ItemValue(wt[i], val[i]));
		
		while (pq.size() != 0 && capacity > 0) {
			
			ItemValue currentItem = pq.poll();
			double quantity =  Math.min(currentItem.wt, capacity);
			maximumProfit = maximumProfit + (currentItem.cost * quantity);
			capacity = capacity- (int)quantity;
			
		}

		return maximumProfit;

		
    }
	public static void main(String args[]) {
		int wt[] = { 2,2,3 };
		int val[] = {100,10,120 };
		int capacity = 4;
		System.out.println(fractionalKnapsack(wt.length,capacity, wt, val));
	}

}
