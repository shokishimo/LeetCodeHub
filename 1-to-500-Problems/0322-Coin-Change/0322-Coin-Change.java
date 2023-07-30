class Solution {
    public int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount+1];
        Arrays.fill(dp, amount+1);
        dp[0] = 0;

        for (int target = 1; target < dp.length; target++) {
            for (int coin : coins) {
                if (target - coin < 0) continue;
                dp[target] = Math.min(dp[target], 1+dp[target - coin]);
            }
        }

        return dp[amount] == amount+1 ? -1 : dp[amount];
    }
}