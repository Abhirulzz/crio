package com.example.crio.dsa4;

import java.util.ArrayList;

public class PalindromicPartition {
	public static void main(String[] args) {
        String input = "aabb";
        ArrayList<ArrayList<String>> result = partition(input);
        for (ArrayList<String> partition : result) {
            System.out.println(partition);
        }
    }

    public static ArrayList<ArrayList<String>> partition(String s) {
    	ArrayList<ArrayList<String>> result = new ArrayList<>();
        backtrack(result, new ArrayList<>(), s, 0);
        return result;
    }

    private static void backtrack(ArrayList<ArrayList<String>> result, ArrayList<String> temp, String s, int start) {
    	//System.out.println("backtrack" + temp);
        if (start == s.length()) {
        	System.out.println("return");
        	System.out.println("---------------------");
            result.add(new ArrayList<>(temp));
            return;
        }

        for (int i = start; i < s.length(); i++) {
        	System.out.println("loop " + s.substring(start, i + 1) +  " " + i);
            if (isPalindrome(s, start, i)) {
                temp.add(s.substring(start, i + 1));
                System.out.println("backtrack" + " " +temp + " " + start +" " + s) ;
                backtrack(result, temp, s, i + 1);
                temp.remove(temp.size() - 1);
            }
        }
    }

    private static boolean isPalindrome(String s, int low, int high) {
        while (low < high) {
            if (s.charAt(low++) != s.charAt(high--)) {
                return false;
            }
        }
        return true;
    }
}
