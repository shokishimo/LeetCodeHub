class Solution {
    public int searchInsert(int[] nums, int target) {
        int lo = 0;
        int hi = nums.length-1;
        int mi;
        
        while (lo <= hi)
        {
            mi = lo + (hi-lo)/2;
            if (target == nums[mi]) return mi;
            else if (target < nums[mi]) hi = mi - 1;
            else lo = mi + 1;
        }
        
        return lo;
    }
}