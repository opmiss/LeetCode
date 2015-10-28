/**
 * @param {number[][]} matrix
 * @return {void} Do not return anything, modify matrix in-place instead.
 */
var rotate = function(matrix) {
	var start = 0, end = matrix.length-1, n = end, i;
	while (start<end){
		for (i=start; i<end; i++){
			var t = matrix[start][i];
			matrix[start][i] = matrix[n-i][start];
			matrix[n-i][start] = matrix[end][n-i];
			matrix[end][n-i] = matrix[i][end];
			matrix[i][end] = t;
		}
		start++;
		end--;
	}
};