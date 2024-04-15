package com.example.crio.lld1;

import java.util.Scanner;

public class SnakeGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        GameEngine engine = new GameEngine(20, 20);
        engine.startGame(scanner);
        scanner.close();
    }
}
