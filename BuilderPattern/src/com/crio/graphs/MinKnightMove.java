package com.crio.graphs;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class MinKnightMove {

	    static class Position {
	        int x;
	        int y;
	        
	        public Position(int x, int y) {
	            this.x = x;
	            this.y = y;
	        }
	        
	        public boolean equals(Position other) {
	            return this.x == other.x && this.y == other.y;
	        }
	    }
	   
	    public static int minKnightMoves(int starting_pos[], int ending_pos[], int n) {
	        // Possible knight moves
	        int[][] moves = {
	            {-2, -1}, {-1, -2}, {1, -2}, {2, -1},
	            {2, 1}, {1, 2}, {-1, 2}, {-2, 1}
	        };
	        
	        Queue<Position> queue = new LinkedList<>();
	        Set<Position> visited = new HashSet<>();
	        
	        Position start = new Position(starting_pos[0], starting_pos[1]);
	        Position target = new Position(ending_pos[0], ending_pos[1]);
	        
	        queue.offer(start);
	        visited.add(start);
	        
	        int movesCount = 0;
	        
	        while (!queue.isEmpty()) {
	            int size = queue.size();
	            
	            for (int i = 0; i < size; i++) {
	                Position currentPosition = queue.poll();
	                
	                if (currentPosition.equals(target)) {
	                    return movesCount;
	                }
	                
	                // Explore all possible knight moves
	                for (int[] move : moves) {
	                    int newX = currentPosition.x + move[0];
	                    int newY = currentPosition.y + move[1];
	                    
	                    Position newPosition = new Position(newX, newY);
	                    
	                    if (!visited.contains(newPosition) && isValid(newX, newY,n)) {
	                        visited.add(newPosition);
	                        queue.offer(newPosition);
	                    }
	                }
	            }
	            
	            movesCount++;
	        }
	        
	        return -1; // If target is unreachable
	    }
	    
	    private static boolean isValid(int x, int y, int n) {
	        // Check if the position is within a reasonable chessboard range
	        return x >= -1 && y >= -1 ;
	    }

	    public static void main(String[] args) {
	        int[] starting_pos = {892,1167};
	        int[] ending_pos = {1048,1753};
	       // int targetX = 2;
	       // int targetY = 1;
	      
	        int minMoves = minKnightMoves(starting_pos,ending_pos,8);
	        System.out.println("Minimum moves required: " + minMoves);
	    }
	}


