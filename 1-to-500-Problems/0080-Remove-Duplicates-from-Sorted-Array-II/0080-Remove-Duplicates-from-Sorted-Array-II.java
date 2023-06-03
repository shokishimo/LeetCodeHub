class Solution {
  public int removeDuplicates(int[] nums) {
      int count = 1;
      int duplicates = 0;
      int cur = nums[0];
      int dum = Integer.MIN_VALUE;

      for (int i = 1; i < nums.length; i++) {
          if (nums[i] == cur) {
              count++;
          } else {
              cur = nums[i];
              count = 1;
          }

          if (count >= 3) {
              nums[i] = dum;
              duplicates++;
          }
      }

      int l = 0;
      while (l < nums.length) {
          if (nums[l] == dum) break;
          l++;
      }
      int len = 1;
      for (int i = l+1; i < nums.length; i++) {
          int temp = len;
          if (nums[i] == dum) {
              temp = len + 1;
          }
          int t = nums[i];
          nums[i] = nums[i-len];
          nums[i-len] = t;
          len = temp;
      }

      return nums.length - duplicates;
  }
}