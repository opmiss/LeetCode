package com.leetcode.problems.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;

public class CombinationSum {
	
	/* 
	 * Given a set of candidate numbers (C) and a target number (T), 
	 * find all unique combinations in C where the candidate numbers sums to T.
	 * The same repeated number may be chosen from C unlimited number of times.
	 * Note:
	 * All numbers (including target) will be positive integers.
	 * Elements in a combination (a1, a2, ... , ak) must be in non-descending order. (ie, a1 <= a2 <= ... <= ak).
	 * The solution set must not contain duplicate combinations.
	 * For example, given candidate set 2,3,6,7 and target 7, 
	 * A solution set is: 
	 * [7] 
	 * [2, 2, 3] 
	 */
	public ArrayList<ArrayList<Integer>> combinationSum(int[] candidates, int target) {
        //candidate can not be zero 
        Arrays.sort(candidates); 
        ArrayList<Integer> empty = new ArrayList<Integer>(); 
        ArrayList<ArrayList<Integer>> ret = new ArrayList<ArrayList<Integer>>(); 
        solve(candidates, target, 0, empty, ret);
        return ret; 
    }
    public void solve(int[] num, int target, int si, ArrayList<Integer>sol, ArrayList<ArrayList<Integer>> sols){
        if (si>=num.length||target <0) return; 
        if (target==0){
            ArrayList<Integer> s = new ArrayList<Integer>(sol); 
            sols.add(s); 
        }
        else if (target>=num[si]) {
            for (int i=si; i<num.length; i++ ){
                sol.add(num[i]); 
                solve(num, target - num[i], i, sol, sols); 
                sol.remove(sol.size()-1); 
            }
        }
    }
    
	/*
	 * Given a collection of candidate numbers (C) and a target number (T), 
	 * find all unique combinations in C where the candidate numbers sums to T.
	 * Each number in C may only be used once in the combination.
	 * Note:
	 * All numbers (including target) will be positive integers.
	 * Elements in a combination (a1, a2,..., ak) must be in non-descending order. (ie, a1 <= a2 <= ... <= ak).
	 * The solution set must not contain duplicate combinations.
	 * For example, given candidate set 10,1,2,7,6,1,5 and target 8, 
	 * A solution set is: 
	 * [1, 7] 
	 * [1, 2, 5] 
	 * [2, 6] 
	 * [1, 1, 6]
	 */
	public ArrayList<ArrayList<Integer>> combinationSum2(int[] num, int target) {
        Arrays.sort(num);
        ArrayList<Integer> empty = new ArrayList<Integer>(); 
        ArrayList<ArrayList<Integer>> ret = new ArrayList<ArrayList<Integer>>(); 
        solve2(num, target, 0, empty, ret);
        HashSet<ArrayList<Integer>> set = new HashSet<ArrayList<Integer>>(); 
        for (ArrayList<Integer> r:ret) set.add(r); 
        ret = new ArrayList<ArrayList<Integer>>(); 
        for ( ArrayList<Integer> s:set ) ret.add(s); 
        return ret; 
    }
    //Using Depth first search
    public void solve2(int[] num, int target, int si, ArrayList<Integer>sol, ArrayList<ArrayList<Integer>> sols){
        if (target==0){
            ArrayList<Integer> s = new ArrayList<Integer>(sol); 
            sols.add(s); 
        }
        else {
            if (si>=num.length||target <0) return; 
            for (int i=si; i<num.length; i++){
                if (target<num[si]) break; 
                sol.add(num[i]); 
                solve2(num, target - num[i], i+1, sol, sols); 
                sol.remove(sol.size()-1); 
            }
        }
    }

}
