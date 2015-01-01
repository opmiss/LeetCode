/**
 * @param {number[][]} matrix
 * @return {number[]}
 */
var spiralOrder = function(matrix) {
	var res = [];
	var bot = matrix.length;
	if (bot<1) return res;
	var right = matrix[0].length;
	var up=0, left = 0, i, j;
	while (up<bot&&left<right){
		for (i=up, j=left; j<right; j++){
			res.push(matrix[i][j]);
		}
		if (up+1>=bot) break;
		for (j=right-1, i=up+1; i<bot; i++){
			res.push(matrix[i][j]);
		}
		if (right-2<left) break;
		for (i=bot-1, j=right-2; j>=left; j--){
			res.push(matrix[i][j]);
		}
		for (i=bot-2, j=left; i>up; i--){
			res.push(matrix[i][j]);
		}
		up++;
		left++;
		bot--;
		right--;
	}
	return res;
};