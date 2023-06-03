class Solution {
    int row;
    int col;
    public int numIslands(char[][] grid) {
        int ans = 0;
        row = grid.length;
        col = grid[0].length;
        
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (grid[i][j] == '1') {
                    ans++;
                    removeConnectedIsland(grid, i, j);
                }
            }
        }
        return ans;
    }
    
    private void removeConnectedIsland(char[][] grid, int r, int c) {
        grid[r][c] = '0';
        if (r < row-1 && grid[r+1][c] == '1') {
            removeConnectedIsland(grid, r+1, c);
        }
        if (c < col-1 && grid[r][c+1] == '1') {
            removeConnectedIsland(grid, r, c+1);
        }
        if (c > 0 && grid[r][c-1] == '1') {
            removeConnectedIsland(grid, r, c-1);
        }
        if (r > 0 && grid[r-1][c] == '1') {
            removeConnectedIsland(grid, r-1, c);
        }
    }
    
}