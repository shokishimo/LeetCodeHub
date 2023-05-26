class Solution {
  public int getSum(int a, int b) {
      while (b != 0) {
          int t = (a & b) << 1;
          a = a ^ b;
          b = t;
      }
      return a;
  }
}
