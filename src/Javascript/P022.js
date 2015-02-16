/**
 * @param {number} n
 * @return {string[]}
 */
var generateParenthesis = function(n) {
	if (n===0) return [""];
	if (n===1) return ["()"];
	var res = [];
	for (var i=0; i<n; i++){
		var inner = generateParenthesis(i);
		var outter = generateParenthesis(n-i-1);
		inner.forEach(function(i){
									outter.forEach(function(o){
																 res.push('('+i+')'+o);
																 });
									});
	}
	return res;
};