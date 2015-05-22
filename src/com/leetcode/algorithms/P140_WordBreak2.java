package com.leetcode.algorithms;

import java.util.*;


public class P140_WordBreak2 {
	public List<String> wordBreak(String s, Set<String> dict) {
		 int[] r = getLengthRange(dict);
		 return helper(s, dict, r[0], r[1]); 
	 }
	 
	 public List<String> helper(String s, Set<String> dict, int minL, int maxL){
		 List<String> ret = new ArrayList<String>();
		 if (s==null || s.length() < minL) return ret; 
		 int sl= s.length(); 
		 maxL = (maxL<sl)?maxL:sl; 
		 
		 boolean stop = true; 
		 for (int i=minL; i<=maxL; i++) if (dict.contains(s.substring(s.length()-i))) {stop=false; break;} 
		 if (stop) return ret; 
		 
		 String head; 
		 for (int i=minL; i<=maxL; i++){
			 head = s.substring(0, i); 
			 if (dict.contains(head)){
			     if (i==sl) {
			    	 ret.add(head); 
			    	 return ret; 
			     }
			     List<String> rest = helper(s.substring(i), dict, minL, maxL); 
			     for (String p:rest){ 
			    	 ret.add(head+" "+p); 
			     }
			 }
		 }
		 return ret; 
	 }
	
	 int[] getLengthRange(Set<String> dict){
		 int[] range=new int[2]; 
		 range[0] = Integer.MAX_VALUE; 
		 for (String s:dict){
		     int sl = s.length();
			 range[0] = (range[0]<sl)? range[0]:sl; 
			 range[1] = (range[1]>sl)? range[1]:sl; 
		 }
		 return range; 
	 }

}
