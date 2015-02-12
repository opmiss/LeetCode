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
	
    private static final Map<Character, Integer> A = new HashMap<>();
    static { A.put('A',0); A.put('C',1); A.put('G',2); A.put('T',3); }
    private final int A_SIZE_POW_9 = (int) Math.pow(A.size(), 9);

    public List<String> findRepeatedDnaSequences(String s) {
        Set<String> res = new HashSet<>();
        Set<Integer> hashes = new HashSet<>();
        for (int i = 0, rhash = 0; i < s.length(); i++) {
            if (i > 9) rhash -= A_SIZE_POW_9 * A.get(s.charAt(i-10));
            rhash = A.size() * rhash + A.get(s.charAt(i));
            if (i > 8 && !hashes.add(rhash)) res.add(s.substring(i-9,i+1));
        }
        return new ArrayList<>(res);
    }
	
	
    public List<String> findRepeatedDnaSequences_(String s) {
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
    	System.out.println(this.findRepeatedDnaSequences_(s)); 
    }
    
    public static void main(String[] args){
    	RollingHash rh = new RollingHash(); 
    	rh.test(); 
    }
}
