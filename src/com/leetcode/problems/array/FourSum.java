package com.leetcode.problems.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

/* *
 * Given an array S of n integers, are there elements a, b, c, and d in S such that a + b + c + d = target? 
 * Find all unique quadruplets in the array which gives the sum of target.
 * Note:
 * Elements in a quadruplet (a,b,c,d) must be in non-descending order. (ie, a <= b <= c <= d)
 * The solution set must not contain duplicate quadruplets.
 * For example, given array S = {1 0 -1 0 -2 2}, and target = 0.
 * A solution set is:
 * (-1,  0, 0, 1)
 * (-2, -1, 1, 2)
 * (-2,  0, 0, 2) 
 * */

public class FourSum {
	HashMap<Integer, ArrayList<Integer>> map; 
    public ArrayList<ArrayList<Integer>> fourSum(int[] num, int target) {
        ArrayList<ArrayList<Integer>> ret = new ArrayList<ArrayList<Integer>>(); 
        if (num.length<4) return ret; 
        Arrays.sort(num); 
        map = new HashMap<Integer, ArrayList<Integer>>(); 
        for (int i=num.length-1; i>0; i--){
            if (i < num.length-1 && num[i] == num[i+1]) continue; 
            for (int j=i-1; j>=0; j--){
                if (j < i-1 && num[j] == num[j+1]) continue; 
                ArrayList<Integer> list = map.get((num[i]+num[j]));
                if (list==null) list = new ArrayList<Integer>(); 
                list.add(j); list.add(i);  
                map.put((num[i]+num[j]), list); 
            }
        }
        for (int i=0; i<num.length-1; i++){
            if (i>0 && num[i] == num[i-1]) continue; 
            for (int j=i+1; j<num.length; j++){
                if (j>(i+1) && num[j]==num[j-1]) continue; 
                ArrayList<Integer> list = map.get(target-(num[i]+num[j])); 
                if (list==null) continue; 
                for (int k=0; k<list.size(); k+=2){
                    if (list.get(k) >j){ //this avoid duplicates
                        ArrayList<Integer> sol = new ArrayList<Integer>(); 
                        sol.add(num[i]); sol.add(num[j]);
                        sol.add(num[list.get(k)]);  sol.add(num[list.get(k+1)]); 
                        ret.add(sol); 
                    }
                }
            }
        }
        return ret; 
    }
}
