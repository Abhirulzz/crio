package com.example.crio.dsa2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class FirstUniqueInteger {
	

    private Queue<Integer> queue  = new LinkedList<>();
    private Map<Integer, Integer> frequencyMap = new HashMap<>();

	public static void main(String[] args) {
		int[] arr = { 1, 2, 1, 3, 4, 3};
		 ArrayList<Integer> array_list =  
	                new ArrayList<Integer>(); 
	  
	        // Using add() method to add elements in array_list 
	        for (int i = 0; i < arr.length; i++) 
	            array_list.add((arr[i])); 
	        System.out.print(array_list); 
		//List list = Arrays.asList(arr);
		int k = 3;

		int count = firstUniqueInteger(array_list);
		System.out.println(count);
	}
	
	public void enqueue(int num) {
        queue.offer(num);
        frequencyMap.put(num, frequencyMap.getOrDefault(num, 0) + 1);
    }

    // Dequeue and return the first unique number.
    public int dequeue() {
        while (!queue.isEmpty() && frequencyMap.get(queue.peek()) > 1) {
            queue.poll();
        }

        if (!queue.isEmpty()) {
            return queue.peek();
        } else {
            return -1; // No unique number found
        }
    }
	
	public static int firstUniqueInteger(ArrayList<Integer> vec) {

		HashMap<Integer, Integer> frequencyMap = new HashMap<Integer, Integer>();
		Queue<Integer> queue = new LinkedList<>();

		
		for (int num : vec) {
			queue.offer(num);
			frequencyMap.put(num, frequencyMap.getOrDefault(num, 0) + 1);
		}

		 while (!queue.isEmpty() && frequencyMap.get(queue.peek()) > 1) {
	            queue.poll();
	        }

	        if (!queue.isEmpty()) {
	            return queue.peek();
	        } else {
	            return -1; // No unique number found
	        }
	}
	 
	 
	 

}
