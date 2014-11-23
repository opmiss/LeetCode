package com.leetcode.problems.array;

/*Given n non-negative integers a1, a2, ..., an, 
 * where each represents a point at coordinate (i, ai). 
 * n vertical lines are drawn such that the two endpoints of line i is at (i, ai) and (i, 0). 
 * Find two lines, which together with x-axis forms a container, 
 * such that the container contains the most water.
 */


public class ContainerMostWater {
	public int maxArea(int[] height) {
        if (height.length<2) return 0; 
        int start = 0; 
        int end = height.length-1; 
        int maxarea = Math.min(height[start], height[end])*(end-start); 
        while (start<end){
            if (height[start] < height[end]) start++; 
            else end--; 
            maxarea = Math.max(maxarea, Math.min(height[start], height[end])*(end-start)); 
        }
        return maxarea; 
    }

}
