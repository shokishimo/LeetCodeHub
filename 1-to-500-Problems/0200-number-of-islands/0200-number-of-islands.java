class Solution {
    public int numIslands(char[][] grid) {
        int ans = 0;
        int row = grid.length;
        int col = grid[0].length;
        
        for (int i = 0; i < row; i++)
        {
            for (int j = 0; j < col; j++)
            {
                if (grid[i][j] == '1') {
                    ans++;
                    
                    removeConnectedIsland(grid, i, j);
                }
            }
        }
        return ans;
    }
    
    public static void removeConnectedIsland(char[][] grid, int i, int j)
    {
        grid[i][j] = '0';
        if (i != grid.length-1 && grid[i+1][j] == '1') {
            removeConnectedIsland(grid, i+1, j);
        }
        if (j != grid[i].length-1 && grid[i][j+1] == '1') {
            removeConnectedIsland(grid, i, j+1);
        }
        if (j != 0 && grid[i][j-1] == '1') {
            removeConnectedIsland(grid, i, j-1);
        }
        if (i != 0 && grid[i-1][j] == '1') {
            removeConnectedIsland(grid, i-1, j);
        }
    }
    
}