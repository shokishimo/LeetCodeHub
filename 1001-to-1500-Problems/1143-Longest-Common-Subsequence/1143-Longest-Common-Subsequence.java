class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        char[] t1 = text1.toCharArray();
        char[] t2 = text2.toCharArray();
        int[][] dp = new int[t1.length][t2.length];

        // top left
        if (t1[0] == t2[0]) dp[0][0] = 1;
        else dp[0][0] = 0;
        // top row
        for(int i = 1; i < t2.length; i++) {
            if (t1[0] == t2[i]) dp[0][i] = 1;
            else dp[0][i] = dp[0][i-1];
        }
        // left column
        for(int i = 1; i < t1.length; i++) {
            if (t1[i] == t2[0]) dp[i][0] = 1;
            else dp[i][0] = dp[i-1][0];
        }
        // rest
        for (int i = 1; i < t1.length; i++) {
            for (int j = 1; j < t2.length; j++) {
                if (t1[i] == t2[j]) dp[i][j] = dp[i-1][j-1] + 1;
                else dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
            }
        }

        return dp[t1.length-1][t2.length-1];
    }
}