package java;

public class P200_NumberofIslands {
	public int numIslands(char[][] grid) {
        int count = 0; 
        for (int i=0; i<grid.length; i++){
            for (int j=0; j<grid[0].length; j++){
                if (isIsland(grid, i, j)) 
                    count++; 
            }
        }
        return count; 
    }
    public boolean isIsland(char[][] grid, int r, int c){
        if (grid[r][c]=='0') return false; 
        else {
            visitIsland(grid, r, c); 
            return true; 
        }
    }
    public void visitIsland(char[][]grid, int r, int c){
        if (r>=grid.length||r<0||c>=grid[0].length||c<0)
            return; 
        if (grid[r][c]=='1'){
            grid[r][c]='0'; 
            visitIsland(grid, r+1, c); 
            visitIsland(grid, r-1, c); 
            visitIsland(grid, r, c+1); 
            visitIsland(grid, r, c-1); 
        }
        else return; 
    }

}
