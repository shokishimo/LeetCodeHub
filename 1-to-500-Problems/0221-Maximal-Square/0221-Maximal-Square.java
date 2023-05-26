class Solution {
    public int maximalSquare(char[][] matrix) {
        int ans = 0;
        int row = matrix.length;
        int col = matrix[0].length;
        int[][] dp = new int[row][col];

        for (int i = 0; i < col; i++)
        {
            dp[row-1][i] = matrix[row-1][i] - '0';
            ans = Math.max(ans, dp[row-1][i]);
        }
        for (int i = 0; i < row; i++)
        {
            dp[i][col-1] = matrix[i][col-1] - '0';
            ans = Math.max(ans, dp[i][col-1]);
        }
        
        for (int i = row-2; i >= 0; i--)
        {
            for (int j = col-2; j >= 0; j--)
            {
                if (matrix[i][j] == '0') {
                    dp[i][j] = 0;
                } else {
                    int temp = Math.min(dp[i][j+1], dp[i+1][j]);
                    temp = Math.min(temp, dp[i+1][j+1]);
                    dp[i][j] = (temp == 0)? 1: temp+1;
                    ans = Math.max(ans, dp[i][j]);
                }
            }
        }

        return ans*ans;
    }
}