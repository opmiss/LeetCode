/**
 * @param {number[][]} obstacleGrid
 * @return {number}
 */
var uniquePathsWithObstacles = function(obstacleGrid) {
	var m = obstacleGrid.length;
	if (m<1) return 0;
	var n = obstacleGrid[0].length;
	if (n<1) return 0;
	var dp = [1-obstacleGrid[0][0]];
	for (var j=1; j<n; j++){
		if (obstacleGrid[0][j]>0) dp[j] = 0;
		else dp[j]=dp[j-1];
	}
	for (var i=1; i<m; i++){
		for (var j=0; j<n; j++){
			if (obstacleGrid[i][j]>0) dp[j] =0;
			else dp[j] = (j>0)?(dp[j-1]+dp[j]):dp[j];
		}
	}
	return dp[n-1];
};