package com.leetcode.problems.array;

import java.util.HashMap;
import java.util.Map;
/*
 * There are N children standing in a line. Each child is assigned a rating value.
 * You are giving candies to these children subjected to the following requirements:
 * Each child must have at least one candy.
 * Children with a higher rating get more candies than their neighbors.
 * What is the minimum candies you must give?
 */

public class Candy {
    public int candy(int[] ratings) {
        return 0; 
    }
    public int majorityElement(int[] num) {
        Map<Integer, Integer> map = new HashMap<Integer, Integer>(); 
        for (int n:num){
            Integer c = map.get(n);
            if (c==null) c=0; 
            c++; 
            if (c>num.length/2) return n; 
            map.put(n, c);
        }
        return 0; 
    }
    
    public static void main(String[] args){
    	String a= "asdfsdg"; 
    	
    	System.out.println(Integer.parseInt("001")); 
    }

}
