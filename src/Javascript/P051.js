/**
 * @param {number} n
 * @return {string[][]}
 */
var solveNQueens = function(n) {
	var sols = [];
	var solve = function(i, sol){
		if (i>=n) {
			sols.push(sol.slice());
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
	var convert = function(sol){
		var board = [];
		sol.forEach(function(p){
								var row = [];
								for (var k=0; k<n; k++){
								if (k===p) row.push('Q');
								else row.push('.');
								}
								board.push(row.join(''));
        });
		return board;
	};
	var res = [];
	solve(0, []);
	sols.forEach(function(sol){
        res.push(convert(sol));
							 });
	return res;
};