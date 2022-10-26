class Solution {
    public void moveZeroes(int[] nums) {
        int lo = 0;
        int hi = 0;
        
        while (hi < nums.length)
        {
            if (nums[hi] == 0) {
                hi++;
            } else {
                nums[lo] = nums[hi];
                lo++;
                hi++;
            }
        }
        
        while (lo < nums.length) {
            nums[lo] = 0;
            lo++;
        }
        
        return;
    }
}