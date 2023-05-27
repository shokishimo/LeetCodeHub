class Solution {
  public int minEatingSpeed(int[] piles, int h) {
      int max = -1;
      for (int each: piles) {
          max = Math.max(max, each);
      }

      int l = 1;
      int r = max;
      int res = max;
      while(l <= r)
      {
          int k = (l+r)/2;
          int hours = 0;
          for (int each: piles) {
              hours += Math.ceil((double) each/k);
          }
          if (hours <= h) {
              res = Math.min(res, k);
              r = k - 1;
          } else
              l = k + 1;
      }

      return res;
  }
}