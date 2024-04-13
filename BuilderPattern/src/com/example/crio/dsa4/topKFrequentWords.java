package com.example.crio.dsa4;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

public class topKFrequentWords {

	public static void main(String[] args) {

		int seats[] = { 2, 2, 2, 3, 3,5,8,1,1 }; 
		
		int k = 2;
		//5+4+4+3+3+3
		//22

		System.out.println(topKFrequent(seats, k ));
	}

	
	static List<Integer> topKFrequent(int[] nums, int k)  {
		
		Map<Integer,Integer> freqMap = new HashMap<>();
		for(int val: nums)
		{
			freqMap.put(val, freqMap.getOrDefault(val, 0)+1);
		}
		PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> {

			if (freqMap.get(a) < freqMap.get(b))
				return -1;
			else if (freqMap.get(a) > freqMap.get(b))
				return 1;
			else
				return 0;
		});

		for (int num : freqMap.keySet()) {
            pq.offer(num);
            if (pq.size() > k) {
                pq.poll();
            }
        }
		
		ArrayList<Integer> ans = new ArrayList<Integer>(pq);

		return ans;
	}
}
