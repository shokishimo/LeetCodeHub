class Solution {
  public int findMin(int[] nums) {
      if (nums.length == 1) return nums[0];
      else if (nums.length == 2) return Math.min(nums[0], nums[1]);

      int ans = Integer.MAX_VALUE;
      int l = 0;
      int r = nums.length-1;
      while (l <= r)
      {
          int m = (l+r)/2;
          ans = Math.min(ans, nums[m]);
          if (nums[m] >= nums[r]) {
              l = m + 1;
          }
          if (nums[m] < nums[r]) {
              r = m - 1;
          }
      }

      return ans;
  }
}