package com.example.crio.dsa2;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class CountSort {

	static String countSort(int n, String s) {
		HashMap<Character, Integer> hm = new HashMap<Character, Integer>();

		char[] charArray = s.toCharArray();
		int i = 0;

		while (i < charArray.length) {
			hm.put(charArray[i], hm.getOrDefault(charArray[i], 0) + 1);
			i++;
		}

		TreeMap<Character, Integer> tree = new TreeMap<>();

		// Copy all data from hashMap into TreeMap
		tree.putAll(hm);
		StringBuilder sbf = new StringBuilder();
		for (Map.Entry<Character, Integer> entry : tree.entrySet()) {

			for (int k = 0; k < entry.getValue(); k++) {

				sbf.append(entry.getKey());

			}

		}

		return sbf.toString().trim();
	}

	public static void main(String args[]) {
		String str = "acceddaefgb";
		System.out.println(str);
		// System.out.println(capitalise(str));
		int k = 3;
		System.out.println(countSort(str.length(), str));
	}

}
