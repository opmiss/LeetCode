package com.leetcode.algorithms;

public class P191_Numberof1Bits {
	public int hammingWeight(int n) {
        int ret = 0; 
        while (n!=0){
            if ((n&1)==1) ret++;
            n>>>=1; 
        }
        return ret; 
    }
}
