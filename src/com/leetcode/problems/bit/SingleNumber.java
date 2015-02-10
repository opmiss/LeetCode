package com.leetcode.problems.bit;

import java.util.UUID;

/* Note:
 * Your algorithm should have a linear runtime complexity. Could you implement it without using extra memory?
 */

public class SingleNumber {
	
	/*
	 * Given an array of integers, every element appears twice except for one. Find that single one.
	 */
	public int singleNumber2(int[] A) {
		int m1 = A[0]; 
		for (int i=1; i<A.length; i++){
			m1 = m1|A[i]; 
		}
        return m1; 
    }
	
	/*
	 * Given an array of integers, every element appears three times except for one. Find that single one.
	 */
	
	public int singleNumber3(int[] A) {
		int m1 = A[0], m2 = 0; 
		int _m2; 
		for (int i=1; i<A.length; i++){
			_m2 = m2; 
			m2 = (m1&A[i])|(_m2&(~A[i]));
			m1 = (m1&(~A[i]))|((~m1)&(~_m2)&A[i]); 
		}
		return m1; 
    }
	
	/*
	 * Given an array of integers, every element appears N times except for one. Find that single one.
	 */
	
	public int singleNumberN(int[] A, int N){
		int[] m = new int[N]; int _m; 
		m[0] = ~A[0]; m[1] = A[0]; 
		for (int i=1; i<A.length; i++){
			_m = m[N-1]; 
			for (int k=N-1; k>0; k--){
				m[k] = (m[k-1]&A[i])|(m[k]&(~A[i]));
			}
			m[0] = (_m&A[i])|(m[0]&(~A[i])); 
		}
		return m[1]; 
	}
	
	public void test(){
		int[] A = new int[]{3, 3, 8, 2, 2, 6, 6, 2, 6, 8, 9, 8, 3 };
		System.out.println(singleNumberN(A, 3)); 
	}
	
	public static void main(String[] args){
		SingleNumber sn = new SingleNumber(); 
		sn.test(); 
	}

}
