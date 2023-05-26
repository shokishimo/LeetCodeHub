class Solution {
    public int countVowelStrings(int n) {
        if (n == 1) return 5;

        int[] dp = new int[] {1, 1, 1, 1, 1};
        int prev4 = 1;
        int prev3 = 1;
        int prev2 = 1;
        int prev1 = 1;
        int prev0 = 1;

        for (int i = 2; i <= n; i++)
        {
            prev4 = dp[4];
            prev3 = dp[3];
            prev2 = dp[2];
            prev1 = dp[1];
            prev0 = dp[0];

            dp[0] = prev0;
            dp[1] = prev0 + prev1;
            dp[2] = prev0 + prev1 + prev2;
            dp[3] = prev0 + prev1 + prev2 + prev3;
            dp[4] = prev0 + prev1 + prev2 + prev3 + prev4;
        }

        return dp[0] + dp[1] + dp[2] + dp[3] + dp[4];
    }
}