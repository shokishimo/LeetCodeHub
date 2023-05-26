class Solution {
  public int maxProfit(int[] prices) {
      int maxProfit = 0;

      int cur = prices[0];

      for (int i = 1; i < prices.length; i++)
      {
          if(cur >= prices[i]) {
              cur = prices[i];
          } else {
              maxProfit = Math.max(maxProfit, prices[i] - cur);
          }
      }

      return maxProfit;
  }
}