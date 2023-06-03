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
                    removeConnectedIsland(grid, i, j);
                    ans++;
                }
            }
        }
        return ans;
    }
    
    private void removeConnectedIsland(char[][] grid, int r, int c) {
        if (r < 0 || r >= row || c < 0 || c >= col || grid[r][c] == '0') return;
        grid[r][c] = '0';
        removeConnectedIsland(grid, r+1, c);
        removeConnectedIsland(grid, r, c+1);
        removeConnectedIsland(grid, r, c-1);
        removeConnectedIsland(grid, r-1, c);
    }
    
}