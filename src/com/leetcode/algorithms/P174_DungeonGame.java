package com.leetcode.algorithms;

public class P174_DungeonGame {
	public int max(int a, int b){
		 return a>b?a:b; 
	 }
	 public int min(int a, int b){
		 return a>b?b:a; 
	 }
	 public int calculateMinimumHP(int[][] dungeon) {
		 int n = dungeon.length; 
		 int m = dungeon[0].length; 
		 
		 int[][] hp = new int[n][m]; 
		 
		 for (int i = n-1; i>=0; i--){
			 for (int j= m-1; j>=0; j--){
				if (i==n-1 && j==m-1){
					hp[i][j] = max(1-dungeon[i][j], 1); 
				}
				else if (i==n-1){
					hp[i][j] = max(hp[i][j+1]-dungeon[i][j], 1); 
				}
				else if (j==m-1){
					hp[i][j] = max(hp[i+1][j]-dungeon[i][j], 1); 
				}
				else {
					hp[i][j] = max(min(hp[i+1][j], hp[i][j+1])-dungeon[i][j], 1); 
				}
			 }
		 }
		 return hp[0][0]; 
	 }
}
