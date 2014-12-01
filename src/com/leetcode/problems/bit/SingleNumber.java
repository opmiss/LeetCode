package com.leetcode.problems.bit;

/* Note:
 * Your algorithm should have a linear runtime complexity. Could you implement it without using extra memory?
 */

public class SingleNumber {
	
	/*
	 * Given an array of integers, every element appears twice except for one. Find that single one.
	 */
	public int singleNumber2(int[] A) {
		int s = A[0]; 
		for (int i=1; i<A.length; i++)
			s=s|A[i]; 
        return s; 
    }
	
	/*
	 * Given an array of integers, every element appears three times except for one. Find that single one.
	 */
	
	public int singleNumber3(int[] A) {
		int m1 = A[0]; 
		int m2 = 0; 
		int _m2; 
		for (int i=1; i<A.length; i++){
			_m2 = m2; 
			m2 = (m1&A[i])|(_m2&(~A[i]));
			m1 = (m1&(~A[i]))|((~m1)&(~_m2)&A[i]); 
		}
		return m1; 
    }
	

}
