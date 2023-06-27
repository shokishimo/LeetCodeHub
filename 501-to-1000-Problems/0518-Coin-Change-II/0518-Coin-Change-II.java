class Solution {
    public int change(int amount, int[] coins) {
        int[][] dp = new int[coins.length][amount+1];

        for (int i = 0; i < dp.length; i++) dp[i][0] = 1;
        int coin = coins[coins.length-1];
        for (int i = 1; i < dp[0].length; i++) {
            if (i >= coin) {
                dp[coins.length-1][i] = dp[coins.length-1][i - coin];
            }
        }

        for (int i = dp.length-2; i >= 0; i--) {
            for (int amou = 1; amou < dp[i].length; amou++) {
                if (amou < coins[i])
                    dp[i][amou] = dp[i+1][amou];
                else
                    dp[i][amou] = dp[i+1][amou] + dp[i][amou - coins[i]];
            }
        }
        return dp[0][amount];
    }
}