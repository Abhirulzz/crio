package com.example.crio.dsa1;

import java.util.Stack;

public class PostfixExpression {
	
	public static void main(String args[]) {
		//String str = "5 11 + 9 5 - + 10 *";
		String str = "()";
		System.out.println(str);
		//System.out.println(capitalise(str));
		//System.out.println(postfixExpression(str));
		System.out.println(ValidParenthesis(str));
	}
	
	static Boolean isOperator(String exp) {
		
		Boolean isOperator =false;
		
		if(exp.equals("+")|| exp.equals("-")|| exp.equals("*")|| exp.equals("/") )
		{
			isOperator= true;
		}
		
		return isOperator;
		
	}
	
  static Boolean isClosedParenthesis(char exp) {
		
		Boolean isOperator =false;
		
		if(exp == '}'||  exp == ']' ||  exp == ')' )
		{
			isOperator= true;
		}
		
		return isOperator;
		
	}
  
  static Boolean isParenthesis(char exp) {
		
		Boolean isOperator =false;
		
		if(exp == '{'|| exp == '}'|| exp == '['|| exp == ']' || exp == '(' || exp == ')' )
		{
			isOperator= true;
		}
		
		return isOperator;
		
	}
	
	
	static int postfixExpression(String exp) {
		
		String ch[]= exp.split(" ");
		Stack<Integer> st = new Stack<>();
		
		for(int i =0; i < ch.length;i++)
		{
			if(!st.isEmpty() && isOperator(ch[i]))
			{
				int val2 = st.pop();
				int val1 = st.pop();
				int x = 0;
				if (ch[i].equals("+")) {
					x = val1 + val2;
				} else if (ch[i].equals("-")) {
					x = val1 - val2;
				}else if (ch[i].equals("*")) {
					x = val1 * val2;
				}else if (ch[i].equals("/")) {
					x = val1 / val2;
				}
				st.push(x);
			}
			else
			{
			st.push(Integer.parseInt(ch[i]));
			}
		}
		
		return st.peek();
		
	    }
	
	
		static String ValidParenthesis(String exp) {

			char ch[] = exp.toCharArray();
			Stack<Character> st = new Stack<>();

			for (int i = 0; i < ch.length; i++) {
				if (isParenthesis(ch[i])) {
					if (isClosedParenthesis(ch[i])) {
						if (!st.isEmpty())
							if (ch[i] == '}' && st.peek() == '{') {
								st.pop();
							} else if (ch[i] == ']' && st.peek() == '[') {
								st.pop();
							} else if (ch[i] == ')' && st.peek() == '(') {
								st.pop();
							} else {

								return "false";
							}
						else {
							return "false";
						}
					}else {

					st.push(ch[i]);
					}
				}

			}

			if (!st.isEmpty())
				return "false";

			return "true";

		}

}
