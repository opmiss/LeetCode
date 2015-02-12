package com.leetcode.problems.hashtable;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class RollingHash {
	/*
	 * All DNA is composed of a series of nucleotides abbreviated as A, C, G, and T, for example: "ACGAATTCCG". 
	 * When studying DNA, it is sometimes useful to identify repeated sequences within the DNA.
	 * Write a function to find all the 10-letter-long sequences (substrings) that occur more than once in a DNA molecule.
	 * For example,
	 * Given s = "AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT",
	 * Return:
	 * ["AAAAACCCCC", "CCCCCAAAAA"].
	 */
	int hash(char c){
		switch(c){
		case 'A':
			return 0; 
		case 'C':
			return 1; 
		case 'G':
			return 2; 
		}
		return 3; 
	}
	
	
    public List<String> findRepeatedDnaSequences(String s) {
    	Set<Integer> seen = new HashSet<Integer>(); 
    	int h = 0; 
    	Set<String> res = new HashSet<String>(); 
    	for (int i=0; i<s.length(); i++){
    		h = ((h<<2)|hash(s.charAt(i)))&0x000FFFFF;
    		if (i>8&&!seen.add(h)) res.add(s.substring(i-9, i+1)); 
    	}
        return new ArrayList<>(res); 
    }
    
    public void test(){
    	String s = "AAAAACCCCCAAAAACCCCCAAAAAGGGTTT";
    	System.out.println(this.findRepeatedDnaSequences(s)); 
    }
    
    public static void main(String[] args){
    	RollingHash rh = new RollingHash(); 
    	rh.test(); 
    }
}
