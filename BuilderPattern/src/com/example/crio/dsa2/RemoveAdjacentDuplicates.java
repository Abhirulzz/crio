package com.example.crio.dsa2;

import java.util.Stack;

public class RemoveAdjacentDuplicates {
	
	public static void main(String args[]) {
		//String str = "5 11 + 9 5 - + 10 *";
		String str = "abbaca";
		System.out.println(str);
		//System.out.println(capitalise(str));
		//System.out.println(postfixExpression(str));
		//System.out.println(ValidParenthesis(str));
		System.out.println(removeAdjacentDuplicates(str));
	}
	
	static String removeAdjacentDuplicates(String s){
		
		StringBuilder sbf = new StringBuilder();
		Stack<Character> stack = new Stack<>();
		for (int i = 0; i < s.length(); i++) {

			char currentChar = s.charAt(i);

		
			
			if(!stack.isEmpty() && stack.peek() == currentChar) 
				stack.pop();
			
			else if ((!stack.isEmpty() && stack.peek() != currentChar) || stack.isEmpty())
			{
				stack.push(currentChar);
			}
			

					
		}
		
		for(char c: stack)
		{
			sbf.append(c);
		}

		
		//sbf.append(stack.peek());
		return sbf.toString();
    }

}
