package com.leetcode.algorithms;
import java.util.*;

public class P077_Combinations {
	/*
	 * Given two integers n and k, return all possible combinations of k numbers out of 1 ... n.
	 * For example,
	 * If n = 4 and k = 2, a solution is:
	 * [
	 * [2,4],
	 * [3,4],
	 * [2,3],
	 * [1,2],
	 * [1,3],
	 * [1,4],
	 * ]
	 */
	public List<List<Integer>> combine(int n, int k){
		List<List<Integer>> res = new ArrayList<List<Integer>>(); 
		if (n==k){
			ArrayList<Integer> all = new ArrayList<Integer>(); 
			for (int i=1; i<=n; i++) all.add(i);
			res.add(all); 
			return res; 
		}
		if (k==1){
			for (int i=1; i<=n; i++){
				ArrayList<Integer> one = new ArrayList<Integer>();
				one.add(i); 
				res.add(one); 
			}
			return res; 
		}
		List<List<Integer>> include_n = combine(n-1, k-1); 
		for (List<Integer> list:include_n) list.add(n);
		res.addAll(include_n);
		res.addAll(combine(n-1, k)); 
		return res; 
	}
}
