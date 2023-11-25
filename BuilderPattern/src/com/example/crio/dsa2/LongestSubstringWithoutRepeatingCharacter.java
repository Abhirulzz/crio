package com.example.crio.dsa2;

import java.util.HashSet;

public class LongestSubstringWithoutRepeatingCharacter {
	public static void main(String args[]) {
		String str = "rtmnxgmasjxanjkicwbbaefglqilrrizhpbettrlbumsimjwuylewpvimnoffhyspcihyzhcajtjceanyoeisnqqpqtunkgcztcy";
		System.out.println(str);
		// System.out.println(capitalise(str));
		int k = 3;
		System.out.println(lengthOfLongestSubstring(str));
	}
	
	 public static int lengthOfLongestSubstring(String s) {
	 
	        HashSet<Character> hs = new HashSet<Character>();
	        char[] charArray = s.toCharArray();
	        int R=0;
	        int L=0;
	        int maxLength = 0;
			while (R < charArray.length) {
				
				int lastIndexOfcurrentCharacter = s.indexOf(charArray[R], L);
				
				if (lastIndexOfcurrentCharacter != R) {
					L= lastIndexOfcurrentCharacter+1;
				}
				
							
				maxLength = Math.max(maxLength, R - L + 1);
				
				R++;
			}
			
			return maxLength;
	    }

}
