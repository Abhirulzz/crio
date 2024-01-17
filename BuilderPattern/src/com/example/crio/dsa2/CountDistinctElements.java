package com.example.crio.dsa2;

import java.util.ArrayList;
import java.util.HashMap;

public class CountDistinctElements {
	
	public static void main(String[] args) {
		int[] arr = { 1, 2, 1, 3, 4, 3};
		int k = 3;

		ArrayList<Integer> count = countDistinctElements(arr.length,k,arr);
		System.out.println(count);
	}
	
	static ArrayList<Integer> countDistinctElements(int n, int k, int arr[]) {

		HashMap<Integer, Integer> hm = new HashMap<Integer, Integer>();

		ArrayList<Integer> count = new ArrayList<>();

		int R = 0;
		int L = 0;

		while (R < arr.length) {
			hm.put(arr[R], hm.getOrDefault(arr[R], 0) + 1);
			while ((R - L + 1) >= k) {
				count.add(hm.size());
				hm.put(arr[L], hm.get(arr[L]) - 1);
				if (hm.get(arr[L]) == 0) {
					hm.remove(arr[L]);
				}
				L++;
			}

			R++;

		}
		
		return count;
	}
	 
	 
	 
	 
	}


