class Solution {
  public int[] countBits(int n) {
      int[] ans = new int[n+1];
      ans[0] = 0;
      int power2 = 4;
      int sum = 0;
      for (int i = 1; i < ans.length; i++) {
          ans[i] = Integer.bitCount(i);
      }
      return ans;
  }
}