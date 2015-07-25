package com.leetcode.algorithms;
import java.util.*;

public class P239_SlidingWindowMaximum {
	public class Pair implements Comparable<Pair>{
        int id; 
        int val; 
        Pair(int i, int v){
            id = i; 
            val = v; 
        }
        public int compareTo(Pair p){
            return p.val-this.val; 
        }
    }
    
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length; 
        if (n==0) return new int[]{}; 
        if (k>=n){
            return quickSolve(nums); 
        }
        int[] res = new int[n-k+1]; 
        PriorityQueue<Pair> queue = new PriorityQueue<Pair>(); 
        for (int i=0; i<n; i++){
            Pair p = new Pair(i, nums[i]);
            queue.add(p); 
            if (i-k+1>=0){
                Pair h = queue.peek(); 
                while (h.id<=i-k){
                    queue.poll();
                    h = queue.peek(); 
                }
                res[i-k+1] = h.val; 
            }
        }
        return res; 
    }
    
    int[] quickSolve(int[] nums){
        int[] res = new int[1];
        res[0] = nums[0]; 
        for (int num:nums){
            if (res[0]<num) res[0]=num; 
        }
        return res; 
    }; 
}
