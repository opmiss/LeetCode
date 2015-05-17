package com.leetcode.algorithms;

import java.util.*;

public class P179_LargestNumber {
	class NumberComparator implements Comparator<String> {
		@Override
		public int compare(String s1, String s2) {
			String s12 = s1+s2; 
			String s21 = s2+s1; 
			for (int i=0; i<s12.length(); i++){
				if (s12.charAt(i)>s21.charAt(i)) return 1; 
				else if (s12.charAt(i)<s21.charAt(i)) return -1; 
			}
			return 0;
		}
	}
	public String largestNumber(int[] num){
		String[] numstr = new String[num.length]; 
		for (int i=0; i<num.length; i++){
			numstr[i] = Integer.toString(num[i]); 
		}
		NumberComparator nc = new NumberComparator(); 
		Arrays.sort(numstr, nc);
		if (numstr[num.length-1].charAt(0)=='0') return "0"; 
		StringBuffer sb = new StringBuffer(); 
		for (int i=num.length-1; i>=0; i--){
			sb.append(numstr[i]); 
		}
		return sb.toString(); 
	}

}
