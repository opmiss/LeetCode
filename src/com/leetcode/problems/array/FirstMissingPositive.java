package com.leetcode.problems.array;

/* 
 * Given an unsorted integer array, find the first missing positive integer.
 * For example,
 * Given [1,2,0] return 3, and [3,4,-1,1] return 2.
 * Your algorithm should run in O(n) time and uses constant space.
 * */ 


public class FirstMissingPositive {
	public int firstMissingPositive(int[] A) {
		int i = 0;
		while (i < A.length) {
			if (A[i] > 0 && A[i] <= A.length && A[i] != i + 1
					&& A[A[i] - 1] != A[i]) {
				int t = A[i];
				int s = A[i] - 1;
				A[i] = A[s];
				A[s] = t;
			} else {
				i++;
			}
		}
		for (i = 0; i < A.length; i++) {
			if (A[i] != i + 1)
				return (i + 1);
		}
		return A.length + 1;
	}
	
	
}
