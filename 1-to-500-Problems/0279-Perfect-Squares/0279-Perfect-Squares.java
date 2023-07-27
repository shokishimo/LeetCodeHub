class Solution {
    public int numSquares(int n) {
        int[] dp = new int[n+1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;

        for (int target = 1; target < n+1; target++) {
            for (int j = 1; j <= target; j++) {
                if (target - j*j < 0) break;
                dp[target] = Math.min(dp[target], 1 + dp[target - j*j]);
            }
        }

        return dp[n];
    }
}