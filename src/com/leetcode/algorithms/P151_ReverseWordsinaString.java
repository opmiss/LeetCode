package com.leetcode.algorithms;
import java.util.*; 

public class P151_ReverseWordsinaString {
	public String reverseWords(String s) {
        Stack<String> words = new Stack<String>(); 
        StringBuffer w = new StringBuffer(); 
        int n = s.length(); 
        for (int i=0; i<n; i++){
            if (s.charAt(i) == ' '){
                if (w.length() >0) {
                    words.push(w.toString());
                    w = new StringBuffer(); 
                }
            }
            else {
                w.append(s.charAt(i)); 
            }
        }
        if (w.length()>0) words.push(w.toString());
        w = new StringBuffer(); 
        while (!words.empty()) {
            w.append(words.pop()); 
            w.append(" ");
        }
        if (w.length()>0) w.deleteCharAt(w.length()-1); 
        return w.toString(); 
    }
}
