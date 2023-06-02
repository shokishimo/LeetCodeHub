class Solution {
  public boolean exist(char[][] board, String word) {
      for (int i = 0; i < board.length; i++) {
          for (int j = 0; j < board[0].length; j++) {
              if (backtrack(i, j, 0, board, word)) return true;
          }
      }
      return false;
  }

  private boolean backtrack(int r, int c, int pos, char[][] board, String word) {
      if (pos == word.length()) return true;
      
      if (r >= board.length || c >= board[0].length 
          || r < 0|| c < 0 
          || word.charAt(pos) != board[r][c])
              return false;

      board[r][c] += 100;
      boolean res = backtrack(r+1, c, pos+1, board, word) || 
                    backtrack(r-1, c, pos+1, board, word) ||
                    backtrack(r, c+1, pos+1, board, word) ||
                    backtrack(r, c-1, pos+1, board, word);
      board[r][c] -= 100;
      return res;
  }
}