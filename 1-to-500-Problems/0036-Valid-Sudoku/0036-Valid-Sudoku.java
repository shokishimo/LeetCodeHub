class Solution {
  public boolean isValidSudoku(char[][] board) {
      ArrayList<HashSet<Character>> tate = new ArrayList<>();
      ArrayList<HashSet<Character>> yoko = new ArrayList<>();
      ArrayList<HashSet<Character>> hako = new ArrayList<>();

      for (int i = 0; i < 9; i++)
      {
          tate.add(new HashSet<>());
          yoko.add(new HashSet<>());
          hako.add(new HashSet<>());
      }

      for (int i = 0; i < board.length; i++)
      {
          for (int j = 0; j < board[0].length; j++)
          {
              if (board[i][j] != '.')
              {
                  if (!tate.get(j).add(board[i][j])) {
                      return false;
                  }
                  if (!yoko.get(i).add(board[i][j])) {
                      return false;
                  }
                  if (!hako.get(calcNum(i, j)).add(board[i][j])) {
                      return false;
                  }
              }
          }
      }

      return true;
  }

  public int calcNum(int i, int j) {
    return (i/3)*3 + j/3;
  }
}