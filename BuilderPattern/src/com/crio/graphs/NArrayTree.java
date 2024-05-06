package com.crio.graphs;

import java.util.*;

class Nod {
    int val;
    List<Nod> children;

    public Nod(int val) {
        this.val = val;
        this.children = new ArrayList<>();
    }
}

public class NArrayTree {
    public static int diameter(Nod root) {
        if (root == null)
            return 0;
        
        // Use DFS to find the farthest Nod and its distance from root
        NodInfo farthestNodInfo = findFarthest(root);
        
        // Use DFS again starting from the farthest Nod to find the diameter
        return findFarthest(farthestNodInfo.Nod).distance;
    }
    
    private static NodInfo findFarthest(Nod Nod) {
        if (Nod == null)
            return new NodInfo(null, 0);
        
        NodInfo farthest = new NodInfo(Nod, 0);
        
        for (Nod child : Nod.children) {
            NodInfo childInfo = findFarthest(child);
            int childDistance = childInfo.distance + 1;
            if (childDistance > farthest.distance) {
                farthest.Nod = childInfo.Nod;
                farthest.distance = childDistance;
            }
        }
        
        return farthest;
    }
    
    private static class NodInfo {
        Nod Nod;
        int distance;
        
        public NodInfo(Nod Nod, int distance) {
            this.Nod = Nod;
            this.distance = distance;
        }
    }
    
    public static void main(String[] args) {
        // Example usage
        Nod root = new Nod(1);
        root.children.add(new Nod(2));
        root.children.add(new Nod(3));
        root.children.add(new Nod(4));
        //root.children.get(0).children.add(new Nod(4));
        //root.children.get(0).children.add(new Nod(5));
        //root.children.get(1).children.add(new Nod(6));
        
        //NAryTreeDiameter treeDiameter = new NAryTreeDiameter();
        int result = diameter(root);
        System.out.println("Diameter of the tree: " + result);
    }
}

