package com.leetcode.problems.greedy;

/*
 * Given an array of non-negative integers, you are initially positioned at the first index of the array.
 * Each element in the array represents your maximum jump length at that position.
 * Your goal is to reach the last index in the minimum number of jumps.
 * For example:
 * Given array A = [2,3,1,1,4]
 * The minimum number of jumps to reach the last index is 2. 
 * (Jump 1 step from index 0 to 1, then 3 steps to the last index.)
*/ 

public class JumpGame {
	 public int jump(int[] A) {
		 int step = 0; 
		 int last=0, cur=0, reach = 0; 
		 for (int i = 0; i<A.length&&last<A.length; i++){
			 if (last<i){
				 last = reach; 
				 step++; 
			 }
			 cur = i+A[i]; 
			 reach = (reach<cur)?cur:reach; 
		 }
		 return step; 
	 }
	 
	 public void test(){
		 int[] A = new int[]{2, 3, 1, 1, 4};
		 System.out.println(jump(A)); 
	 }
	 
	 public static void main(String[] args){
		 JumpGame jg = new JumpGame(); 
		 jg.test(); 
	 }
}
