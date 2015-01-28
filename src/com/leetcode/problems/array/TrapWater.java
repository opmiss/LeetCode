package com.leetcode.problems.array;

public class TrapWater {
	
	/*Given n non-negative integers representing an elevation map where the width of each bar is 1, 
	 *compute how much water it is able to trap after raining.
	 *For example, 
	 *Given [0,1,0,2,1,0,1,3,2,1,2,1], return 6.
	 */
	
	public int trap(int[] A) {
		if (A.length < 3) return 0;
		int i=0, j=A.length-1, plank =0, ret=0;
		while (i<j){
			if (A[i]<A[j]){
				if (plank<A[i]) plank = A[i]; 
				else ret+=plank-A[i++]; 
			}
			else {
				if (plank<A[j]) plank = A[j]; 
				else ret+=plank-A[j--]; 
			}
		}
		return ret; 
	}
	public void test(){
		//int[] A = new int[]{0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1}; 
		int[] A = new int[]{3, 1, 2, 3, 4}; 
		System.out.println(trap(A)); 
	}
	public static void main(String[] args){
		TrapWater tw = new TrapWater(); 
		tw.test(); 
	}
}
