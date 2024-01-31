package com.example.crio.dsa1;
import java.util.Stack;

class FindMinStack {
    private Stack<Integer> stack;
    private Stack<Integer> minStack;

    public FindMinStack() {
        stack = new Stack<>();
        minStack = new Stack<>();
    }

    public void push(int value) {
        stack.push(value);
        if (minStack.isEmpty() || value <= minStack.peek()) {
            minStack.push(value);
        }
    }

    public int pop() {
        if (stack.isEmpty()) {
            return -1; // or throw an exception to indicate stack underflow
        }
        int poppedValue = stack.pop();
        if (poppedValue == minStack.peek()) {
            minStack.pop();
        }
        return poppedValue;
    }

    public int getMin() {
        if (minStack.isEmpty()) {
            return -1; // or throw an exception to indicate an empty stack
        }
        return minStack.peek();
    }

    public static void main(String[] args) {
        FindMinStack minStack = new FindMinStack();
        minStack.push(3);
        minStack.push(5);
        minStack.push(2);
        minStack.push(1);

        System.out.println("Minimum element: " + minStack.getMin());  // Output: 1

        minStack.pop();
        System.out.println("Minimum element after pop: " + minStack.getMin());  // Output: 2
    }
}
