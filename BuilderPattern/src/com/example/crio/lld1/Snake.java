package com.example.crio.lld1;

import java.util.LinkedList;

public class Snake {
	
	private LinkedList<Point> body;
    private Direction direction;

    public Snake(int startX, int startY) {
        body = new LinkedList<>();
        body.add(new Point(startX, startY));
        direction = Direction.RIGHT;
    }

    public void move() {
        Point head = body.getFirst();
        Point newHead = new Point(head.getX() + direction.getX(), head.getY() + direction.getY());
        body.addFirst(newHead);
        body.removeLast();
    }

    public boolean checkCollision(int maxX, int maxY) {
        Point head = body.getFirst();
        if (head.getX() < 0 || head.getX() >= maxX || head.getY() < 0 || head.getY() >= maxY) {
            return true; // Collision with walls
        }
        for (int i = 1; i < body.size(); i++) {
            if (head.equals(body.get(i))) {
                return true; // Collision with itself
            }
        }
        return false;
    }

    public void grow() {
        Point tail = body.getLast();
        Point newTail = new Point(tail.getX(), tail.getY());
        body.addLast(newTail);
    }

    public Point getHead() {
        return body.getFirst();
    }

    public void setDirection(Direction newDirection) {
        if (!direction.isOpposite(newDirection)) {
            direction = newDirection;
        }
    }
    
    public LinkedList<Point> getBody() {
        return body;
      }
    
    
    public Direction getDirection() {
        return direction;
      }

}
