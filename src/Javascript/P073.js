/**
 * @param {number[][]} matrix
 * @return {void} Do not return anything, modify matrix in-place instead.
 */
var setZeroes = function(matrix) {
	if (matrix.length<1) return;
	if (matrix[0].length<1) return;
	var row0=false, col0=false;
	for (var i=0; i<matrix.length; i++){
		for (var j=0; j<matrix[0].length; j++){
			if (matrix[i][j]===0) {
				matrix[i][0]=0;
				matrix[0][j]=0;
				if (i===0) row0=true;
				if (j===0) col0=true;
			}
		}
	}
	for (i=1; i<matrix.length; i++){
		for (j=1; j<matrix[0].length; j++){
			if (matrix[i][0]===0||matrix[0][j]===0) matrix[i][j]=0;
		}
	}
	if (row0) for (j=0; j<matrix[0].length; j++) matrix[0][j]=0;
	if (col0) for (i=0; i<matrix.length; i++) matrix[i][0]=0;
};