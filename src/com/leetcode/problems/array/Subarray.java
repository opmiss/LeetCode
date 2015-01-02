package com.leetcode.problems.array;

public class Subarray {
	/* 
	 * Find the contiguous subarray within an array (containing at least one number) 
	 * which has the largest product.
	 * For example, given the array [2,3,-2,4],
	 * the contiguous subarray [2,3] has the largest product = 6.
	 */
	public int maxProduct(int[] A) {
		if (A.length == 1)
			return A[0];
		int maxhere = 0;
		int minhere = 0;
		int maxprod = A[0];
		for (int i = 0; i < A.length; i++) {
			if (A[i] > 0) {
				maxhere = (maxhere > 0) ? maxhere * A[i] : A[i];
				minhere = (minhere < 0) ? minhere * A[i] : 0;
			} else if (A[i] < 0) {
				int t = maxhere;
				maxhere = (minhere < 0) ? minhere * A[i] : 0;
				minhere = (t > 0) ? t * A[i] : A[i];
			} else {
				maxhere = minhere = 0;
			}
			maxprod = (maxprod < maxhere) ? maxhere : maxprod;
		}
		return maxprod;
	}
	/*
	 * Find the contiguous subarray within an array (containing at least one number) which has the largest sum.
	 * For example, given the array [-2,1,-3,4,-1,2,1,-5,4],
	 * the contiguous subarray [4,-1,2,1] has the largest sum = 6
	 */
	public int maxSum(int[] A) {
		if (A.length == 1)
			return A[0]; 
		int sumhere=A[0]; 
		int maxsum=A[0]; 
		for (int i=1; i<A.length; i++) {
			sumhere = (sumhere<0)?A[i]:(sumhere+A[i]); 
			maxsum = (maxsum<sumhere)?sumhere:maxsum; 
		}
		return maxsum; 
	}
	
}
