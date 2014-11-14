package com.leetcode.problems.array;

public class MaximumProductSubarray {
	public int maxProduct(int[] A) {
		if (A.length == 0)
			return 0;
		if (A.length == 1)
			return A[0];
		int maxhere = Math.max(A[0], 0);
		int minhere = Math.min(A[0], 0);
		int maxprod = A[0];
		for (int i = 1; i < A.length; i++) {
			if (A[i] == 0) {
				maxprod = Math.max(maxhere, maxprod);
				if (i < A.length - 1) {
					maxhere = Math.max(A[i + 1], 0);
					minhere = Math.min(A[i + 1], 0);
					i++;
				}
			} else if (A[i] > 0) {
				maxhere = Math.max(maxhere * A[i], A[i]);
				minhere = Math.min(minhere * A[i], 0);
			} else {
				int t = maxhere;
				maxhere = Math.max(minhere * A[i], 0);
				minhere = Math.min(t * A[i], A[i]);
			}
			maxprod = Math.max(maxhere, maxprod);
		}
		return maxprod;
	}
}
