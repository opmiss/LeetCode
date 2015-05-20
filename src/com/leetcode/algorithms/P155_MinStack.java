package com.leetcode.algorithms;
import java.util.*; 

public class P155_MinStack {
	Stack<Integer> stack = new Stack<Integer>(); 
    Stack<Integer> min_pos = new Stack<Integer>(); 
    
    public void push(int x) {
        stack.push(x); 
        if (min_pos.isEmpty()) {
            min_pos.push(0); 
            return; 
        }
        if (x < stack.get(min_pos.peek())){
            min_pos.push(stack.size()-1);
            return; 
        }
    }
    public void pop() {
        stack.pop();
        if (min_pos.peek()==stack.size())
            min_pos.pop(); 
    }

    public int top() {
        return stack.peek(); 
        
    }

    public int getMin() {
        return stack.get(min_pos.peek()); 
    }

}
