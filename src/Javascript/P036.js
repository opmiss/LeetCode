/**
 * @param {character[][]} board
 * @return {boolean}
 */
var isValidSudoku = function(board) {
	for (var i=0; i<9; i++){
		var row = {};
		var col = {};
		var block = {};
		for (var j=0; j<9; j++){
			if (board[i][j]!=='.'){
				if (typeof row[board[i][j]]!=="undefined") return false;
				row[board[i][j]] = true;
			}
			if (board[j][i]!=='.'){
				if (typeof col[board[j][i]]!=="undefined") return false;
				col[board[j][i]] = true;
			}
			var r = Math.floor(i/3)*3+Math.floor(j/3);
			var c = i%3*3+j%3;
			if (board[r][c]!=='.'){
				if (typeof block[board[r][c]]!=="undefined") return false;
				block[board[r][c]] = true;
			}
		}
	}
	return true;
};