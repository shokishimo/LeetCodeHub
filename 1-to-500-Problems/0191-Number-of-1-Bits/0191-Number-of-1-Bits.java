public class Solution {
  // you need to treat n as an unsigned value
  public int hammingWeight(int n) {
      int count = 0;
      int t = 1;
      for (int i = 0; i < 32; i++) {
          if ((n & t) == 1) {
              count++;
          }
          n >>= 1;
      }
      return count;
  }
}