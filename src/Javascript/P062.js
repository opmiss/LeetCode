/**
 * @param {number} m
 * @param {number} n
 * @return {number}
 */
var uniquePaths = function(m, n) {
	if (m<1||n<1) return 0;
	if (m<2||n<2) return 1;
	var dp = [];
	for (var j=0; j<n; j++) dp[j] = 1;
	for (var i=1; i<m; i++){
		for (var j=1; j<n; j++){
			dp[j]+=dp[j-1];
		}
	}
	return dp[n-1];
};