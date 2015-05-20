package com.leetcode.algorithms;
import java.util.*; 

public class P150_EvaluateReversePolishNotation {
	public int evalRPN(String[] tokens) {
        Stack<Integer> numbers = new Stack<Integer>();
        int op1 = 0, op2 = 0; 
		for (int i=0; i<tokens.length; i++) {
	        switch (tokens[i]){
	            case "+":
	                numbers.push(numbers.pop()+numbers.pop());
	                break; 
	            case "-":
	                op1 = numbers.pop(); 
	                op2 = numbers.pop(); 
	                numbers.push(op2-op1); 
	                break; 
	            case "*": 
	                numbers.push(numbers.pop()*numbers.pop());
	                break; 
	            case "/": 
	                op1 = numbers.pop(); 
	                op2 = numbers.pop(); 
	                numbers.push(op2/op1);
	                break; 
	            default: 
	                numbers.push(Integer.parseInt(tokens[i])); 
	                break; 
	        }
		}
		return numbers.pop();
    }

}
