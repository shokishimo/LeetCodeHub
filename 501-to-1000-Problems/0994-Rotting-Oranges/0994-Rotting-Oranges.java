class Solution {
  int row;
  int col;

  public int orangesRotting(int[][] grid) {
      row = grid.length;
      col = grid[0].length;
      Deque<int[]> que = new ArrayDeque<>();
      int rotten = 0;
      int fresh = 0;

      for (int r = 0; r < row; r ++) {
          for (int c = 0; c < col; c++) {
              if (grid[r][c] == 2) {
                  que.add(new int[] {r, c});
                  rotten++;
              } else if (grid[r][c] == 1) fresh++;
          }
      }
      if (rotten == 0 && fresh == 0) return 0;
      if (rotten == 0) return -1;

      // Run bfs
      int time = -1;
      int r;
      int c;
      while(!que.isEmpty()) {
          int size = que.size();
          for (int i = 0; i < size; i++) {
              int[] temp = que.poll();
              r = temp[0];
              c = temp[1];
              if (r-1 >= 0 && grid[r-1][c] == 1) {
                  que.add(new int[] {r-1, c});
                  grid[r-1][c] = 2;
                  fresh--;
              };
              if (r+1 < row && grid[r+1][c] == 1) {
                  que.add(new int[] {r+1, c});
                  grid[r+1][c] = 2;
                  fresh--;
              }
              if (c-1 >= 0 && grid[r][c-1] == 1) {
                  que.add(new int[] {r, c-1});
                  grid[r][c-1] = 2;
                  fresh--;
              }
              if (c+1 < col && grid[r][c+1] == 1) {
                  que.add(new int[] {r, c+1});
                  grid[r][c+1] = 2;
                  fresh--;
              }
          }
          time++;
      }

      if (fresh > 0) return -1;
      return time;
  }
}