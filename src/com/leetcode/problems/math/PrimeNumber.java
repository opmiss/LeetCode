package com.leetcode.problems.math;

import java.util.Arrays;

public class PrimeNumber {
	public static void main(String[] args){
		int n=1000; 
	    boolean[] notPrime = new boolean[n]; 
        if (n<3) return; 
        notPrime[0] = true; notPrime[1] = true; 
        notPrime[2] = false; 
        for (int i=2; i<n; i++){
        	if (notPrime[i]) continue; 
        	System.out.println(i); 
            for (int k=i*2; k<n; k+=i) {
            	notPrime[k] = true; 
            }
        }
     //   for (int i=0; i<n; i++) if (!notPrime[i]) System.out.println(i); 
	}

}
