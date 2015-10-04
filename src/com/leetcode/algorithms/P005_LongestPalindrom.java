package com.leetcode.algorithms;

public class P005_LongestPalindrom {
	  public static String longestPalindrome(String s) {
		   	int bi, ci, cj, bj; 
		   	int halflen = 0; 
		   	int maxlen = 1; 
		   	String sol = s.substring(0, 1); 
		   	int l = s.length(); 
		   	ci=0; 
		   	while (ci<l-halflen){
		   		cj = ci;
		   		while(cj < l){
		   			if (s.charAt(ci)==s.charAt(cj)) cj++; 
		   			else break; 
		   		}
		   		if (cj == l){
		   			int hl = (cj-ci)/2; 
	   				if (halflen<hl) return s.substring(ci);
	   				else return sol; 
		   		}
		   		if (cj>ci) cj = cj-1; 
		   		
		   		bi = ci; 
		   		bj = cj; 
		 
		   		while(bi>0 && bj <l){
		   			if (s.charAt(bi) == s.charAt(bj)) {bi--; bj++;}
		   			else break; 
		   		}
		   		if (bi < 0 ) {bi=0; bj--;}
		   		if (bj == l) {bj = l-1; bi++;} 
		   		if (s.charAt(bi) != s.charAt(bj)) {bi++; bj--;}
		   		int len = (bj-bi+1); 
		   		if (maxlen<len){
		   			maxlen = len;
		   			halflen = len/2; 
		   			sol = s.substring(bi, bj+1); 
		   		}
		   		ci = cj+1; 
		   	}
	        return sol; 
	   }

}
