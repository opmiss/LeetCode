package com.leetcode.algorithms;

import java.util.*;

public class P210_CourseSchedule2 {
	int[] O; 
	int k; 
	public int[] findOrder(int numCourses, int[][] prerequisites){
		Stack<Integer>[] P = new Stack[numCourses]; 
        O = new int[numCourses]; k=0;  
    	boolean[] V = new boolean[numCourses]; 
    	boolean[] D = new boolean[numCourses]; 
    	for (int i=0; i<numCourses; i++) P[i] = new Stack<Integer>(); 
    	int np = prerequisites.length; 
    	for (int i=0; i<np; i++){
    		P[prerequisites[i][0]].push(prerequisites[i][1]); 
    	}
    	for (int i=0; i<numCourses; i++){
    		boolean b = visit(i, P, V, D); 
    		if (!b) return new int[0]; 
    	}
    	return O; 
	}
	public boolean visit(Integer c, Stack<Integer>[] P, boolean[] V, boolean[] D){
    	if (V[c]) return false; 
    	if (P[c].isEmpty()) {
    	    if (!D[c]) {
    	        O[k++]=c; 
    	        D[c] = true; 
    	    }
    	    return true; 
    	}
    	V[c]=true; 
    	while (!P[c].isEmpty()) {
    		boolean b = visit(P[c].pop(), P, V, D); 
    		if (!b) return false; 
    	}
    	V[c] = false; 
    	O[k++]=c; 
    	D[c] = true; 
    	return true; 
    }
}
