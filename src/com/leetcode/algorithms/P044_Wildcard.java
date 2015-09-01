package com.leetcode.algorithms;

public class P044_Wildcard {
	public boolean isMatch(String s, String p) {
        int sl = s.length(); 
		int pl = p.length(); 
		int si=0, pi=0, star=-1, stop=-1; 
		while (si<sl){
			if (pi<pl && (s.charAt(si)==p.charAt(pi) || p.charAt(pi)=='?')){
				si++; pi++;  
			}
			else if (pi<pl && p.charAt(pi)=='*'){
				star = pi++; stop = si; 
			}
			else if (star>=0) {
				pi = star+1; si=++stop; continue; 
			}
			else return false; 
		}
		while (pi<pl && p.charAt(pi)=='*') pi++;
		return (pi==pl); 
    }
	public static void main(String[] args){
		P044_Wildcard p = new P044_Wildcard(); 
		System.out.println(p.isMatch("aba", "a*a"));
	}
}
