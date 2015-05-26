package com.leetcode.algorithms;

public class P136_SingleNumber {
	public int singleNumber(int[] A) {
        int s = A[0]; 
		for (int i=1; i<A.length; i++)
			s=s^A[i]; 
        return s; 
    }
}
