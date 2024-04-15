package com.example.crio.lld1;

import java.util.Scanner;

public class GameEngine {
	
	    private Snake snake;
	    private Board board;
	    private Food food;
	    private int score;

	    public GameEngine(int width, int height) {
	        board = new Board(width, height);
	        snake = new Snake(width / 2, height / 2);
	        food = new Food();
	        score = 0;
	    }

	    public void startGame(Scanner scanner) {
	        while (true) {
	            // Process user input
	            System.out.println("Enter direction (W/A/S/D):");
	            String input = scanner.nextLine().toUpperCase();
	            Direction newDirection = null;
	            switch (input) {
	                case "U":
	                    newDirection = Direction.UP;
	                    break;
	                case "L":
	                    newDirection = Direction.LEFT;
	                    break;
	                case "D":
	                    newDirection = Direction.DOWN;
	                    break;
	                case "R":
	                    newDirection = Direction.RIGHT;
	                    break;
	                default:
	                    System.out.println("Invalid input!");
	            }
	            if (newDirection != null) {
	                snake.setDirection(newDirection);
	            }

	            // Move snake
	            snake.move();

	            // Check for collisions
	            if (snake.checkCollision(board.getWidth(), board.getHeight())) {
	                System.out.println("Game over!");
	                break;
	            }

	            // Check if snake eats food
	            if (snake.getHead().equals(food.getPosition())) {
	                snake.grow();
	                score++;
	                food.generateNewPosition();
	            }

	            // Clear console
	            clearConsole();

	            // Render game board
	            board.draw(snake, food);
	            System.out.println("Score: " + score);

	            // Pause for a short time
	            try {
	                Thread.sleep(200); // Adjust speed here
	            } catch (InterruptedException e) {
	                e.printStackTrace();
	            }
	        }
	    }

	    private void clearConsole() {
	        System.out.print("\033[H\033[2J");
	        System.out.flush();
	    }
	}

	