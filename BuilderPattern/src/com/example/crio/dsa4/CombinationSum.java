package com.example.crio.dsa4;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSum {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        Arrays.sort(candidates); // Sort candidates to handle duplicates and optimize the solution
        List<List<Integer>> result = new ArrayList<>();
        backtrack(candidates, target, 0, new ArrayList<>(), result);
        return result;
    }

    private void backtrack(int[] candidates, int target, int start, List<Integer> path, List<List<Integer>> result) {
        if (target == 0) {
            result.add(new ArrayList<>(path)); // Found a combination
            return;
        }

        for (int i = start; i < candidates.length; i++) {
            if (candidates[i] > target) break; // If the current candidate exceeds target, no need to explore further
            path.add(candidates[i]); // Include current candidate
            backtrack(candidates, target - candidates[i], i, path, result); // Recur with updated target
            path.remove(path.size() - 1); // Backtrack
        }
    }

    public static void main(String[] args) {
        CombinationSum cs = new CombinationSum();
        int[] candidates = {2, 3, 6, 7};
        int target = 7;
        List<List<Integer>> result = cs.combinationSum(candidates, target);
        System.out.println(result); // Output: [[2, 2, 3], [7]]
    }
}
