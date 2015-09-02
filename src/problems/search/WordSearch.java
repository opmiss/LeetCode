package problems.search;

/*
 * Given a 2D board and a word, find if the word exists in the grid.
 * The word can be constructed from letters of sequentially adjacent cell, 
 * where "adjacent" cells are those horizontally or vertically neighboring. 
 * The same letter cell may not be used more than once.
 * 
 * For example, given board =
 * [
 *  ["ABCE"],
 *  ["SFCS"],
 *  ["ADEE"]
 * ]
 * word = "ABCCED", -> returns true,
 * word = "SEE", -> returns true,
 * word = "ABCB", -> returns false. 
 * */
public class WordSearch {
	
    int h, w; 
    int l; 
    char[][] board; 
    public boolean exist(char[][] board, String word) {
        l = word.length(); 
        h = board.length; 
        if (h==0) if (l==0) return true; else return false; 
        w = board[0].length; 
        if (w==0) if (l==0) return true; else return false;
        if (l==0) return true; 
        this.board = board; 
        for (int i=0; i<h; i++){
            for (int j=0; j<w; j++){
                if (board[i][j]==word.charAt(0)) if (found(i, j, word.substring(1))) return true; 
            }
        }
        return false; 
    }
    //Depth first search
    public boolean found(int i, int j, String word){
        if (word.length()==0) return true;
        char ch = board[i][j]; 
        if (i>0 && board[i-1][j] == word.charAt(0)){
            board[i][j] = '#'; 
            if (found(i-1, j, word.substring(1))) return true; 
            board[i][j]=ch; 
        }
        if (i<h-1 && board[i+1][j] == word.charAt(0)){
            board[i][j] = '#'; 
            if (found(i+1, j, word.substring(1))) return true; 
            board[i][j]=ch; 
        }
        if (j>0 && board[i][j-1] == word.charAt(0)){
            board[i][j] = '#'; 
            if (found(i, j-1, word.substring(1))) return true; 
            board[i][j]=ch; 
        }
        if (j<w-1 && board[i][j+1] == word.charAt(0)){
            board[i][j] = '#'; 
            if (found(i, j+1, word.substring(1))) return true; 
            board[i][j]=ch; 
        }
        return false; 
    }
}
