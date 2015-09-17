package Java;

public class P289_GameLife {
	int m, n; 
    int[][] board; 
    int[][] offset = new int[][]{{-1, 0}, {1, 0}, {0, -1}, {0, 1}, {-1, -1}, {-1, 1}, {1, -1}, {1, 1}};  
    public void gameOfLife(int[][] board) {
        m = board.length; 
        if (m==0) return; 
        n = board[0].length; 
        if (n==0) return;
        this.board = board; 
        for (int x=0; x<m; x++){
            for (int y=0; y<n; y++){
                int num = numOfLives(x, y);
                if (board[x][y]==0 && num==3) board[x][y] = 2; 
                if (board[x][y]==1 && (num>3||num<2)) board[x][y] = 3;  
            }
        }
        for (int x=0; x<m; x++){
            for (int y=0; y<n; y++){
                if (board[x][y]==2) board[x][y] = 1; 
                else if (board[x][y]==3) board[x][y] = 0;  
            }
        }
    }
    public boolean isLive(int x, int y){
        if (x<0||y<0||x>=m||y>=n) return false; 
        return (board[x][y]%2==1); 
    }
    public int numOfLives(int x, int y){
        int num=0; 
        for (int i=0; i<8; i++){
            if (isLive(x+offset[i][0], y+offset[i][1])) num++; 
        }
        return num; 
    }

}
