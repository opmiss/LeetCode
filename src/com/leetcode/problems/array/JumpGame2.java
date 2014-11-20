package com.leetcode.problems.array;

/*Given an array of non-negative integers, you are initially positioned at the first index of the array.

Each element in the array represents your maximum jump length at that position.

Your goal is to reach the last index in the minimum number of jumps.

For example:
Given array A = [2,3,1,1,4]

The minimum number of jumps to reach the last index is 2. 
(Jump 1 step from index 0 to 1, then 3 steps to the last index.)
*/ 

public class JumpGame2 {
	 public int jump(int[] A) {
	        int n = A.length; 
	        int step = 0;
	        int last = 0;
	        int reach = 0;
	        for (int i = 0; i < n; ++i) {
	            if (i > last) {
	                last = reach;
	                //only need to increment step by one as 'reach' is updated from positions before 'last' 
	                ++step;
	            }
	            //the maximum distance reachable when taking a jump at i
	            reach = Math.max(reach, i+A[i]);
	            if (reach >= (n-1)) return (step+1);
	        }
	        return step;
	    }
}
