package com.leetcode.problems.stack;

import java.util.Stack;

/* Given n non-negative integers representing the histogram's bar height where the width of each bar is 1, 
 * find the area of largest rectangle in the histogram.
 */

public class LargestRectangle {
	 public int largestRectangleArea(int[] height) {
	        int max =0; 
	        Stack<Integer> stack = new Stack<Integer>(); 
	        for (int i=0; i<=height.length; i++){
	            int hi= (i==height.length)? 0:height[i];
	            if (stack.isEmpty() || hi > height[stack.peek()]) stack.push(i);
	            else {
	                int id = stack.pop(); 
	                int top = height[id]; 
	                max = Math.max(max, top*(stack.isEmpty()?i: i-1-stack.peek())); 
	                i--; 
	            }
	        }
	        return max; 
	    }
}
