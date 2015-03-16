package com.leetcode.algorithms;

public class P031_NextPermutation {
	public void nextPermutation(int[] num) {
        int n = num.length;
        if (n<=1) return; 
        int i = n-1; 
        while (i>=1){
            if (num[i-1] < num[i]) break;  
            i--;
        }
        if (i==0) {
            int s = 0; 
            int e = n-1; 
            while (s<e){
                swap(num, s, e); 
                s++; e--; 
            }
            return; 
        }
        int m = i; 
        int p = i-1; 
        for (i=n-1; i>=m; i--){
            if (num[i] > num[p]) break; 
        }
        int h = i; 
        swap(num, p, h); 
        int s = m; 
        int e = n-1; 
        while (s<e){
            swap(num, s, e); 
            s++; e--; 
        }
    }
    public void swap(int[] num, int i, int j){
        int t = num[i]; 
        num[i] = num[j]; 
        num[j] = t; 
    }

}
