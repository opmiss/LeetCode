package com.leetcode.problems.math;

/* 
 * Validate if a given string is numeric.
 * Some examples:
 * "0" => true
 *  0.1 " => true
 *  "abc" => false
 *  "1 a" => false
 *  "2e10" => true
 *  Note: It is intended for the problem statement to be ambiguous. You should gather all requirements up front before implementing one.
 */

public class ValidNumber {
    public boolean isNumber(String s) {
        s = s.trim(); 
        int e = s.indexOf("e"); 
        if (e>0){
            return isRegularNumber(s.substring(0, e)) && isPowerNumber(s.substring(e+1)); 
        }
        else return isRegularNumber(s); 
      }
      
      public boolean isRegularNumber(String s){
        if (s.length()<1) return false; 
        String p1 = "[+-]?[0-9]+([.][0-9]*)?"; 
        String p2 = "[+-]?[0-9]*[.][0-9]+";
        return s.matches(p1) || s.matches(p2); 
      }
      
      public boolean isPowerNumber(String s){
          String p = "[+-]?[0-9]+"; 
          return s.matches(p); 
      }
}
