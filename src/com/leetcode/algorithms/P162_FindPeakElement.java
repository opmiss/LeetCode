package com.leetcode.algorithms;

public class P162_FindPeakElement {
	 public int findPeakElement(int[] nums) {
	        return find(nums, 0, nums.length-1); 
	    }
	    
	    //input ensures nums[left-1]<nums[left] and nums[right]>nums[right+1]
	    public int find(int[] nums, int start, int end){
	        if (start==end) return start; 
	        if (end==start+1) return nums[start]>nums[end]?start:end; 
	        int mid = (start+end)/2; 
	        if (nums[mid]<nums[mid+1]){
	            return find(nums, mid+1, end); 
	        } 
	        else return find(nums, start, mid); 
	    }
}
