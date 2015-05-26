package com.leetcode.algorithms;
import com.leetcode.problems.tree.*;
import java.util.*;

public class P212_WordSearch2 {
	Set<String> sols; 
    int nrows; 
    int ncols; 
    char[][] board; 
    boolean[][] visited; 
    TrieNode root; 
    public List<String> findWords(char[][] board, String[] words) {
        this.sols = new HashSet<String>(); 
        this.nrows = board.length; 
        this.ncols = board[0].length; 
        this.board = board;
        this.visited = new boolean[nrows][ncols]; 
        root = new TrieNode(); 
        for (String w:words) root.insert(w);
        for (int r = 0; r<nrows; r++){
            for (int c=0; c<ncols; c++){
                visit(root, "", r, c); 
            }
        }
        List<String> ret = new ArrayList<String>(); 
        ret.addAll(sols); 
        return ret; 
    }
    public void visit(TrieNode node, String word, int row, int col){
        if (node.endhere) {
            sols.add(word);
        }
        if (row<0||row>=nrows||col<0||col>=ncols||visited[row][col]) return; 
        if (node.child==null) return; 
        int id = (int)board[row][col]-'a'; 
        if (node.child[id]==null) return; 
        String nword = word+board[row][col]; 
        visited[row][col] = true; 
        visit(node.child[id], nword, row+1, col); 
        visit(node.child[id], nword, row, col+1);
        visit(node.child[id], nword, row-1, col); 
        visit(node.child[id], nword, row, col-1);
        visited[row][col] = false; 
    }

}
