package com.leetcode.problems.math;

import java.util.List;

public class Permutations {
	/*
	 * Given a collection of numbers that might contain duplicates, return all possible unique permutations.
	 * For example,
	 * [1,1,2] have the following unique permutations:
	 * [1,1,2], [1,2,1], and [2,1,1].
	 * 
	 */
	
    public List<List<Integer>> permuteUnique(int[] num) {
        return null; 
    }
    
    /*
     * Given a collection of numbers, return all possible permutations.
     * For example,
     * [1,2,3] have the following permutations:
     * [1,2,3], [1,3,2], [2,1,3], [2,3,1], [3,1,2], and [3,2,1].
     */
    
    public List<List<Integer>> permute(int[] num) {
    	return null; 
    }
    
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

	private void swap(int[] num, int i, int j) {
		int t = num[i];
		num[i] = num[j];
		num[j] = t;
	}
}
