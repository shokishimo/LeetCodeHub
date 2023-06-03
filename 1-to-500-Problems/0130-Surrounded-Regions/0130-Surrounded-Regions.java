class Solution {
  HashSet<List<Integer>> visited;
  int row;
  int col;

  public void solve(char[][] board) {
      row = board.length;
      col = board[0].length;
      visited = new HashSet<>();

      for (int c = 0; c < col; c++) {
          dfs(board, 0, c);
          dfs(board, row-1, c);
      }
      for (int r = 0; r < row; r++) {
          dfs(board, r, 0);
          dfs(board, r, col-1);
      }

      for (int r = 0; r < row; r++) {
          for (int c = 0; c < col; c++) {
              if (board[r][c] == 'O' && !visited.contains(Arrays.asList(r, c)))
                  board[r][c] = 'X';
          }
      }
  }

  private void dfs(char[][] board, int r, int c) {
      if (r < 0 || r >= row || c < 0 || c >= col || board[r][c] == 'X' 
          || visited.contains(Arrays.asList(r, c))) return;
      
      visited.add(Arrays.asList(r, c));
      dfs(board, r+1, c);
      dfs(board, r-1, c);
      dfs(board, r, c-1);
      dfs(board, r, c+1);
  }
}

// Better and efficient way
class Solution {
    int row;
    int col;

    public void solve(char[][] board) {
        row = board.length;
        col = board[0].length;

        for (int c = 0; c < col; c++) {
            dfs(board, 0, c);
            dfs(board, row-1, c);
        }
        for (int r = 0; r < row; r++) {
            dfs(board, r, 0);
            dfs(board, r, col-1);
        }

        for (int r = 0; r < row; r++) {
            for (int c = 0; c < col; c++) {
                if (board[r][c] == 'O')
                    board[r][c] = 'X';
                if (board[r][c] == 'T')
                    board[r][c] = 'O';
            }
        }
    }

    private void dfs(char[][] board, int r, int c) {
        if (r < 0 || r >= row || c < 0 || c >= col || board[r][c] != 'O') return;
        
        board[r][c] = 'T';
        dfs(board, r+1, c);
        dfs(board, r-1, c);
        dfs(board, r, c-1);
        dfs(board, r, c+1);
    }
}