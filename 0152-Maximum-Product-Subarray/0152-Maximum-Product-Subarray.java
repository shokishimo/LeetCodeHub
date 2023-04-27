class Solution {
  public int maxProduct(int[] nums) {
      if (nums.length == 1) return nums[0];
      int min = 1;
      int max = 1;
      int ans = nums[0];
      
      for (int each: nums)
      {
          int temp = max*each;
          max = Math.max(each, Math.max(temp, min*each));
          min = Math.min(each, Math.min(temp, min*each));
          ans = Math.max(ans, max);
      }

      return ans;
  }
}