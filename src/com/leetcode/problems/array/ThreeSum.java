package com.leetcode.problems.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ThreeSum {
	/* Given an array S of n integer, 
	 * are there elements a, b, c in S such that a+b+c=0?
	 * Find all unique triplets in the array which gives the sum of zero. 
	 * Note: 
	 * Elements in a triplet (a, b, c) must be in non-descending order. (i.e. a<=b<=c)
	 * The solution set must not contain duplicate triplets. 
	 * For example, given array S = {-1 0 1 2 -1 -4}, 
	 * A solution set is: 
	 * (-1, 0, 1)
	 * (-1, -1, 2)
	 */
	 public List<List<Integer>> threeSum(int[] num) {
	        //similar solution as 3sum closest
		 	//create three indices i, j, k, i<j<k
		 	// increment i or decrement k depends on ai+ak
	        List<List<Integer>> ret = new ArrayList<List<Integer>>(); 
	        if (num.length<3) return ret; 
	        Set<List<Integer>> sols = new HashSet<List<Integer>>(); 
	        Arrays.sort(num);
	        for (int i=0; i<num.length-2; i++){
	            int n1 = num[i]; 
	            int tar = 0-num[i]; 
	            int j=i+1; 
	            int k=num.length-1; 
	            while (k>j){
	                int sum = num[k]+num[j]; 
	                if (sum == tar) {
	                    List<Integer> sol = new ArrayList<Integer>(); 
	                    sol.add(n1); sol.add(num[j]); sol.add(num[k]);  
	                    sols.add(sol); k--;
	                }
	                else if (sum>tar) k--; 
	                else j++; 
	            }
	        }
	        ret.addAll(sols);
	        return ret; 
	    }
	 
	 /*
	  * Given an array S of n integers, 
	  * find three integers in S such that the sum is closest to a given number, target. 
	  * Return the sum of the three integers. You may assume that each input would have exactly one solution.
	  * For example, given array S = {-1 2 1 -4}, and target = 1.
	  * The sum that is closest to the target is 2. (-1 + 2 + 1 = 2).
	  * */
	public int threeSumClosest(int[] num, int target) {
		// first sort the input array into ascending order
		Arrays.sort(num);
		int tar, n2, n3, sum, d, ret = target, diff = Integer.MAX_VALUE;
		for (int n1 = 0; n1 < num.length - 2; n1++) {
			tar = target - num[n1];
			n2 = n1 + 1;
			n3 = num.length - 1;
			while (n2 < n3) {
				sum = num[n2] + num[n3];
				d = Math.abs(sum - tar);
				if (d < diff) {
					diff = d;
					ret = num[n1] + sum;
				}
				if (sum < tar)
					n2++;
				else if (sum > tar)
					n3--;
				else
					return target;
			}
		}
		return ret;
	}

}
