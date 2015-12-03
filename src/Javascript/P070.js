/**
 * @param {number} n
 * @return {number}
 */
var climbStairs = function(n) {
	var f = [1, 1, 2];
	var climb=function(n) {
		if (typeof f[n]!=="undefined") return f[n];
		f[n] = climb(n-1)+climb(n-2);
		return f[n];
	}
	return climb(n);
};