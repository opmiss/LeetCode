package com.leetcode.algorithms;

public class P240_Search2DMatrix {
	/* Write an efficient algorithm that searches for a value in an m x n matrix. 
	 * This matrix has the following properties:
	 * Integers in each row are sorted in ascending from left to right.
	 * Integers in each column are sorted in ascending from top to bottom.
	 */
	public boolean searchMatrix2(int[][] matrix, int target) {
        int cur = 0; 
        int last = matrix[0].length-1; 
        while (cur<matrix.length){
            if (matrix[cur][0] > target) return false; 
            if (matrix[cur][0]== target || matrix[cur][last] == target) return true;
            if (matrix[cur][last]>target && searchRow(matrix[cur], target)) return true; 
            cur++; 
        }
        return false; 
    }
    public boolean searchRow(int[] row, int target){
        int start = 0, end = row.length, mid; 
        while (start<end-1){
            mid = (start+end)/2; 
            if (row[mid]<target) start = mid; 
            else if (row[mid]>target) end = mid; 
            else return true; 
        }
        return false; 
    }
    /* Write an efficient algorithm that searches for a value in an m x n matrix. 
     * This matrix has the following properties:
     * Integers in each row are sorted from left to right.
     * The first integer of each row is greater than the last integer of the previous row.
     */
	public boolean searchMatrix(int[][] matrix, int target) {
        int cur = 0; 
        int last = matrix[0].length-1; 
        while (cur<matrix.length){
            if (matrix[cur][0] > target) return false; 
            if (matrix[cur][0]== target || matrix[cur][last] == target) return true;
            if (matrix[cur][last]>target && searchRow(matrix[cur], target)) return true; 
            cur++; 
        }
        return false; 
    }
}
