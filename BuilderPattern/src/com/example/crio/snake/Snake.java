package com.example.crio.snake;

import java.util.LinkedList;

public class Snake {
  private LinkedList<Point> body; // LinkedList of points representing snake body
  private Direction direction; // Current direction of movement

  public Snake() {
    // Initialize the snake with a default body and direction
    body = new LinkedList<>();
    // Add initial points to the body representing the snake
    // For example, add three points for a small snake
    body.add(new Point(0, 0)); // Head
    body.add(new Point(0, 1)); // Body
    body.add(new Point(0, 2)); // Tail
    direction = Direction.RIGHT; // Start with right movement
  }

  // Method to move the snake
  public void move() {
    // Get the head of the snake
    Point head = body.getFirst();
    // Calculate the new head position based on the current direction
    Point newHead = new Point(head.getX() + direction.getX(), head.getY() + direction.getY() );
    // Add the new head to the beginning of the body LinkedList
    body.addFirst(newHead);
    // Remove the tail of the snake to maintain its length
    body.removeLast();
  }

  // Method to change the direction of the snake
  public void setDirection(Direction newDirection) {
    // Avoid the snake reversing its direction into itself
    if (direction.isOpposite(newDirection)) {
      return;
    }
    direction = newDirection;
  }

  // Method to check if the snake has collided with itself or the walls
  public boolean checkCollision(int maxX, int maxY) {
    Point head = body.getFirst();
    // Check collision with walls
    if (head.getX() < 0 || head.getX() >= maxX || head.getY() < 0 || head.getY() >= maxY) {
      return true;
    }
    // Check collision with itself
    for (int i = 1; i < body.size(); i++) {
      if (head.equals(body.get(i))) {
        return true;
      }
    }
    return false;
  }

  // Method to grow the snake when it eats food
  public void grow() {
    // Add a new point to the end of the body, effectively growing the snake
    body.addLast(new Point(0, 0)); // Adding a default point here; you may modify this logic
  }

  // Getter method to access the snake's body
  public LinkedList<Point> getBody() {
    return body;
  }

  public Direction getDirection() {
    return direction;
  }
}
