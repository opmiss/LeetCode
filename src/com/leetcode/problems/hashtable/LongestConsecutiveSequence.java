package com.leetcode.problems.hashtable;

import java.util.HashMap;
import java.util.Map;

/* 
 * Given an unsorted array of integers, find the length of the longest consecutive elements sequence.
 * For example, given [100, 4, 200, 1, 3, 2],
 * The longest consecutive elements sequence is [1, 2, 3, 4]. Return its length: 4.
 * Your algorithm should run in O(n) complexity.
 */

public class LongestConsecutiveSequence {
	
    public int longestConsecutive(int[] num) {
        Map<Integer, Integer> map = new HashMap<Integer, Integer>(); 
        int maxLength=1; 
        for (Integer n:num){
        	if (map.get(n)==null){ 
        		Integer leftLength = map.get(n-1); 
        		Integer rightLength = map.get(n+1);
        		if (leftLength==null && rightLength==null){
        			map.put(n, 1); 
        		}
        		else if (leftLength==null) {
        			map.put(n+rightLength, rightLength+1);
        			map.put(n, rightLength+1); 
        			maxLength = Math.max(maxLength, map.get(n)); 
        		}
        		else if (rightLength==null){
        			map.put(n-leftLength, leftLength+1);
        			map.put(n, leftLength+1); 
        			maxLength = Math.max(maxLength, map.get(n)); 
        		}
        		else{
        			map.put(n-leftLength, rightLength+leftLength+1);
        			map.put(n+rightLength, rightLength+leftLength+1);
        			map.put(n, rightLength+leftLength+1); 
        			maxLength = Math.max(maxLength, map.get(n)); 
        		}
        	}
        }
    	return maxLength; 
    }
}
