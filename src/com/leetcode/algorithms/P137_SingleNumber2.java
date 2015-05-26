package com.leetcode.algorithms;

public class P137_SingleNumber2 {
	public int singleNumber(int[] A) {
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
