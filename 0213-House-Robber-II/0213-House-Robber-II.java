// solution 1
class Solution {
  public int rob(int[] nums) {
      if (nums.length == 1) return nums[0];
      else if (nums.length == 2) return Math.max(nums[0], nums[1]);

      // when picking the first house
      int sum = nums[0];
      int prevPrevPrev = 0;
      int prevPrev = nums[0];
      int prev = 0;
      for (int i = 2; i < nums.length-1; i++) {
          int temp = Math.max(prevPrevPrev, prevPrev);
          sum = Math.max(sum, temp + nums[i]);
          prevPrevPrev = prevPrev;
          prevPrev = prev;
          prev = temp + nums[i];
      }

      // when NOT picking the first house
      prevPrevPrev = 0;
      prevPrev = 0;
      prev = 0;
      for (int i = 1; i < nums.length; i++) {
          int temp = Math.max(prevPrevPrev, prevPrev);
          sum = Math.max(sum, temp + nums[i]);
          prevPrevPrev = prevPrev;
          prevPrev = prev;
          prev = temp + nums[i];
      }

      return sum;
  }
}