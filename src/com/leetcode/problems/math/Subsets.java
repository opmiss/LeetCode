package com.leetcode.problems.math;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

/* 
 * Given a set of distinct integers, S, return all possible subsets.
 * Note:
 * Elements in a subset must be in non-descending order.
 * The solution set must not contain duplicate subsets.
 * For example, if S = [1,2,3], a solution is:
 * [
 * [3],
 * [1],
 * [2],
 * [1,2,3],
 * [1,3],
 * [2,3],
 * [1,2],
 * []
 * ]
*/

public class Subsets {
    ArrayList<Integer> empty = new ArrayList<Integer>(); 
    HashMap<Integer, Integer> map; 
    
    public ArrayList<ArrayList<Integer>> subsets(int[] num) {
        ArrayList<ArrayList<Integer>> ret = new ArrayList<ArrayList<Integer>>();
        ret.add(empty);
        if (num.length==0) return ret;
        map = new HashMap<Integer, Integer>(); 
        for (int n:num){
            Integer k = map.get(n);
            if (k==null) map.put(n, 1);
            else map.put(n, (k+1)); 
        }
        for (Integer n:map.keySet()){
            ret = crosslist(ret, tolist(n, map.get(n))); 
        }
        for (ArrayList<Integer> r:ret){
            Collections.sort(r); 
        }  
        return ret; 
    }
    public ArrayList<ArrayList<Integer>> crosslist(ArrayList<ArrayList<Integer>> list1, ArrayList<ArrayList<Integer>> list2){
        ArrayList<ArrayList<Integer>> ret = new ArrayList<ArrayList<Integer>>();
        for (ArrayList<Integer> r1:list1){
            for (ArrayList<Integer> r2:list2){
                ArrayList<Integer> r = new ArrayList<Integer>(); 
                r.addAll(r1); r.addAll(r2);
                ret.add(r); 
            }
        }
        return ret; 
    }
    public ArrayList<ArrayList<Integer>> tolist(int n, int k){
        ArrayList<ArrayList<Integer>> ret = new ArrayList<ArrayList<Integer>>(); 
        ret.add(empty); 
        for (int i=1; i<=k; i++){
            ArrayList<Integer> row = new ArrayList<Integer>(); 
            for (int j = 0; j<i; j++){
                row.add(n); 
            }
            ret.add(row); 
        }
        return ret; 
    }
}
