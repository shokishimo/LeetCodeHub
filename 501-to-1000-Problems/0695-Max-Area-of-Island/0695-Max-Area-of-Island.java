class Solution {
  int row;
  int col;
  public int maxAreaOfIsland(int[][] grid) {
      int ans = 0;
      row = grid.length;
      col = grid[0].length;
      for (int i = 0; i < row; i++) {
          for (int j = 0; j < col; j++) {
              if (grid[i][j] == 1) {
                  int res = dfs(grid, i, j);
                  ans = Math.max(ans, res);
              }
          }
      }
      return ans;
  }

  private int dfs(int[][] grid, int r, int c) {
      if (r < 0 || r >= row || c < 0 || c >= col || grid[r][c] != 1) return 0;
      grid[r][c] = 0;
      int up = dfs(grid, r+1, c);
      int down = dfs(grid, r-1, c);
      int right = dfs(grid, r, c+1);
      int left = dfs(grid, r, c-1);

      return 1 + up + down + right + left;
  }
}