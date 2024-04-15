package com.example.crio.snake;

import java.util.Arrays;

import com.example.crio.snake.Direction;
import com.example.crio.snake.Snake;

public class Main {
	public static void main(String[] args) {
	    // Create a new Snake object
	    Snake snake = new Snake();
	    // Test the accessor methods
	    // Intialize the body and direction variables here
	    // Invoke the methods of snake object here

        for(Point point : snake.getBody())
            System.out.println( point );
	    
	    System.out.println("Initial Direction: " + snake.getDirection());

	    // Test modifying the direction
	    // Invoke the methods of snake object here
	    snake.setDirection(Direction.LEFT);

	    System.out.println("New Direction: " + snake.getDirection());

	    // Test moving the snake
	    // Invoke the methods of snake object here
	    snake.move();

	    System.out.println("Body after moving: " + snake.getBody());

	    // Test growing the snake
	    // Invoke the methods of snake object here
	    snake.grow();

	    System.out.println("Body after growing: " + snake.getBody());

	    // Try accessing and modifying the body directly (should not be allowed)

	    // Try modifying the direction directly (should not be allowed)

	  }

}
