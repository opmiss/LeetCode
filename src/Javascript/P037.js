/**
 * @param {character[][]} board
 * @return {void} Do not return anything, modify board in-place instead.
 */
var isValid = function(board, r, c, e) {
	for (var i=0; i<9; i++){
		if (board[r][i]===e) return false;
		if (board[i][c]===e) return false;
		if (board[Math.floor(r/3)*3+Math.floor(i/3)][Math.floor(c/3)*3+i%3]===e) return false;
	}
	board[r][c]=e;
	return true;
};

var solveSudoku = function(board) {
	var pos = [];
	board.forEach(function(r, i){
        r.forEach(function(c, j){
									if (c==='.') pos.push([i, j]);
									});
								});
	var solve = function(s){
		if (s>=pos.length) return true;
		var r = pos[s][0];
		var c = pos[s][1];
		for (var ch=49; ch<=57; ch++){
			var e = String.fromCharCode(ch);
			if (isValid(board, r, c, e) && solve(s+1)) return true;
		}
		board[r][c]='.';
		return false;
	};
	solve(0);
};