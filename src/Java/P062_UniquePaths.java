package Java;

public class P062_UniquePaths {
	/* A robot is located at the top-left corner of a m x n grid 
	 * (marked 'Start' in the diagram below).
	 * The robot can only move either down or right at any point in time. 
	 * The robot is trying to reach the bottom-right corner of the grid 
	 * (marked 'Finish' in the diagram below).
	 * How many possible unique paths are there?
	 * 
	 * Note: m and n will be at most 100.
	 */
    public int uniquePaths(int m, int n) {
    	int[][] path = new int[m+1][n+1]; 
        for (int i=0; i<=m; i++) path[i][0] = 0;
        for (int j=0; j<=n; j++) path[0][j] = 0;
        for (int i=1; i<=m; i++){
            for (int j=1; j<=n; j++){
                if (i==1 && j==1) path[i][j]=1; 
                else path[i][j] = path[i-1][j] + path[i][j-1]; 
            }
        }
        return path[m][n];  
    }
    
    /*
     * Follow up for "Unique Paths":
     * Now consider if some obstacles are added to the grids. 
     * How many unique paths would there be?
     * An obstacle and empty space is marked as 1 and 0 respectively in the grid.
     * For example,
     * There is one obstacle in the middle of a 3x3 grid as illustrated below.
     * [
     * 	[0,0,0],
     * 	[0,1,0],
     * 	[0,0,0]
     * ]
     * The total number of unique paths is 2.
     */
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
    	 int m=obstacleGrid.length; 
         if (m<1) return 0; 
         int n = obstacleGrid[0].length; 
         if (n<1) return 0; 
         if (obstacleGrid[0][0]==1) return 0; 
         int[][] p = new int[m+1][n+1];
         for (int i=0; i<=m; i++) p[i][0]=0; 
         for (int j=0; j<=n; j++) p[0][j]=0; 
         for (int i=1; i<=m; i++){
             for (int j=1; j<=n; j++){
                 if (i==1&&j==1) p[i][j]=1; 
                 else if (obstacleGrid[i-1][j-1]==1) p[i][j]=0; 
                 else p[i][j] = p[i-1][j]+p[i][j-1]; 
             }
         }
         return p[m][n]; 
    }

}
