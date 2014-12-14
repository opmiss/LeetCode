package com.leetcode.problems.string;

public class Substring {
	
	/* Given a string S and a string T, find the minimum window in S which will contain all the characters in T in complexity O(n).
	 * For example,
	 * S = "ADOBECODEBANC"
	 * T = "ABC"
	 * Minimum window is "BANC".
	 * Note:
	 * 
	 * If there is no such window in S that covers all characters in T, return the emtpy string "".
	 * If there are multiple such windows, you are guaranteed that there will always be only one unique minimum window in S.
	 */ 
	public String minWindow(String S, String T) {
		int[] require = new int[128]; 
		for (int i=0; i<T.length(); i++) require[T.charAt(i)]++; 
		int i=0, j=0, found =0, minLength = Integer.MAX_VALUE, start = 0; 
		while (j<S.length()){
			if (found<T.length()&& i<S.length()){
				if (--require[S.charAt(i)]>=0 )found++; 
				i++;  
			}
			else {
				if (++require[S.charAt(j)]>0) { 
				    if (found>=T.length() && minLength>(i-j)) {
				        minLength = (i-j); 
					    start = j; 
				    }
				    found--;
				}
				j++;
			}
		}
        return minLength==Integer.MAX_VALUE?"":S.substring(start, start+minLength); 
    }
	/*
	 * Given a string, find the longest substring that contains only two unique characters. 
	 * For example, given S = "abcbbbbcccbdddadacb", the longest substring that contains 2 unique character is "bcbbbbcccb".
	 */
	public String maxWindow(String S){
		return null; 
	}
	
}
