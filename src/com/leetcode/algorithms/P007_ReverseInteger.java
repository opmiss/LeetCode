package com.leetcode.algorithms;

public class P007_ReverseInteger {
	 public int reverse(int x) {
	        boolean neg = false; 
	        if (x < 0) {neg = true; x=-x; }
	        String xs = Integer.toString(x);
	        xs = (new StringBuilder(xs)).reverse().toString();
	        x = Integer.parseInt(xs); 
	        if (neg) x= -x; 
	        return x; 
	    }

}
