package com.example.crio.dsa4;

import java.util.ArrayList;

public class TowerOfHanoi {
	
	
    public static void towerOfHanoi(int n, char source, char target, char auxiliary, ArrayList<String> result) {
        if (n == 0) {
          
            return;
        }
        towerOfHanoi(n - 1, source, auxiliary, target,result);
        result.add(n + " " + source + " " + target);
        System.out.println("Move disk " + n + " from rod " + source + " to rod " + target);
        towerOfHanoi(n - 1, auxiliary, target, source,result);
    }

    static public ArrayList<String> towerOfHanoi(int n) {
        ArrayList<String> result = new ArrayList<>();
        towerOfHanoi(n, 'A', 'C', 'B',result);
        return result;
    }

    public static void main(String[] args) {
        int n = 5;
        //printTowerState(numDisks, 'A', 'B', 'C');
        //towerOfHanoi(numDisks, 'A', 'C', 'B');
        ArrayList<String> result = towerOfHanoi(n);
        for(int i = 0 ; i < result.size() ; i++) {
            System.out.println(result.get(i));
        }
    }

    public static void printTowerState(int n, char source, char auxiliary, char target) {
        StringBuilder[] towers = new StringBuilder[] { new StringBuilder(), new StringBuilder(), new StringBuilder() };
        for (int i = n; i > 0; i--) {
            towers[0].append(i).append(" ");
        }

        System.out.println("Initial State:");
        printTowers(towers);

        performMoves(n, source, auxiliary, target, towers);
    }

    public static void performMoves(int n, char source, char auxiliary, char target, StringBuilder[] towers) {
        if (n > 0) {
            performMoves(n - 1, source, target, auxiliary, towers);
            moveDisk(source, target, towers);
            printTowers(towers);
            performMoves(n - 1, auxiliary, source, target, towers);
        }
    }

    public static void moveDisk(char source, char target, StringBuilder[] towers) {
        int sourceIndex = source - 'A';
        int targetIndex = target - 'A';

        int disk = Integer.parseInt(towers[sourceIndex].substring(towers[sourceIndex].lastIndexOf(" ") + 1).trim());
        towers[sourceIndex].delete(towers[sourceIndex].lastIndexOf(" "), towers[sourceIndex].length());
        towers[targetIndex].append(disk).append(" ");
        System.out.println("Move disk " + disk + " from rod " + source + " to rod " + target);
    }

    public static void printTowers(StringBuilder[] towers) {
        for (int i = 0; i < towers.length; i++) {
            System.out.println("Tower " + (char)('A' + i) + ": " + towers[i]);
        }
        System.out.println();
    }
}
