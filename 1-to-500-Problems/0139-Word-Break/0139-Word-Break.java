// bottom up dp
class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        boolean[] dp = new boolean[s.length()+1];
        dp[s.length()] = true;

        for (int i = s.length()-1; i >= 0; i--) {
            for (String each: wordDict) {
                if (i + each.length() <= s.length()
                        && each.equals(s.substring(i, i+each.length())) )
                    dp[i] = dp[i+each.length()];
                if (dp[i]) break;
            }
        }

        return dp[0];
    }
}