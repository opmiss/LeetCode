package com.leetcode.algorithms;
import java.util.*;

public class P078_Subsets {
	
	  public List<List<Integer>> subsets(int[] nums) {
	      List<List<Integer>> res = new ArrayList<List<Integer>>(); 
	      Stack<Integer> sol = new Stack<Integer>(); 
		  genSubsets(nums, 0, sol, res); 
		  return res; 
	  }
	
	  public List<List<Integer>> subsetsWithDup(int[] nums) {
		  Arrays.sort(nums);
		  List<List<Integer>> res = new ArrayList<List<Integer>>(); 
	      Stack<Integer> sol = new Stack<Integer>(); 
		  genSubsets(nums, 0, sol, res); 
		  return res;  
	  }
	  
	  public void genSubsets(int[] nums, int start, Stack<Integer> subset, List<List<Integer>> res){
		  res.add(new ArrayList(subset));
		  int i=start; 
		  while (i<nums.length) {
			  subset.push(nums[i]);
			  genSubsets(nums, i+1, subset, res); 
			  subset.pop();
			  i++; 
			  while (i<nums.length && nums[i]==nums[i-1]) i++; 
		  }; 
	  }
	  
	  public static void main(String[] args){
		  int[] nums = new int[]{2, 4, 2, 5}; 
		  P078_Subsets p = new P078_Subsets(); 
		  System.out.println(p.subsetsWithDup(nums));  
	  }
}
