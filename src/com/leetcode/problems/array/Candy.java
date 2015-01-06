package com.leetcode.problems.array;

import java.util.HashMap;
import java.util.Map;

public class Candy {
	/*
	 * There are N children standing in a line. Each child is assigned a rating value.
	 * You are giving candies to these children subjected to the following requirements:
	 * Each child must have at least one candy.
	 * Children with a higher rating get more candies than their neighbors.
	 * What is the minimum candies you must give?
	 */
    public int candy(int[] ratings) {
    	if (ratings.length == 1) return 1; 
    	int[] candy =new int[ratings.length]; 
    	candy[0]=1; 
    	for (int i=1; i<ratings.length; i++){
    		if (ratings[i] > ratings[i-1]) candy[i]=candy[i-1]+1; 
    		else candy[i]=1; 
    	}
    	int cur = candy[ratings.length-1];
    	int tol = cur; 
    	for (int i=ratings.length-2; i>=0; i--){
    		if (ratings[i] > ratings[i+1]) cur++; 
    		else cur=1; 
    		tol+=(cur>candy[i])?cur:candy[i];  
    	}
        return tol; 
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
