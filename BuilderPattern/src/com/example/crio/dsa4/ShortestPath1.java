package com.example.crio.dsa4;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;

class Point1 {
    int x, y;

    Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
	public int hashCode() {
		return Objects.hash(x, y);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Point other = (Point) obj;
		return x == other.x && y == other.y;
	}

	@Override
	public String toString() {
		return "Point [x=" + x + ", y=" + y + "]";
	}
    
    
}

public class ShortestPath1 {
    public static List<Point> findPath(int[][] grid, Point start, Point goal) {
        List<Point> path = new ArrayList<>();
        Set<Point> visited = new HashSet<>();
        if (findPathRecursive(grid, start, goal, path, visited)) {
            return path;
        } else {
            return Collections.emptyList(); // No path found
        }
    }

    private static boolean findPathRecursive(int[][] grid, Point current, Point goal,
                                             List<Point> path, Set<Point> visited) {
        // Base case: If current point is the goal, add to path and return true
    	System.out.println(current +" " + goal);
        if (current.equals(goal)) {
            path.add(current);
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
        path.add(current);

        // Try moving in all possible directions recursively
        Point[] directions = { new Point(0, 1), new Point(1, 0), new Point(0, -1), new Point(-1, 0) };
        for (Point direction : directions) {
            Point next = new Point(current.x + direction.x, current.y + direction.y);
            if (!visited.contains(next) && isValidPoint(grid, next)) {
                if (findPathRecursive(grid, next, goal, path, visited)) {
                    return true;
                }
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
                         {0, 1, 1},
                         {0, 0, 0} };

        Point start = new Point(0, 0);
        Point goal = new Point(2, 2);

        List<Point> path = findPath(grid, start, goal);
        if (!path.isEmpty()) {
            System.out.println("Path found:");
            for (Point point : path) {
                System.out.println("(" + point.x + ", " + point.y + ")");
            }
        } else {
            System.out.println("No path found.");
        }
    }
}
