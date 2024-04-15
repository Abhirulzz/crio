package com.example.crio.lld1;

public class Board {
	

    public static final int WIDTH = 20;
    public static final int HEIGHT = 20;
    private char[][] grid;

    public Board(int width, int height) {
        grid = new char[width][height];
    }

    public void draw(Snake snake, Food food) {
        for (int y = 0; y < HEIGHT; y++) {
            for (int x = 0; x < WIDTH; x++) {
                if (snake.getBody().contains(new Point(x, y))) {
                    System.out.print("*"); // Snake body
                } else if (food.getPosition().getX() == x && food.getPosition().getY() == y) {
                    System.out.print("@"); // Food
                } else {
                    System.out.print("."); // Empty space
                }
            }
            System.out.println();
        }
    }

    public int getWidth() {
        return WIDTH;
    }

    public int getHeight() {
        return HEIGHT;
    }


}
