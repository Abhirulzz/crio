package com.example.crio.dsa4;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LetterCombinationsOfPhoneNumber {
	
	
	 public  static List<String> letterCombinationsOfPhoneNumber(String digits) {
		 
		 Map<Character,List<Character>> keypad =new HashMap<>();
		 
		 keypad.put('2', List.of('a','b','c'));
		 keypad.put('3', List.of('d','e','f'));
		 keypad.put('4', List.of('g','h','i'));
		 keypad.put('5', List.of('j','k','l'));
		 keypad.put('6', List.of('m','n','o'));
		 keypad.put('7', List.of('p','q','r','s'));
		 keypad.put('8', List.of('t','u','v'));
		 keypad.put('9', List.of('w','x','y','z'));
		 
		 List<String> res = new ArrayList<>();
		 combinations(digits,0,"",res,keypad);
		 return res;

	    }
	 
	  public static void combinations(String input,int idx,String output,List<String> result,Map<Character,List<Character>> keypad )
	  {
		  if(idx==input.length())
		  {
			  result.add(output);
			  return;
		  }
		  char digit = input.charAt(idx);
		  for(char letter : keypad.get(digit))
		  {
			  combinations(input,idx+1,output+letter,result,keypad); 
		  }
	  }
	
	  public static void main(String[] args) {
	        String digits = "345";
	        //printTowerState(numDisks, 'A', 'B', 'C');
	        //towerOfHanoi(numDisks, 'A', 'C', 'B');
	        List<String> result = letterCombinationsOfPhoneNumber(digits);
	        for(int i = 0 ; i < result.size() ; i++) {
	            System.out.println(result.get(i));
	        }
	    }

}
