package com.leetcode.algorithms;
import java.util.*;

public class P016_3SumClosest {
	 public int threeSumClosest(int[] num, int target) {
	        //first sort the input array into ascending order
	        Arrays.sort(num); 
	        
	        int tar, n2, n3, sum, d, ret=target, diff=Integer.MAX_VALUE; 
	        
	        for (int n1=0; n1<num.length-2; n1++){
	            tar = target-num[n1]; 
	            n2 = n1+1; 
	            n3 = num.length-1; 
	            while (n2<n3){
	                sum = num[n2]+num[n3]; 
	                d = Math.abs(sum-tar); 
	                if(d<diff) { diff =d; ret = num[n1]+sum; }  
	                if (sum < tar)  n2++; 
	                else if ( sum > tar) n3--; 
	                else return target; 
	            }
	        }
	        return ret; 
	    }

}
