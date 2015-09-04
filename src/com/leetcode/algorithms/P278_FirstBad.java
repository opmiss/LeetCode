package com.leetcode.algorithms;

public class P278_FirstBad {
	int badversion = 2; 
	boolean isBadVersion(int version){
		return version>=badversion; 
	}
	public int firstBadVersion(int n) {
        int lo = 1, high = n, mid; 
        while (lo<high-1){
        	mid = lo+(high-lo)/2; 
            if (isBadVersion(mid))
                high = mid; 
            else 
                lo = mid; 
        }
        return high; 
    }
	public static void main(String[] args){
		P278_FirstBad p = new P278_FirstBad(); 
		System.out.println(p.firstBadVersion(3)); 
	}
}
