package com.examples.designPattern;

import java.util.HashSet;
import java.util.Set;

public class uniqueCharacter {
	
	public static String findUniqueCharactersString(String str) {
	    if(str == null || str.length() == 0) {
	      return "0";
	    }
	    
	    Set<Character> set = new HashSet<>();
	        
	    for(int i = 0; i < str.length(); i++) {
	      set.add(str.charAt(i));
	    }
	    
	    return set.toString();
	  }
	  
	  public static void main(String[] args) {
	    
	    String str = "zbccbababd";
	    System.out.println(uniqueCharacter.findUniqueCharactersString(str));
	  }

}
