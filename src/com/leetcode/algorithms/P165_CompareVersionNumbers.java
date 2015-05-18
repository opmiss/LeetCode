package com.leetcode.algorithms;

public class P165_CompareVersionNumbers {
	 public int compareVersion(String version1, String version2) {
	        String[] v1 = version1.split("\\.");
	        String[] v2 = version2.split("\\.");
	        int i=0, r1, r2; 
	        while(i<v1.length&&i<v2.length){
	            r1 = Integer.parseInt(v1[i]); 
	            r2 = Integer.parseInt(v2[i]);
	            if (r1>r2) return 1; 
	            if (r1<r2) return -1; 
	            i++; 
	        }
	        while (i<v1.length) {
	            r1 = Integer.parseInt(v1[i]); 
	            if (r1>0) return 1; 
	            i++; 
	        }
	        while (i<v2.length) {
	            r2 = Integer.parseInt(v2[i]); 
	            if (r2>0) return -1; 
	            i++; 
	        }
	        return 0; 
	    }
}
