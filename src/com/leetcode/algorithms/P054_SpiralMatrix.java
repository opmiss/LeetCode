package com.leetcode.algorithms;
import java.util.*;

public class P054_SpiralMatrix {
	
	public List<Integer> spiralOrder(int[][] matrix) {
		// output elements of a mxn matrix in spiral order
		List<Integer> res = new ArrayList<Integer>(); 
		int m = matrix.length;
		if (m==0) return res; 
		int n = matrix[0].length; 
		int tag = 0; //0:right, 1:down, 2:left, 3:up
		int left = 0, right = n-1, top=0, bottom=m-1; 
		while (left<=right&&top<=bottom){
			if (tag==0){
				for (int k=left; k<=right; k++){
					res.add(matrix[top][k]); 
				}
				top++; tag=1; 
			}
			else if (tag==1){
				for (int k=top; k<=bottom; k++){
					res.add(matrix[k][right]); 
				}
				right--; tag=2; 
			}
			else if (tag==2){
				for (int k=right; k>=left; k--){
					res.add(matrix[bottom][k]); 
				}
				bottom--; tag=3; 
			}
			else {
				for (int k=bottom; k>=top; k--){
					res.add(matrix[k][left]); 
				}
				left++; tag=0; 
			}
		}
		return res;
	}

	public int[][] generateMatrix(int n) {
		// generate a square matrix filled with 1 to nxn in spiral order
		int[][] matrix = new int[n][n]; 
		int tag = 0; //0:right, 1:down, 2:left, 3:up
		int left = 0, right = n-1, top=0, bottom=n-1;
		int num=1; 
		while (left<=right){
			if (tag==0){
				for (int k=left; k<=right; k++){
					matrix[top][k]=num++; 
				}
				top++; tag=1; 
			}
			else if (tag==1){
				for (int k=top; k<=bottom; k++){
					matrix[k][right]=num++; 
				}
				right--; tag=2; 
			}
			else if (tag==2){
				for (int k=right; k>=left; k--){
					matrix[bottom][k]=num++; 
				}
				bottom--; tag=3; 
			}
			else {
				for (int k=bottom; k>=top; k--){
					matrix[k][left]=num++; 
				}
				left++; tag=0; 
			}
		}
		return matrix;
	}

}
