package com.example.crio.dsa1;

import java.util.HashMap;
import java.util.Map;

public class FindMostFrequentCharWithLowestAscii {
	
	public static void main(String[] args) {
        char[] characters = {'A', 'b', 'c', 'a', 'b', 'c', 'a', 'b','a','a','A','A','A'};

        Object[] mostFrequentChar = findMostFrequentCharWithLowestAscii(characters);

        System.out.println("Most frequent character with the lowest ASCII value: " + mostFrequentChar);
    }

    public static Object[] findMostFrequentCharWithLowestAscii(char[] chars1) {
    	String s = "AAAAaaaa";
    	char[] chars = s.toCharArray();
        Map<Character, Integer> frequencyMap = new HashMap<>();
        Object[] mostFrequentChar = new Object[2]; // Default value if the array is empty
        int maxFrequency = 0;
        int minAscii = Integer.MAX_VALUE;

        // Count occurrences of each character in the array
        for (char ch : chars) {
            frequencyMap.put(ch, frequencyMap.getOrDefault(ch, 0) + 1);

            // Update mostFrequentChar if a new character has higher frequency or
            // if it has the same frequency but a lower ASCII value
            if (frequencyMap.get(ch) > maxFrequency || (frequencyMap.get(ch) == maxFrequency && ch < minAscii)) {
                mostFrequentChar[0] = ch;
                maxFrequency = frequencyMap.get(ch);
                mostFrequentChar[1] = maxFrequency;
                minAscii = ch;
            }
        }

        return mostFrequentChar;
    }

}
