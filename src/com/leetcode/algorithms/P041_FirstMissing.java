package com.leetcode.algorithms;

public class P041_FirstMissing {
	public int firstMissingPositive(int[] A) {
        int i=0; 
        while (i<A.length){
            if (A[i] >=1 && A[i] <=A.length && A[i]!=i+1 && A[A[i]-1]!=A[i]){
                int t = A[i];
                int s = A[i]-1; 
                A[i] = A[s];
                A[s] = t;
            }
            else{ 
                i++;
            }
        }
        for (i=0; i<A.length; i++){
            if (A[i]!=i+1) return (i+1); 
        }
        return A.length+1; 
    }

}
