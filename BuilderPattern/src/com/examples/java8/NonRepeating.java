package com.examples.java8;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Scanner;
import java.util.function.Function;
import java.util.stream.Collectors;

public class NonRepeating {
	
	
	 
	  public static void main(String[] args) {
	 
	    System.out.println("  Please  enter  the  input  string  :");
	    Scanner in = new Scanner(System.in);    // read from System input
	    String input = in.nextLine();
	    Character firstNonRepeatedChar = logic(input);
	    System.out.println("The  first  non  repeated  character  is  :    " + firstNonRepeatedChar);
	    in.close();
	    
	    List < Integer > nums = Arrays.asList(1, 3, 6, 8, 10, 18, 36,1,6,8);
	    System.out.println("List of numbers: " + nums);

	    // Calculate the average using streams
	    double average = nums.stream()
	      .mapToDouble(Integer::doubleValue)
	      .average()
	      .orElse(0.0);
	    
	    System.out.println("Average value of the said numbers: " + average);
	    List < Integer > distinctNumbers = nums.stream()
	    	      .distinct()
	    	      .collect(Collectors.toList());
	    	    System.out.println("After removing duplicates from the said list: " + distinctNumbers);
	  }
	 
	  
	  private static Character logic(String input) {  
	        Character result =  input.chars()           // IntStream
	             .mapToObj(i -> Character.toLowerCase(Character.valueOf((char) i)))  // convert to lowercase & then to Character object Stream
	             .collect(Collectors.groupingBy(Function.identity(), LinkedHashMap::new, Collectors.counting())) // store in a LinkedHashMap with the count
	             .entrySet().stream()                       // EntrySet stream
	             .filter(entry -> entry.getValue() == 1L)   // extracts characters with a count of 1
	             .map(entry -> entry.getKey())              // get the keys of EntrySet
	             .findFirst().get();                        // get the first entry from the keys
	        
	         return result;    
	  }
	}
	 


