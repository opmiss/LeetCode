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
		int sl = s.length(), pl = p.length(); 
		int si =0, pi=0;
		while (si<sl){
			if (pi==pl-1 || (pi+1<pl && p.charAt(pi+1)!='*')){
				if (p.charAt(pi)=='.' || s.charAt(si)==p.charAt(pi)) {pi++; si++;}
				else return false; 
			}
			else if (pi+1<pl){ 
				if (isRegularMatch(s.substring(si), p.substring(pi+2))) return true; 
				else if (p.charAt(pi)=='.' || s.charAt(si)==p.charAt(pi)) si++; 
				else return false; 
			}
			else return false; 
		}
		while (pi+1<pl&&p.charAt(pi+1)=='*') pi+=2; 
		return (si==sl && pi==pl); 
	}
	
	public void testRegularMatch(){
		System.out.println(isRegularMatch("aa", "a")); 
		System.out.println(isRegularMatch("aa", "aa")); 
		System.out.println(isRegularMatch("aaa", "aa")); 
		System.out.println(isRegularMatch("aa", "a*")); 
		System.out.println(isRegularMatch("aa", ".*")); 
		System.out.println(isRegularMatch("ab", ".*")); 
		System.out.println(isRegularMatch("aab", "c*a*b")); 
		System.out.println(isRegularMatch("abcd", "d*"));
		System.out.println(isRegularMatch("ab", ".*c")); 
	}
	
	public static void main(String[] args){
		Match m = new Match(); 
		m.testRegularMatch();
	}
}
