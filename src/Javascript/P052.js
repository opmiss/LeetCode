/**
 * @param {number} n
 * @return {number}
 */
var totalNQueens = function(n) {
	var res = 0;
	var solve = function(i, sol){
		if (i>=n) {
			res++;
			return;
		}
		for (var p=0; p<n; p++){
			if (isValid(p, sol)){
				sol.push(p);
				solve(i+1, sol);
				sol.pop();
			}
		}
	};
	var isValid = function(p, sol){
		for (var k=0; k<sol.length; k++){
			if (p===sol[k]) return false;
			var d = sol.length-k;
			if (p===(sol[k]+d)||(p+d)===sol[k]) return false;
		}
		return true;
	};
	solve(0, []);
	return res;
};