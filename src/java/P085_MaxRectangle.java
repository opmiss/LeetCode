package java;
import java.util.*;

public class P085_MaxRectangle {
	
	/*Given a 2D binary matrix filled with 0's and 1's, find the largest rectangle containing all ones and return its area.*/
	  public int maximalRectangle(char[][] matrix) {
	        int h = matrix.length; 
	        if (h==0) return 0; 
	        int w = matrix[0].length; 
	        int maxArea = 0; 
	        int[] height = new int[w]; 
	        for (int i=0; i<h; i++){
	            for (int j=0; j<w; j++){
	                height[j] = 0; 
	                for (int k=i; k<h; k++){
	                    if (matrix[k][j]=='1') height[j]++; 
	                    else break; 
	                }
	            }
	            maxArea = Math.max(maxArea, largestArea(height)); 
	        }
	        return maxArea; 
	    }
	    
	    public int largestArea(int[] height) {
	        int max =0; 
	        Stack<Integer> stack = new Stack<Integer>(); 
	        for (int i=0; i<=height.length; i++){
	            int hi= (i==height.length)? 0:height[i];
	            if (stack.isEmpty() || hi > height[stack.peek()]) stack.push(i);
	            else {
	                int id = stack.pop(); 
	                int top = height[id]; 
	                max = Math.max(max, top*(stack.isEmpty()?i: i-1-stack.peek())); 
	                i--; 
	            }
	        }
	        return max; 
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

}
