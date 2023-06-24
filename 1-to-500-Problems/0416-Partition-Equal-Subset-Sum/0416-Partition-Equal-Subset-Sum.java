class Solution {
    public boolean canPartition(int[] nums) {
        int sum = 0;
        for (int i : nums) sum += i;
        if (sum%2 != 0) return false;
        sum = sum/2;
        Boolean[][] memo = new Boolean[nums.length][sum+1];

        return dfs(nums, memo, 0, sum);
    }

    private boolean dfs(int[] nums, Boolean[][] memo, int cur, int sum) {
        if (sum == 0) return true;
        if (sum < 0 || cur == nums.length) return false;

        if (memo[cur][sum] != null) return memo[cur][sum];

        return memo[cur][sum] = dfs(nums, memo, cur+1, sum-nums[cur])
                || dfs(nums, memo, cur+1, sum);
    }
}