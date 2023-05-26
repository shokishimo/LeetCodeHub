class Solution {
    public int[] productExceptSelf(int[] nums) {
        int len = nums.length;
        int[] ans = new int[len];
        ans[0] = 1;

        for (int i = 1; i < len; i++)
        {
            ans[i] = nums[i-1]*ans[i-1];
        }
        int sum = nums[len-1];
        for (int i = len-2; i >= 0; i--)
        {
            ans[i] *= sum;
            sum *= nums[i];
        }
        return ans;
    }
}