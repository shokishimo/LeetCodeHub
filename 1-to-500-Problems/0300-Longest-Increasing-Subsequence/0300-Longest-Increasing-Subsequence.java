// Bottom up DP
class Solution {
    public int lengthOfLIS(int[] nums) {
        int[] dp = new int[nums.length];
        Arrays.fill(dp, 1);
        int max = 1;

        for (int i = nums.length-1; i >= 0; i--) {
            for (int j = i+1; j < nums.length; j++) {
                if (nums[i] < nums[j]) {
                    dp[i] = Math.max(dp[i], 1+dp[j]);
                }
            }
            max = Math.max(max, dp[i]);
        }
        return max;
    }
}

// Top-to-down Recursive (not efficient enough)
class Solution {
    public int lengthOfLIS(int[] nums) {
        Integer[] dp = new Integer[nums.length];
        boolean[] determined = new boolean[nums.length];
        for (int i = 0; i < nums.length; i++) {
            recursive(nums, dp, i, determined);
        }

        int max = 1;
        for (int each: dp) {
            max = Math.max(max, each);
        }
        return max;
    }

    private void recursive(int[] nums, Integer[] dp, int cur, boolean[] determined) {
        if (cur == nums.length-1) {
            dp[cur] = 1;
            return;
        }
        if (determined[cur]) return;

        dp[cur] = 1;
        for (int i = cur+1; i < nums.length; i++) {
            if (nums[cur] < nums[i]) {
                recursive(nums, dp, i, determined);
                dp[cur] = Math.max(dp[cur], 1+dp[i]);
            }
        }
        determined[cur] = true;
    }
}