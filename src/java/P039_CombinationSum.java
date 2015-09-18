package java;

import java.util.*; 

public class P039_CombinationSum {
	/*
	 * Given a set of candidate numbers (C) and a target number (T), find all
	 * unique combinations in C where the candidate numbers sums to T. The same
	 * repeated number may be chosen from C unlimited number of times. For
	 * example, given candidate set 2,3,6,7 and target 7, A solution set is: [7]
	 * [2, 2, 3]
	 */
	public ArrayList<ArrayList<Integer>> combinationSum(int[] candidates,
			int target) {
		// candidate can not be zero
		Arrays.sort(candidates);
		Stack<Integer> sol = new Stack<Integer>();
		ArrayList<ArrayList<Integer>> ret = new ArrayList<ArrayList<Integer>>();
		solve(candidates, target, 0, sol, ret);
		return ret;
	}

	public void solve(int[] num, int target, int si, Stack<Integer> sol, ArrayList<ArrayList<Integer>> sols) {
		if (target == 0) {
			ArrayList<Integer> s = new ArrayList<Integer>();
			s.addAll(sol);
			sols.add(s);
		} else if (target <0 || si>=num.length) {
			return; 
		} else {
			for (int i = si; i < num.length; i++) {
				sol.push(num[i]);
				solve(num, target - num[i], i, sol, sols);
				sol.pop();
			}
		}
	}

	/*
	 * Each number in C may only be used once in the combination. For example,
	 * given candidate set 10,1,2,7,6,1,5 and target 8, A solution set is: [1,
	 * 7] [1, 2, 5] [2, 6] [1, 1, 6]
	 */

	public ArrayList<ArrayList<Integer>> combinationSum2(int[] candidates,
			int target) {
		Arrays.sort(candidates);
		Stack<Integer> sol = new Stack<Integer>();
		ArrayList<ArrayList<Integer>> ret = new ArrayList<ArrayList<Integer>>();
		solve2(candidates, target, 0, sol, ret);
		return ret;
	}

	public void solve2(int[] num, int target, int si, Stack<Integer> sol,
			ArrayList<ArrayList<Integer>> sols) {
		if (target == 0) {
			ArrayList<Integer> s = new ArrayList<Integer>();
			s.addAll(sol);
			sols.add(s);
		} else if (target<0 || si>=num.length) {
			return; 
		} else{
			for (int i = si; i < num.length; i++) {
				if (i>si&&num[i]==num[i-1]) continue; 
				sol.push(num[i]);
				solve2(num, target - num[i], i + 1, sol, sols);
				sol.pop();
			}
		}
	}
	/*Find all possible combinations of k numbers that add up to a number n, 
	 * given that only numbers from 1 to 9 can be used and each combination should be a unique set of numbers.*/
	 public List<List<Integer>> combinationSum3(int k, int n) {
	        List<Integer> sol = new ArrayList<Integer>(); 
	        List<List<Integer>> sols = new ArrayList<List<Integer>>(); 
	        find(k, n, 1, sol, sols);
	        return sols; 
	    }
	    public void find(int k, int n, int start, List<Integer> sol, List<List<Integer>> sols){
	        if (k==0) {
	            if (n==0) sols.add(new ArrayList<Integer>(sol)); 
	            return; 
	        }
	        if (n<start) return; 
	        for (int i=start; i<=n&&i<10; i++){
	            sol.add(i);
	            find(k-1, n-i, i+1, sol, sols);
	            sol.remove(sol.size()-1); 
	        }
	    }

}
