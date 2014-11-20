package com.leetcode.problems.array;

/*
 * Implement next permutation, which rearranges numbers into the lexicographically next greater permutation of numbers.
 * If such arrangement is not possible, it must rearrange it as the lowest possible order 
 * (ie, sorted in ascending order).
 * The replacement must be in-place, do not allocate extra memory.
 * Here are some examples. 
 * Inputs are in the left-hand column and its corresponding outputs are in the right-hand column.
 * 1,2,3 -> 1,3,2
 * 3,2,1 -> 1,2,3
 * 1,1,5 -> 1,5,1
 * 
*/

public class NextPermutation {
	public void nextPermutation(int[] num) {
		int n = num.length;
		if (n <= 1)
			return;
		int i = n - 1;
		//find the first increasing element from right to left
		while (i >= 1) {
			if (num[i - 1] < num[i])
				break;
			i--;
		}
		//if the whole array is decreasing/lexicographically greatest, reverse the array
		if (i == 0) {
			int s = 0;
			int e = n - 1;
			while (s < e) {
				swap(num, s, e);
				s++;
				e--;
			}
			return;
		}
		//find the element in the decreasing chain greater than the first increasing element, and swap them
		int m = i;
		int p = i - 1;
		for (i = n - 1; i >= m; i--) {
			if (num[i] > num[p])
				break;
		}
		int h = i;
		swap(num, p, h);
		//reverse the decreasing chain into increasing
		int s = m;
		int e = n - 1;
		while (s < e) {
			swap(num, s, e);
			s++;
			e--;
		}
	}

	public void swap(int[] num, int i, int j) {
		int t = num[i];
		num[i] = num[j];
		num[j] = t;
	}
}
