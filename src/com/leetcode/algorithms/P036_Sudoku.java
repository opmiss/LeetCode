package com.leetcode.algorithms;
import java.util.*;

public class P036_Sudoku {
	boolean[] digit; 
    public boolean isValidSudoku(char[][] board) {
        digit = new boolean[9]; 
        for (int i=0; i<9; i++){
            for (int k=0; k<9; k++) digit[k] = false; 
            for (int j=0; j<9; j++) {
                char c = board[i][j];  
                if (c!='.' && digit[Character.digit(c, 10)-1]) return false; 
                else if (c!='.') digit[Character.digit(c, 10)-1] = true; 
            }
        }
        for (int i=0; i<9; i++){
            for (int k=0; k<9; k++) digit[k] = false; 
            for (int j=0; j<9; j++) {
                char c = board[j][i];  
                if (c!='.' && digit[Character.digit(c, 10)-1]) return false; 
                else if (c!='.') digit[Character.digit(c, 10)-1] = true; 
            }
        }
        for (int i=0; i<9; i+=3){
            for (int j=0; j<9; j+=3){
                for (int k=0; k<9; k++) digit[k] = false; 
                for (int oi=0; oi<3; oi++){
                    for (int oj=0; oj<3; oj++){
                        char c = board[i+oi][j+oj];  
                        if (c!='.' && digit[Character.digit(c, 10)-1]) return false; 
                        else if (c!='.') digit[Character.digit(c, 10)-1] = true; 
                    }
                }
            }    
        }
        return true; 
    }
    public void solveSudoku(char[][] board) {
		 List<int[]> pos = new ArrayList<int[]>(); 
		 for (int i=0; i<9; i++){
			 for (int j=0; j<9; j++){
				 if (board[i][j]=='.'){ 
					 int[] p = new int[2]; 
					 p[0]=i; p[1]=j; 
					 pos.add(p); 
				 }
			 }
		 }
		 num=0; 
		 solve(board, pos, 0); 
	 }
	 
	 int num; 
	 public void solve(char[][] board, List<int[]> list, int k){
		 if (k==list.size()){
			 num++;return; 
		 }
		 int[] p = list.get(k); 
		 for (int i=1; i<=9; i++){
			 char c = Character.forDigit(i, 10); 
			 if (isValid(board, p[0], p[1], c)){
				 board[p[0]][p[1]] = c; 
				 solve(board, list, k+1); 
				 if (num==0) board[p[0]][p[1]]='.'; 
			 }
		 }
	 }
	 
	 public boolean isValid(char[][] board, int r, int c, char x){
	     int rr = (r/3)*3, cc = (c/3)*3; 
		 for (int i=0; i<9; i++){
			 if (board[r][i]==x) return false; 
			 if (board[i][c]==x) return false;
			 if (board[rr+i/3][cc+i%3] ==x) return false; 
		 }
		 return true; 
	 }
}
