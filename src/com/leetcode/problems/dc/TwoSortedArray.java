package com.leetcode.problems.dc;

import java.util.Arrays;

/* There are two sorted arrays A and B of size m and n respectively. 
 * Find the median of the two sorted arrays. 
 * The overall run time complexity should be O(log (m+n)).
 */

public class TwoSortedArray {
	
	 public double findMedianSortedArrays(int A[], int B[]) { 
	        if (A.length ==0) return Median(B, 0, B.length);
	        if (B.length == 0) return Median(A, 0, A.length); 
	        return findMedian(A, 0, A.length, B, 0, B.length); 
	    }
	    double findMedian(int A[], int as, int ae, int B[], int bs, int be){
	        int al = ae-as; int bl = be-bs; 
	        if (al < 2) return findMedian(A[as], B, bs, be); 
	        if (al < 3) return findMedian(A[as], A[as+1], B, bs, be); 
	        if (bl < 2) return findMedian(B[bs], A, as, ae);
	        if (bl < 3) return findMedian(B[bs], B[bs+1], A, as, ae); 
	        double MA = Median(A, as, ae);
	        double MB = Median(B, bs, be); 
	        if (MA == MB) return MA;
	        int cut; 
	        if (al<bl) {
	            if (al%2==1) cut = al/2;
	            else cut = al/2-1; 
	        }
	        else {
	            if (bl%2==1) cut = bl/2;
	            else cut = bl/2-1; 
	        }
	        if (MA < MB){
	            as += cut; 
	            be -= cut; 
	        }
	        if (MA > MB){
	            ae -= cut; 
	            bs += cut; 
	        }
	        return findMedian(A, as, ae, B, bs, be); 
	    }
	    double findMedian(int A, int B[], int bs, int be){
	        int bl = be-bs; 
	        if (bl < 2) return findMedian(A, B[bs]); 
	        if (bl < 3) return findMedian(A, B[bs], B[bs+1]); 
	        int bm = bs+bl/2; 
	        if (bl%2==0) return findMedian(A, B[bm-1], B[bm]); 
	        else {
	            if (A > B[bm]){
	                return findMedian(B[bm], findMedian(A, B[bm], B[bm+1])); 
	            }
	            else {
	                return findMedian(B[bm], findMedian(A, B[bm], B[bm-1])); 
	            }
	        }
	    }
	    double findMedian(int n1, int n2, int B[], int bs, int be){
	        int bl = be-bs; 
	        if (bl < 2) return findMedian(n1, n2, B[bs]);
	        if (bl < 3) return findMedian(n1, n2, B[bs], B[bs+1]); 
	        int bm = bs+bl/2; 
	        if (bl%2==0){
	            if (n2 < B[bm-1]) {
	                return findMedian(B[bm-1], findMedian(n2, B[bm-2], B[bm-1])); 
	            }
	            if (n2 < B[bm]){
	                return findMedian(n2, findMedian(B[bm-1], n1, n2)); 
	            }
	            if (n1 > B[bm]){
	                return findMedian(B[bm], findMedian(n1, B[bm], B[bm+1])); 
	            }
	            if (n1 > B[bm-1]){
	                return findMedian(n1, findMedian(n1, n2, B[bm])); 
	            }
	            return findMedian(B[bm-1], B[bm]); 
	        }
	        else {
	            if (n2 < B[bm]) return findMedian(n2, B[bm-1], B[bm]); 
	            if (n1 > B[bm]) return findMedian(n1, B[bm], B[bm+1]); 
	            return B[bm]; 
	        }
	    }
	    
	    double findMedian(int A, int B){
	        return ((double)A + (double)B)/2.0; 
	    }
	    
	    double findMedian(int A, int B, int C, int D){
	        int[] N = new int[]{A, B, C, D};
	        Arrays.sort(N);
	        return findMedian(N[1], N[2]); 
	    }
	    
	    int findMedian(int A, int B, int C){
	        if (A < B){
	            if (B < C) return B; 
	            if (A > C) return A; 
	            return C; 
	        }     
	        else {
	            if (B > C) return B; 
	            if (A < C) return A; 
	            return C; 
	        }
	    }
	    double Median(int A[], int as, int ae){
	        int al = ae-as; 
	        if (al%2 == 0) {
	            int am1 = as+al/2;
	            int am2 = am1-1; 
	            return ((double)A[am1] + (double)A[am2])/2.0; 
	        }
	        else {
	            int am = as+al/2; 
	            return A[am]; 
	        }
	    }

}
