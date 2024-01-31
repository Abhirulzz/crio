package com.example.crio.dsa2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class LongestPalindrome {
	
	public static void main(String[] args) {
		String s = "bbde";
		int k = 3;

		int count = longestPalindrome(s.length(),s);
		System.out.println(count);
	}
	
	  static int longestPalindrome(int n, String s) {
		  int count=0;
		  HashMap<Character, Integer> hms = new HashMap<Character, Integer>();
		  
		  for (int i = 0; i < s.length(); i++)
		  {
				hms.put(s.charAt(i), hms.getOrDefault(s.charAt(i), 0) + 1);
		  }
			for (Map.Entry<Character, Integer> entry : hms.entrySet()) {
				if(entry.getValue()%2 == 0)
					count= count +entry.getValue();
				else
					count = count +entry.getValue() - 1;
			}
			  if (count%2  == 0)
				  count =count +1;
			
		  
		  return count;
	    }

}
