package com.leetcode.problems.array;

public class Water {
	
	/*Given n non-negative integers representing an elevation map where the width of each bar is 1, 
	 *compute how much water it is able to trap after raining.
	 *For example, 
	 *Given [0,1,0,2,1,0,1,3,2,1,2,1], return 6.
	 */
	public int trap(int[] A) {
		if (A.length < 2)
			return 0;
		int[] lmh = new int[A.length];
		lmh[0] = 0;
		lmh[1] = A[0];
		for (int i = 2; i < A.length; i++) {
			lmh[i] = Math.max(lmh[i - 1], A[i - 1]);
		}
		int rmh = 0;
		int area = 0;
		for (int i = A.length - 1; i >= 0; i--) {
			//Observation: the water trapped at i is the difference between 
			//min of the max heights of wall from both directions
			//and the height of the wall at i
			area += Math.max((Math.min(rmh, lmh[i]) - A[i]), 0);
			rmh = Math.max(rmh, A[i]);
		}
		return area;
	}
	
	/*Given n non-negative integers a1, a2, ..., an, 
	 * where each represents a point at coordinate (i, ai). 
	 * n vertical lines are drawn such that the two endpoints of line i is at (i, ai) and (i, 0). 
	 * Find two lines, which together with x-axis forms a container, 
	 * such that the container contains the most water.
	 */
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
