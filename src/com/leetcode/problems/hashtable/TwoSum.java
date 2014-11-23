package com.leetcode.problems.hashtable;

import java.util.HashMap;

/* Given an array of integers, find two numbers such that they add up to a specific target number.
 * The function twoSum should return indices of the two numbers such that they add up to the target, 
 * where index1 must be less than index2. 
 * Please note that your returned answers (both index1 and index2) are not zero-based.
 * 
 * You may assume that each input would have exactly one solution.
 * Input: numbers={2, 7, 11, 15}, target=9
 * Output: index1=1, index2=2
 */

public class TwoSum {
	//linear time solution using hashmap
	HashMap<Integer, Integer> map; 
    public int[] twoSum(int[] numbers, int target) {
        map = new HashMap<Integer, Integer>(); 
        for (int i=0; i<numbers.length; i++){
            map.put(numbers[i], (i+1)); 
        }
        for (int i=0; i<numbers.length; i++){
            int find = target - numbers[i]; 
            if (map.containsKey(find) && ((i+1)<map.get(find)) ){
                int[] ret = new int[2]; 
                ret[0]=(i+1); 
                ret[1]=map.get(find); 
                return ret; 
            }
        }
        return null; 
    }
}
