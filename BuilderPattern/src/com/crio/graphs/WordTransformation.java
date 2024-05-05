package com.crio.graphs;

import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

public class WordTransformation {
	
	 public static int ladderLength(String beginWord, String endWord, List<String> wordList) {
		 Set<String> wordSet = new HashSet<>(wordList);
	        if (!wordSet.contains(endWord)) {
	            return 0; // If endWord is not in wordList, transformation is not possible
	        }

	        Queue<String> queue = new LinkedList<>();
	        queue.offer(beginWord);
	        int level = 1; // Start at level 1
	        int wordLength = beginWord.length();

	        while (!queue.isEmpty()) {
	            int size = queue.size();

	            for (int i = 0; i < size; i++) {
	                char[] currentWord = queue.poll().toCharArray();

	                for (int j = 0; j < wordLength; j++) {
	                    char originalChar = currentWord[j];

	                    for (char c = 'a'; c <= 'z'; c++) {
	                        if (c == originalChar) {
	                            continue;
	                        }
	                        currentWord[j] = c;
	                        String newWord = new String(currentWord);

	                        if (newWord.equals(endWord)) {
	                            return level + 1; // Found the endWord
	                        }

	                        if (wordSet.contains(newWord)) {
	                            queue.offer(newWord);
	                            wordSet.remove(newWord); // Mark as visited
	                        }
	                    }

	                    currentWord[j] = originalChar; // Restore the original character
	                }
	            }

	            level++; // Move to the next level
	        }

	        return 0; // No transformation sequence found	
	    }
	 
	 public static void main(String[] args) {
	        
	        String beginWord = "hit";
	        String endWord = "cog";
	        List<String> wordList = Arrays.asList("hot", "dot", "dog", "lot", "log", "cog");

	        int ladderLength = ladderLength(beginWord, endWord, wordList);
	        System.out.println("The length of the shortest word ladder is: " + ladderLength);
	    }

}
