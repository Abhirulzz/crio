package com.example.crio.dsa4;

import java.util.ArrayList;
import java.util.List;

public class Permutation {

		    public static List<List<Integer>> permute(int[] nums) {
	        List<List<Integer>> result = new ArrayList<>();
	        List<Integer> current = new ArrayList<>();
	        boolean[] used = new boolean[nums.length];
	        generatePermutations(nums, used, current, result);
	        return result;
	    }

	    private static void generatePermutations(int[] nums, boolean[] used, List<Integer> current, List<List<Integer>> result) {
	        // Base case: if current permutation size equals nums length, add to result
	        if (current.size() == nums.length) {
	            result.add(new ArrayList<>(current));
	            return;
	        }

	        for (int i = 0; i < nums.length; i++) {
	            if (!used[i]) {
	                // Choose element
	                used[i] = true;
	                current.add(nums[i]);
	                
	                // Recursively generate permutations
	                generatePermutations(nums, used, current, result);
	                
	                // Backtrack
	                used[i] = false;
	                current.remove(current.size() - 1);
	            }
	        }
	    }

	    public static void main(String[] args) {
	        int[] nums = {1, 2, 3};
	        List<List<Integer>> permutations = permute(nums);
	        
	        // Print all permutations
	        for (List<Integer> permutation : permutations) {
	            System.out.println(permutation);
	        }
	    }
	}


