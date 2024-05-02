package com.example.crio.dsa4;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.Vector;

class Point {
	    int x, y;

	    Point(int x, int y) {
	        this.x = x;
	        this.y = y;
	    }

	    @Override
		public String toString() {
			return this.x + " " +this.y ;
		}
	    
	    @Override
		public int hashCode() {
			return Objects.hash(x, y);
		}

		@Override
	    public boolean equals(Object obj) {
	        if (this == obj) return true;
	        if (obj == null || getClass() != obj.getClass()) return false;
	        Point other = (Point) obj;
	        return x == other.x && y == other.y;
	    }
	}


	
	public class ShortestPath {
	  /*  public static List<Point> findPath(int[][] grid, Point start, Point goal) {
	        List<Point> path = new ArrayList<>();
	        Set<Point> visited = new HashSet<>();
	        if (findPathRecursive(grid, start, goal, path, visited)) {
	            return path;
	        } else {
	            return Collections.emptyList(); // No path found
	        }
	    } */
	    

	    
	    static Vector<String> robotInAGrid(int grid[][] , int n , int m) {
	    	Point start = new Point(0,0);
	    	Point goal = new Point(n,m);
	    	Vector<String> path = new Vector<>();
	        Set<Point> visited = new HashSet<>();
	        if (findPathRecursive(grid, start, goal, path, visited)) {
	        	
	            return path;
	        	      } else {
	      path.add("Not Possible");
	        	return path;
	        }
	        
	    }
	    
	    private static boolean findPathRecursive(int[][] grid, Point current, Point goal,
	                                             List<String> path, Set<Point> visited) {
	        // Base case: If current point is the goal, add to path and return true
	    	System.out.println(current +" " + goal);
	    	Point res = new Point(current.x +1,current.y +1);
	        if (current.equals(goal) && grid[current.x][current.y] != 1) {
	            path.add(res.toString());
	            return true;
	        }
	        System.out.println(isValidPoint(grid, current));
	        System.out.println(visited.contains(current));
	        // Check if the current point is within grid bounds and is not an obstacle
	        if (!isValidPoint(grid, current) || visited.contains(current) || grid[current.x][current.y] == 1) {
	            return false;
	        }

	        // Mark current point as visited
	        visited.add(current);
	        path.add(res.toString());

	        // Try moving in all possible directions recursively
	        Point[] directions = { new Point(0, 1), new Point(1, 0), new Point(0, -1), new Point(-1, 0) };
	        for (Point direction : directions) {
	            Point next = new Point(current.x + direction.x, current.y + direction.y);
	            if (findPathRecursive(grid, next, goal, path, visited)) {
	                return true;
	            }
	        }

	        // If no path found from current point, backtrack
	        path.remove(path.size() - 1);
	        return false;
	    }

	    private static boolean isValidPoint(int[][] grid, Point point) {
	        int rows = grid.length;
	        int cols = grid[0].length;
	        return point.x >= 0 && point.x < rows && point.y >= 0 && point.y < cols;
	    }

	    public static void main(String[] args) {
	        // Example usage
	        int[][] grid = { {0, 0, 0},
	                         {0, 0, 0},
	                         {0, 0, 1} };

	        Point start = new Point(1, 1);
	        Point goal = new Point(grid.length, grid[0].length);

	        List<String> path = robotInAGrid(grid, 3, 3);
	        if (!path.isEmpty()) {
	            System.out.println("Path found:");
	            for (String point : path) {
	                System.out.println(point.toString());
	            }
	        } else {
	            System.out.println("No path found.");
	        }
	    }
	}



