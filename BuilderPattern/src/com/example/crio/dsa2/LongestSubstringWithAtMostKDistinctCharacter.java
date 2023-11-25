package com.example.crio.dsa2;

import java.util.HashMap;

public class LongestSubstringWithAtMostKDistinctCharacter {

	public static int lengthOfLongestSubstringKDistinct(String s, int k) {

		HashMap<Character, Integer> hm = new HashMap<Character, Integer>();

		char[] charArray = s.toCharArray();
		int R = 0;
		int L = 0;
		int maxLength = 0;
		while(R< charArray.length)  {
			hm.put(charArray[R], hm.getOrDefault(charArray[R], 0)+1);
			while(hm.size() > k)
			{
				hm.put(charArray[L], hm.get(charArray[L])-1);
				if(hm.get(charArray[L]) ==0)
				{
					hm.remove(charArray[L]);
				}
				L++;
			}
			
			maxLength = Math.max(maxLength, R-L+1);
			R++;
			
		}
		
		

		return maxLength;

	}

	public static void main(String args[]) {
		String str = "abcddefg";
		System.out.println(str);
		// System.out.println(capitalise(str));
		int k = 3;
		System.out.println(lengthOfLongestSubstringKDistinct(str, k));
	}

}
