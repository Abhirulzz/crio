package com.example.crio.lld1;

import java.util.Random;

public class Food {
	

    private Point position;
    private Random random;

    public Food() {
        random = new Random();
        generateNewPosition();
    }

    public Point getPosition() {
        return position;
    }

    public void generateNewPosition() {
        int x = random.nextInt(Board.WIDTH);
        int y = random.nextInt(Board.HEIGHT);
        position = new Point(x, y);
    }


}
