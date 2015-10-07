package com.leetcode.algorithms;
import java.util.*;

public class P018_4Sum {
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
                    if (list.get(k) >j){
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
