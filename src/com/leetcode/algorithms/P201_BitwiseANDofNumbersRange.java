package com.leetcode.algorithms;

public class P201_BitwiseANDofNumbersRange {
	public int rangeBitwiseAnd(int m, int n) {
        int r = 0; 
        while (m!=n){
            m>>=1; 
            n>>=1; 
            ++r; 
        }
        return m<<r; 
    }
}
