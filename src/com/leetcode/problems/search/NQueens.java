package com.leetcode.problems.search;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
 * The n-queens puzzle is the problem of placing n queens on an nxn chessboard such that no two queens attack each other.
 * Given an integer n, return all distinct solutions to the n-queens puzzle.
 * Each solution contains a distinct board configuration of the n-queens' placement, 
 * where 'Q' and '.' both indicate a queen and an empty space respectively.
 * For example, There exist two distinct solutions to the 4-queens puzzle:
[
 [".Q..",  // Solution 1
  "...Q",
  "Q...",
  "..Q."],

 ["..Q.",  // Solution 2
  "Q...",
  "...Q",
  ".Q.."]
]
 */
public class NQueens {
    public List<String[]> solveNQueens(int n) {
    	sols = new ArrayList<int[]>(); 
    	int[] sol = new int[n]; 
    	solve(n, 0, sol); 
    	return convert(sols, n); 
    }
    List<int[]> sols; 
    public void solve(int n, int k, int[] sol){
    	if (k==n) { 
    		sols.add(Arrays.copyOf(sol, sol.length)); 
    		return; 
    	}
    	for (int i=0; i<n; i++){
    		sol[k]=i; 
    		if (isValid(sol, k))
    			solve(n, k+1, sol); 
    	}
    }
    public boolean isValid(int[] sol, int k){
    	for (int i=0; i<k; i++){
    		if (sol[i]==sol[k]) return false; 
    		if (sol[i]==sol[k]+k-i) return false; 
    		if (sol[i]==sol[k]-k+i) return false; 
    	} 
    	return true; 
    }
    public ArrayList<String[]> convert(List<int[]> sols, int n){
    	ArrayList<String[]> ret = new ArrayList<String[]>(); 
    	char[] row = new char[n]; 
    	for (int i=0; i<n; i++) row[i]='.';
    	for (int[] sol:sols){
    		String[] b = new String[n]; 
    		for (int i=0; i<n; i++){
    			row[sol[i]] = 'Q'; 
    			b[i] = new String(row); 
    			row[sol[i]] = '.'; 
    		}
    		ret.add(b); 
    	}
    	return ret; 
    }
    
	public void print(String[] board){
		for (String b:board) System.out.println(b); 
	}

    public static void main(String[] args){
    	NQueens nq = new NQueens(); 
    	List<String[]> ret = nq.solveNQueens(5); 
    	for (String[] b:ret) {
    		nq.print(b); 
    		System.out.println(); 
    	}
    }
}
