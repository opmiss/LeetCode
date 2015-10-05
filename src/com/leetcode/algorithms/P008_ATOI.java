package com.leetcode.algorithms;

public class P008_ATOI {
	public int atoi(String str) {
        if (str.length()==0) return 0; 
        str = str.trim(); 
        boolean neg = false; 
        if (str.charAt(0)=='-') {
            neg = true; 
            str = str.substring(1); 
        }
        else if (str.charAt(0)=='+'){
            str = str.substring(1); 
        }
        int k=0; 
        while (k<str.length()){
            if (str.charAt(k)<'0' || str.charAt(k)>'9') break; 
            k++; 
        }
        str = str.substring(0, k); 
        if (str.length()==0) return 0; 
        if (str.length()>10){ 
            if (neg) return Integer.MIN_VALUE; 
            else return Integer.MAX_VALUE; 
        }
        else if (str.length()==10){
            if (neg){
                String min="2147483648"; 
                if (str.equals(min)) return Integer.MIN_VALUE; 
                for (int i=0; i<10; i++) {
                    if (str.charAt(i)>min.charAt(i)) return Integer.MIN_VALUE; 
                    else if (str.charAt(i)<min.charAt(i)) break; 
                }
            }
            else {
                String max = "2147483647"; 
                if (str.equals(max)) return Integer.MAX_VALUE; 
                for (int i=0; i<10; i++) {
                    if (str.charAt(i)>max.charAt(i)) return Integer.MAX_VALUE; 
                    if (str.charAt(i)<max.charAt(i)) break; 
                }
            }
        }
        if (neg) return -Integer.parseInt(str);
        else return Integer.parseInt(str);
    }
}
