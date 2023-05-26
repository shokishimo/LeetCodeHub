// Solution 1
public class Solution {
  // you need treat n as an unsigned value
  public int reverseBits(int n) {
      return Integer.reverse(n);
  }
}

// Solution 2
public class Solution {
  // you need treat n as an unsigned value
  public int reverseBits(int n) {
      int ans = 0;
      for (int i = 0; i < 32; i++) {
          int t = n & 1;
          ans |= (t << (31 - i));
          n = n >> 1;
      }
      return ans;
  }
}