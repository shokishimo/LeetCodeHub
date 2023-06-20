class Solution {
    public int numDecodings(String s) {
        return countNumDecodes(s, 0, new Integer[s.length()]);
    }

    private int countNumDecodes(String s, int cur, Integer[] dp) {
        if (cur >= s.length()) return 1;
        if (s.charAt(cur) == '0') return 0;
        if (dp[cur] != null) return dp[cur];

        int res = countNumDecodes(s, cur+1, dp);
        if (cur < s.length()-1 && (s.charAt(cur) == '1' || (s.charAt(cur) == '2' && s.charAt(cur+1) < '7') )) {
            res += countNumDecodes(s, cur+2, dp);
        }
        dp[cur] = res;
        return res;
    }
}