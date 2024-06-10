package com.crio.dp;

import java.util.ArrayList;
import java.util.List;

public class DecodeNumber {
	public static int numDecodings(String s ) { 
		int n=s.length();
		List<Integer> cache = new ArrayList<>();
				
		  if (n == 0 || (n == 1 && s.charAt(0) == '0'))
	            return 0;
		
		return numDecoding(s,n);
    }
	
	public static int numDecoding(String s, int n)
	{
		// base cases
        if (n == 0 || n == 1)
            return 1;
 
        // for base condition "01123" should return 0
        if (s.charAt(0) == '0')
            return 0;
 
        // Initialize count
        int count = 0;
 
        // If the last digit is not 0, then
        // last digit must add to
        // the number of words
        if (s.charAt(n-1) > '0')
            count = numDecoding(s, n - 1);
 
        // If the last two digits form a number
        // smaller than or equal to 26,
        // then consider last two digits and recur
        if (s.charAt(n-2) == '1'
            || (s.charAt(n-2) == '2'
                && s.charAt(n-1) < '7'))
            count += numDecoding(s, n - 2);
 
        return count;//int n =s.length()	;
		
	}
	
	public static void main(String[] args) {
        int n = 7;
        String s = "1516";
        System.out.println("No of ways to decode " + numDecodings(s));
    }

}
