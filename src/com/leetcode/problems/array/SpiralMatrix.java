package com.leetcode.problems.array;

import java.util.ArrayList;

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

public class SpiralMatrix {
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
}
