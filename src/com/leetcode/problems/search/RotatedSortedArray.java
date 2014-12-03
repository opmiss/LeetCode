package com.leetcode.problems.search;


public class RotatedSortedArray {
	
	/*
	 * Suppose a sorted array is rotated at some pivot unknown to you
	 * beforehand. (i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2). Find the
	 * minimum element. The array may contain duplicates.
	 */
	public int findMin(int[] num) {
		return findMin(num, 0, num.length - 1);
	}

	private int findMin(int[] num, int s, int e) {
		if (e - s < 1)
			return num[s];
		if (e - s == 1)
			return (num[s] < num[e]) ? num[s] : num[e];
		else if (num[s] < num[e]) {
			return num[s];
		} else {
			int m = (s + e) / 2;
			int m1 = findMin(num, s, m);
			int m2 = findMin(num, m, e);
			return (m1 < m2) ? m1 : m2;
		}
	}

	/*
	 * Suppose a sorted array is rotated at some pivot unknown to you
	 * beforehand. (i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2). You are
	 * given a target value to search. If found in the array return its index,
	 * otherwise return -1. Assume duplicate exists in the array.
	 */

}
