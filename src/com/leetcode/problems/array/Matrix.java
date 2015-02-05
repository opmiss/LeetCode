package com.leetcode.problems.array;

import java.util.ArrayList;

public class Matrix {
	/*
	 * Given a matrix of m x n elements (m rows, n columns), return all elements of the matrix in spiral order.
	 * For example, given the following matrix:
	 * [
	 * 	[ 1, 2, 3 ],
	 * 	[ 4, 5, 6 ],
	 * 	[ 7, 8, 9 ]
	 * ]
	 * You should return [1,2,3,6,9,8,7,4,5].
	 * */
	public ArrayList<Integer> spiralOrder(int[][] matrix) {
		ArrayList<Integer> ret = new ArrayList<Integer>();
		int rn = matrix.length;
		if (rn == 0)
			return ret;
		int cn = matrix[0].length;
		if (cn == 0)
			return ret;
		int rs = 0, re = rn - 1, cs = 0, ce = cn - 1;
		while (rs <= re && cs <= ce) {
			ret.addAll(peel(matrix, rs, re, cs, ce));
			rs++;
			re--;
			cs++;
			ce--;
		}
		return ret;
	}

	public ArrayList<Integer> peel(int[][] matrix, int rs, int re, int cs,
			int ce) {
		ArrayList<Integer> ret = new ArrayList<Integer>();
		if (rs == re) {
			for (int c = cs; c <= ce; c++)
				ret.add(matrix[rs][c]);
			return ret;
		}
		if (cs == ce) {
			for (int r = rs; r <= re; r++)
				ret.add(matrix[r][cs]);
			return ret;
		}
		for (int c = cs; c < ce; c++) {
			ret.add(matrix[rs][c]);
		}
		for (int r = rs; r < re; r++) {
			ret.add(matrix[r][ce]);
		}
		for (int c = ce; c > cs; c--) {
			ret.add(matrix[re][c]);
		}
		for (int r = re; r > rs; r--) {
			ret.add(matrix[r][cs]);
		}
		return ret;
	}
	
	/* In a square matrix, where each cell is black or white. 
	 * Design an algorithm to find the max sub-square such that all 4 borders are black
	 */
	
	
	public int maxSubsquare(boolean[][] M){
		int n = M.length; 
		maxsize=0; 
		checkDiag(M, 0, 0, n); 
		for (int i=1; i<n; i++){
			checkDiag(M, i, 0, n); 
			checkDiag(M, 0, i, n); 
		}
		return maxsize; 
	}
	int maxsize; 
	void checkDiag(boolean[][] M, int i, int j, int n){
		if (i>=n-maxsize || j>=n-maxsize) return; 
		int step = 0; 
		while (step<(n-Math.max(i, j))&& M[i][j+step]&&M[i+step][j]){
			int s = step; 
			while (s>0){
				if (M[i+s][j+step]&&M[i+step][j+s]) s--; 
				else break; 
			}
			if (s==0) 
				maxsize = Math.max(maxsize, step+1); 
			step++; 
		}
		if (step==0) checkDiag(M, i+step+1, j+step+1, n); 
		else checkDiag(M, i+step, j+step, n); 
	}
	public void test(){
		boolean[][] M = new boolean[][]{
			{true, true, true, true}, 
			{true, true, true, true}, 
			{true, false, true, true}, 
			{true, true, true, true}, 
		}; 
		System.out.println(maxSubsquare(M)); 
	}
	public static void main(String[] args){
		Matrix m = new Matrix(); 
		//m.test(); 
		String num = "0.01"; 
		//int i = Integer.parseInt(num); 
		float f = Float.parseFloat(num); 
		
		System.out.println(Integer.toBinaryString(Float.floatToIntBits(f))); 
	}
}
