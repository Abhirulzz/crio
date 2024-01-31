package com.example.crio.dsa2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class CountAnagrams {
	
	

	public static List<Integer> findAnagrams(String s, String p) {
		// Create a map to store the counts of sorted substrings
		int k = p.length();
		HashMap<Character, Integer> hmp = new HashMap<Character, Integer>();
		HashMap<Character, Integer> hms = new HashMap<Character, Integer>();
		List<Integer> list = new ArrayList<>();

		for (int i = 0; i < p.length(); i++)
			hmp.put(p.charAt(i), hmp.getOrDefault(p.charAt(i), 0) + 1);

		int R = 0;
		int L = 0;

		while (R < s.length()) {
			hms.put(s.charAt(R), hms.getOrDefault(s.charAt(R), 0) + 1);
			while ((R - L +1) >= k) {
				if (hmp.equals(hms))
					list.add(L);
				hms.put(s.charAt(L), hms.get(s.charAt(L)) - 1);
				if (hms.get(s.charAt(L)) == 0) {
					hms.remove(s.charAt(L));
				}
				L++;
			}

			R++;

		}

		return list;

	}

	    
	    /*	HashMap<Integer, Integer> hm = new HashMap<Integer, Integer>();

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
		
		return count; */
	    public static void main(String[] args) {
	        // Example usage:
	        String s1 = "abab";
	        String s2 = "ab";
	        List<Integer> result = findAnagrams(s1, s2);
	        System.out.println("Number of anagrams between '" + s1 + "' and '" + s2 + "': " + result);
	    }
	}



