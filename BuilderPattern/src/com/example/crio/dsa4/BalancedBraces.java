package com.example.crio.dsa4;

import java.util.ArrayList;
import java.util.List;

public class BalancedBraces {
	
	static ArrayList<String> balancedBraces(int n) {
		
		ArrayList<String> res = new ArrayList<>();
		 backtrack(res,"",0,0,n);
		 return res;
        
    }
	
	static void backtrack(ArrayList<String> res, String curr_str,int open,int close ,int max) {
		
		if(curr_str.length() == max *2)
		{
			res.add(curr_str);
			return;
		}
		
		if(open<max)
			 backtrack(res, curr_str +"(",open+1,close,max);
		if(close<open)
			 backtrack(res, curr_str +")",open,close+1,max);
		
	}
	
	public static void main(String[] args) {
       int n =4;
        ArrayList<String> result = balancedBraces(n);
        for(int i = 0 ; i < result.size() ; i++) {
            System.out.println(result.get(i));
        }
    }

}
