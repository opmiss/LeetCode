/**
 * @constructor
 * @param {number[][]} matrix
 */
var NumMatrix = function(matrix) {
	this.sum = [[0]];
	if (matrix.length<1) return;
	for (var c=0; c<matrix[0].length; c++){
		this.sum[0].push(0);
	}
	for (var r=0; r<matrix.length; r++){
		this.sum.push([0]);
		for (var i=0; i<matrix[r].length; i++){
			this.sum[r+1][i+1] = matrix[r][i]+this.sum[r+1][i]+this.sum[r][i+1]-this.sum[r][i];
		}
	}
	console.log(this.sum); 
};

/**
 * @param {number} row1
 * @param {number} col1
 * @param {number} row2
 * @param {number} col2
 * @return {number}
 */
NumMatrix.prototype.sumRegion = function(row1, col1, row2, col2) {
	return this.sum[row2+1][col2+1]-this.sum[row2+1][col1]-this.sum[row1][col2+1]+this.sum[row1][col1];
};


/**
 * Your NumMatrix object will be instantiated and called as such:
 */
var numMatrix = new NumMatrix([[3, 0, 1, 4, 2], [5, 6, 3, 2, 1], [1, 2, 0, 1, 5], [4, 1, 0, 1, 7], [1, 0, 3, 0, 5]]);
console.log(numMatrix.sumRegion(2, 1, 4, 3));
console.log(numMatrix.sumRegion(1, 1, 2, 2));
