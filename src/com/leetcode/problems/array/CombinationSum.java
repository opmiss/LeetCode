package com.leetcode.problems.array;

import java.util.ArrayList;
import java.util.Arrays;

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

public class CombinationSum {
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

}
