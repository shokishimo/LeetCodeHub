class Solution {
  public int lastStoneWeight(int[] stones) {
      PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
      for (int stone: stones) {
          pq.add(stone);
      }

      while (pq.size() > 1)
      {
          int y = pq.poll();
          int x = pq.poll();
          if (x == y) continue;
          else {
              y -= x;
              pq.add(y);
          }
      }

      if (pq.size() == 0) return 0;
      else return pq.poll();
  }
}