package com.example.crio.dsa1;

import java.util.ArrayList;
import java.util.List;

public class StringsPermutation {
	    public static List<String> generatePermutations(String input) {
	        List<String> permutations = new ArrayList<>();
	        generatePermutations("", input, permutations);
	        return permutations;
	    }

	    private static void generatePermutations(String prefix, String remaining, List<String> permutations) {
	        int length = remaining.length();
	        if (length == 0) {
	            permutations.add(prefix);
	        } else {
	            for (int i = 0; i < length; i++) {
	                generatePermutations(prefix + remaining.charAt(i),
	                                     remaining.substring(0, i) + remaining.substring(i + 1, length),
	                                     permutations);
	            }
	        }
	    }

	    public static void main(String[] args) {
	        String input = "aabc";
	        List<String> permutations = generatePermutations(input);
	        System.out.println("Permutations of " + input + ":");
	        for (String permutation : permutations) {
	            System.out.println(permutation);
	        }
	    }
	}



