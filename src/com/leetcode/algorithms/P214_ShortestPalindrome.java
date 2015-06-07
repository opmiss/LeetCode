package com.leetcode.algorithms;
/* 
 * Given a string S, you are allowed to convert it to a palindrome by adding characters in front of it. 
 * Find and return the shortest palindrome you can find by performing this transformation.
 * For example:
 * Given "aacecaaa", return "aaacecaaa".
 * Given "abcd", return "dcbabcd".
*/

public class P214_ShortestPalindrome {
	
	class Element{
		char ch; 
		int leng; 
		Element(){
			
		}
	}
	
	public String shortestPalindrome(String s){
		StringBuffer sb = new StringBuffer(s); 
		sb = sb.reverse(); 
		return null; 
	}
	
	public int[] computeTable(String W){
		int[] T = new int[W.length()]; 
		int pos = 2, cnd=0; 
		T[0]=-1; T[1]=0; 
		while (pos <W.length()){
			if (W.charAt(pos-1)==W.charAt(cnd)){
				T[pos]=++cnd; 
				pos++;
			}
			else if (cnd>0){
				cnd=T[cnd]; 
			}
			else T[pos++]=0; 
		}
		return T; 
	}
	
	public int strStr(String S, String W){
		int m=0, i=0; 
		int[] T=computeTable(W); 
		while (m+i<S.length()){
			if (W.charAt(i) == S.charAt(i+m)){
				if (i==W.length()-1) return m; 
				i++; 
			}
			else {
				if (T[i]>-1) {
					m=m+i-T[i]; 
					i=T[i]; 
				}
				else {
					i=0; 
					m=m+1; 
				}
			}
		}
		return -1; 
	}
	
	public static void main(String[] args){
		
	}
}
