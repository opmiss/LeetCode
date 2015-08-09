package com.leetcode.algorithms;
import java.util.*; 

public class P022_GenerateParentheses {
	//algorithm to generate all valid parentheses 
	 public ArrayList<String> generateParenthesis(int n) {
	        ArrayList<String> ret = new ArrayList<String>(); 
	        if (n==0) {
	            ret.add(""); return ret;
	        }
	        if (n==1) {
	            ret.add("()"); return ret;  
	        }
	        for (int i=0; i<n; i++){
	            for (String inner: generateParenthesis(i)){
	                for (String outter:generateParenthesis(n-i-1)){
	                    ret.add("("+inner+")"+outter); 
	                }
	            }
	        }
	        return ret; 
	    }

}
