class Solution {
  public void wallsAndGates(int[][] rooms) {
      int row = rooms.length;
      int col = rooms[0].length;
      int INF = Integer.MAX_VALUE;
      Deque<int[]> que = new ArrayDeque<>();

      for (int r = 0; r < row; r++) {
          for (int c = 0; c < col; c++) {
              if (rooms[r][c] == 0) que.add(new int[] {r, c});
          }
      }

      int distance = 0;
      int[] position;
      int r;
      int c;
      int size;
      while(!que.isEmpty()) {
          size = que.size();
          distance++;
          for (int i = 0; i < size; i++) {
              position = que.poll();
              r = position[0];
              c = position[1];
              if (r+1 < row && rooms[r+1][c] == INF) {
                  rooms[r+1][c] = distance;
                  que.add(new int[] {r+1, c});
              }
              if (r-1 >= 0 && rooms[r-1][c] == INF) {
                  rooms[r-1][c] = distance;
                  que.add(new int[] {r-1, c});
              }
              if (c+1 < col && rooms[r][c+1] == INF) {
                  rooms[r][c+1] = distance;
                  que.add(new int[] {r, c+1});
              }
              if (c-1 >= 0 && rooms[r][c-1] == INF) {
                  rooms[r][c-1] = distance;
                  que.add(new int[] {r, c-1});
              }
          }
      }
  }
}