package com.leetcode.problems.array;
import java.util.Stack;

/* 
 * Given a 2D binary matrix filled with 0's and 1's, 
 * find the largest rectangle containing all ones and return its area.
 */

public class MaximalRectangle {
	 public int maximalRectangle(char[][] matrix) {
	        int h = matrix.length; 
	        if (h==0) return 0; 
	        int w = matrix[0].length; 
	        int maxArea = 0; 
	        int[] height = new int[w]; 
	        for (int i=0; i<h; i++){
	            for (int j=0; j<w; j++){
	                height[j] = 0; 
	                for (int k=i; k<h; k++){
	                    if (matrix[k][j]=='1') height[j]++; 
	                    else break; 
	                }
	            }
	            maxArea = Math.max(maxArea, largestArea(height)); 
	        }
	        return maxArea; 
	    }
	    
	    public int largestArea(int[] height) {
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
