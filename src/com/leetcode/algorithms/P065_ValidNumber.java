package com.leetcode.algorithms;

public class P065_ValidNumber {
	public boolean isNumber(String s) {
        int n = s.length(); 
        int i=0; 
        boolean floating=false; 
        boolean power = false; 
        boolean sign = false; 
        boolean number = false; 
        while (i<n && s.charAt(i)==' '){
            i++; 
        } 
        for ( ; i<n; i++){
            if (s.charAt(i)>='0' && s.charAt(i)<='9') {
                number=true; 
                continue; 
            }
            if ((s.charAt(i)=='+'||s.charAt(i)=='-')&&(!sign && !number && (!floating||power))){
                sign = true; 
                continue; 
            }
            if (s.charAt(i)=='.' && !floating && !power){
                floating = true; 
                continue; 
            }
            if (s.charAt(i)=='e'&&!power && number){
                if (i==n-1) return false; 
                power=true;
                number=false; 
                sign = false; 
                continue; 
            }
            if (s.charAt(i)==' '){ 
                break; 
            }
            return false; 
        }
        while (i<n && s.charAt(i)==' '){
            i++; 
        } 
        return (i==n)&&number; 
    }
}
