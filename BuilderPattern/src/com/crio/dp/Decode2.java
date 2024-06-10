package com.crio.dp;



import java.util.ArrayList;
import java.util.List;

public class Decode2{
	public static int numDecodings(String s ) { 
		int n=s.length();
		List<Integer> cache = new ArrayList<>();
		for(int i =0;i<= n;i++)
		{
			cache.add(i,-1);
		}
		
		
		return numDecoding(s,0,cache,n);
    }
	
	public static int numDecoding(String s,int i,List<Integer> cache, int n)
	{
		// base cases
        if (i==n)
            return 1;
        
        if(s.charAt(i) == '0')
        	return 0;
        
        if(cache.get(i) != -1)
        {
        	System.out.println("i" + i +" " +cache.get(i));
        	return cache.get(i);
        }
        
        int singleDigit = 0;
        int doubleDigit = 0;
        
      
       
        singleDigit += numDecoding(s,i+1,cache, n );
 
      
       
		if (i + 1 < n && (s.charAt(i) == '1' || (s.charAt(i) == '2' && s.charAt(i + 1) <= '6')))
        	
			doubleDigit += numDecoding(s,i+2,cache, n );
        
        cache.set(i,(singleDigit+ doubleDigit)%1000000007);
 
        return singleDigit+ doubleDigit;
        //int n =s.length()	;
		
	}
	
	public static void main(String[] args) {
        //int n = 7;
        String s = "1111111";
        System.out.println("No of ways to decode " + numDecodings(s));
    }

}
