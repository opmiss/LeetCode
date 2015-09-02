package problems.search;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInput;
import java.io.ObjectInputStream;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;

/*
 * Write a program to solve a Sudoku puzzle by filling the empty cells.
 * Empty cells are indicated by the character '.'.
 * You may assume that there will be only one unique solution.
 */

public class Sudoku {
	
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
		 if (k>=list.size()){
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
	 
	 public void print(char[][] board){
		 StringBuffer sb = new StringBuffer(); 
		 for (int i=0; i<9; i++){
			 for (int j=0; j<9; j++){
				 sb.append(board[i][j]); 
				 if (j<8) sb.append(','); 
			 }
			 if (i<8) sb.append('\n'); 
		 }
		 System.out.println(sb.toString()); 
	 }
	 
	 public char[][] generateSudoku(){
		 //generate random permutation for 1-9
		 Integer[] p = permute(9);
		 char[] a = new char[9]; 
		 for (int i=0; i<9; i++) a[i] = Character.forDigit(p[i], 10); 
		 char[][] A = new char[9][9];
		 for (int i=0; i<9; i++) 
			 for (int k=0; k<3; k++) 
				 for (int v=0; v<3; v++) 
					 A[i][k+v*3] = a[(i+k*3+v)%9]; 
		 
		 Integer[] o = permute(9);
		 for (int i=0; i<9; i++){
			 A[o[i]-1][i] = '.'; 
			 A[i][p[i]-1] = '.'; 
		 }
		 print(A); 
		 return A; 
	 }
	 
	 public Integer[] permute(int n){
		 Integer[] p = new Integer[n]; 
		 for (int i=0; i<n; i++) p[i] = i+1; 
		 randomPermute(p); 
		 StringBuffer sb = new StringBuffer(); 
		 for (int i=0; i<n; i++) sb.append(p[i]);
		 sb.append('\n');
		// System.out.println(sb.toString());
		 return p; 
	 }
	 
	 public void randomPermute(Object[] in){
		 for (int i=1; i<in.length; i++){
			 int j = (int)Math.floor(Math.random()*in.length); 
			 Object t = in[i];
			 in[i] = in[j]; 
			 in[j] = t; 
		 }
	 }
	 
	 public static void main(String[] args){
		 Sudoku s = new Sudoku(); 
		 //s.permute(9);
		/* char[][] A=s.generateSudoku(); 
		 
		 try (
				 OutputStream file = new FileOutputStream("board.ser");
			     OutputStream buffer = new BufferedOutputStream(file);
			     ObjectOutput output = new ObjectOutputStream(buffer);
			){
			 output.writeObject(A);
			 }  
		 catch(IOException ex){
			 ex.printStackTrace();
		 }*/
		 char[][] A=null; 
		 try(
				 InputStream file = new FileInputStream("board.ser");
			     InputStream buffer = new BufferedInputStream(file);
			     ObjectInput input = new ObjectInputStream (buffer);
				 ){
			      //deserialize the List
			      A = (char[][]) input.readObject();
			      s.print(A);
			      }
			    catch(Exception e){
			      e.printStackTrace();
			    }
		 
		 if (A!=null){
		 s.solveSudoku(A);
		 System.out.println("after solve: "); 
		 s.print(A);
		 }
	 }
	 
}
