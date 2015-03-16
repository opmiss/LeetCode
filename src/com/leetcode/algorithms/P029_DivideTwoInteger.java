package com.leetcode.algorithms;

public class P029_DivideTwoInteger {
	 public int divide(int dividend, int divisor) {
	        //consider special cases of the divisor 
	    	if (divisor == 1) return dividend; 
	        if (divisor == 2) return dividend>>1; 
	        //convert dividend and divisor to long to avoid 2's complement problem when taking negation 
	        long a = Math.abs((long)dividend);
	        long b = Math.abs((long)divisor); 
	        
	        int sol = 0; int inc = 1; 
	        final long c = b; 
	        while (a>=c){
	            if (a >= b){
	                a -= b;
	                b += b; 
	                sol+=inc;
	                inc +=inc;
	            }else {
	                b  = b >> 1;  
	                inc = inc >>1; 
	            }
	        }
	        //use unsigned shift right to detremine if the result should be negated 
	        return ( ((dividend ^ divisor) >>> 31) == 1) ? (-sol) : sol;  
	    }

}
