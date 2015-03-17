package com.leetcode.problems.greedy;

public class Match {
	/*
	 * Implement wildcard pattern matching with support for '?' and '*'.
	 * '?' Matches any single character.
	 * '*' Matches any sequence of characters (including the empty sequence).
	 * The matching should cover the entire input string (not partial).
	 * The function prototype should be:
	 * bool isMatch(const char *s, const char *p)
	 * Some examples:
	 * isMatch("aa","a") -> false
	 * isMatch("aa","aa") -> true
	 * isMatch("aaa","aa") -> false
	 * isMatch("aa", "*") -> true
	 * isMatch("aa", "a*") -> true
	 * isMatch("ab", "?*") -> true
	 * isMatch("aab", "c*a*b") -> false
	 */
	boolean isWildcardMatch(String s, String p){
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
	
	public void testWildcardMatch(){
		System.out.println(isWildcardMatch("cabba", "c*ba")); 
		System.out.println(isWildcardMatch("cabba", "c*baa")); 
		System.out.println(isWildcardMatch("aab", "c*a*b")); 
		System.out.println(isWildcardMatch("", "*")); 
		System.out.println(isWildcardMatch("aa", "*"));
		System.out.println(isWildcardMatch("aa", "a")); 
		System.out.println(isWildcardMatch("", "")); 
	}
	/*
	 * Implement regular expression matching with support for '.' and '*'.
	 * '.' Matches any single character.
	 * '*' Matches zero or more of the preceding element.
	 * The matching should cover the entire input string (not partial).
	 * The function prototype should be:
	 * bool isMatch(const char *s, const char *p)
	 * Some examples:
	 * isMatch("aa","a") -> false
	 * isMatch("aa","aa") -> true
	 * isMatch("aaa","aa") -> false
	 * isMatch("aa", "a*") -> true
	 * isMatch("aa", ".*") -> true
	 * isMatch("ab", ".*") -> true
	 * isMatch("aab", "c*a*b") -> true
	 */
	boolean isRegularMatch(String s, String p){
		
	}
	
	public static void main(String[] args){
		Match m = new Match(); 
		m.testWildcardMatch();
	}
}
