package com.crio.graphs;
import java.util.*;

public class KnightMoves {

    private static final int[] DX = { -2, -1, 1, 2, 2, 1, -1, -2 };
    private static final int[] DY = { 1, 2, 2, 1, -1, -2, -2, -1 };

    public static int minMoves(int n, int startX, int startY, int endX, int endY) {
        if (!isValid(n, startX, startY) || !isValid(n, endX, endY)) {
            return -1; // Invalid start or end position
        }

        if (startX == endX && startY == endY) {
            return 0; // Already at the target position
        }

        // Use BFS to find the minimum moves
        Queue<int[]> queue = new LinkedList<>();
        boolean[][] visited = new boolean[n+1][n+1];

        queue.offer(new int[] { startX, startY, 0 });
        visited[startX][startY] = true;

        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int x = current[0];
            int y = current[1];
            int moves = current[2];

            // Explore all possible knight moves
            for (int i = 0; i < 8; i++) {
                int nx = x + DX[i];
                int ny = y + DY[i];

                if (isValid(n, nx, ny) && !visited[nx][ny]) {
                    if (nx == endX && ny == endY) {
                        return moves + 1; // Found the target position
                    }
                    visited[nx][ny] = true;
                    queue.offer(new int[] { nx, ny, moves + 1 });
                }
            }
        }

        return -1; // No valid path found
    }

    private static boolean isValid(int n, int x, int y) {
        return x >= 0 && x <= n && y >= 0 && y <= n;
    }

    public static void main(String[] args) {
        int n = 8; // Board size
        int startX = 2;
        int startY = 1;
        int endX = 8;
        int endY = 5;

        int minMoves = minMoves(n, startX, startY, endX, endY);
        System.out.println("Minimum moves required: " + minMoves);
    }
}
