package com.leetcode.problems.string;

import java.util.Arrays;
import java.util.Comparator;

/*
 * Given a list of non negative integers, arrange them such that they form the largest number.
 * For example, given [3, 30, 34, 5, 9], the largest formed number is 9534330.
 * Note: The result may be very large, so you need to return a string instead of an integer.
*/

public class LargestNumber {
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
		StringBuffer sb = new StringBuffer(); 
		for (int i=num.length-1; i>=0; i--){
			sb.append(numstr[i]); 
		}
		return sb.toString(); 
	}
	
	public void test(){
		int[] num = new int[]{3, 30, 34, 5, 9}; 
		System.out.println(largestNumber(num)); 
	}
	
	public static void main(String[] args){
		LargestNumber ln = new LargestNumber(); 
		ln.test(); 
	}
	

}
