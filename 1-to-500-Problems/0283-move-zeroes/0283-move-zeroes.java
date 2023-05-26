class Solution {
    public void moveZeroes(int[] nums) {
//         int lo = 0;
//         int hi = 0;
        
//         while (hi < nums.length)
//         {
//             if (nums[hi] == 0) {
//                 hi++;
//             } else {
//                 nums[lo] = nums[hi];
//                 lo++;
//                 hi++;
//             }
//         }
        
//         while (lo < nums.length) {
//             nums[lo] = 0;
//             lo++;
//         }
        
//         return;
        int counter = 0;
        for (int i = 0; i < nums.length; i++)
        {
            if (nums[i] == 0) {
                counter++;
            } else if (counter != 0) {
                nums[i-counter] = nums[i];
                nums[i] = 0;
            }
        }
    }
}