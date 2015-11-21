/**
 * @param {number} n
 * @return {number[][]}
 */
var generateMatrix = function(n) {
	var res = [];
	for (var i=0; i<n; i++) res.push([]);
	var left = 0, right = n-1, k=1;
	while (left<right){
		for (i=left; i<right; i++){
			res[left][i] = k++;
		}
		for (i=left; i<right; i++){
			res[i][right] = k++;
		}
		for (i=right; i>left; i--){
			res[right][i] = k++;
		}
		for (i=right; i>left; i--){
			res[i][left] = k++;
		}
		left++; right--;
	}
	if (left===right) {
		res[left][left] = k;
	}
	return res;
};