package com.leetcode.algorithms;

public class P171_ExcelSheetColumnNumber {
	public int titleToNumber(String s) {
        int n=s.length(); 
        int col=0; 
        for (int i=0; i<n; i++){
            col*=26; 
            col+=(s.charAt(i)-'A')+1; 
        }
        return col; 
    }
}
