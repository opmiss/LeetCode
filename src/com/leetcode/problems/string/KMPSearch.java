package com.leetcode.problems.string;
import java.util.*;

public class KMPSearch {
	
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
					System.out.println(m); 
				}
				else {
					i=0; 
					m=m+1; 
				}
			}
		}
		return -1; 
	}
	
	public void test(){
		String haystack = "abcabcabcedcbacbacbacba";
		String needle = "abcabcabcdecbacbacbacba"; 
		System.out.println(strStr(haystack, needle)); 
		
	}
	
	public static void main(String[] args){
		KMPSearch kmp = new KMPSearch(); 
		kmp.test();
		int[] T=kmp.computeTable("ababab");
		System.out.println(); 
		for (int i=0; i<T.length; i++) System.out.print(T[i]); 
		ArrayList<Integer> list = new ArrayList<Integer>(); 
		list.set(5, 6); 
		
	}
}
