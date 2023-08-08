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

// resolve O(n * m * 4^(k)), where n = board.length, m = board[0].length, k = len(word)

class Solution {
    public boolean exist(char[][] board, String word) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j] == word.charAt(0)) {
                    if (recursiveSerach(board, word, new HashSet<>(), 0, i, j))
                        return true;
                }
            }
        }
        return false;
    }

    private boolean recursiveSerach(char[][] board, String word, HashSet<String> set, int ind, int i, int j) {
        if (ind >= word.length()) return true;
        if (i < 0 || i >= board.length || j < 0 || j >= board[i].length) return false;
        if (word.charAt(ind) != board[i][j] || set.contains("row"+i+"col"+j)) return false;

        set.add("row"+i+"col"+j);
        boolean res  = recursiveSerach(board, word, set, ind+1, i-1, j)
                || recursiveSerach(board, word, set, ind+1, i+1, j)
                || recursiveSerach(board, word, set, ind+1, i, j+1)
                || recursiveSerach(board, word, set, ind+1, i, j-1);
        set.remove("row"+i+"col"+j);
        return res;
    }
}


