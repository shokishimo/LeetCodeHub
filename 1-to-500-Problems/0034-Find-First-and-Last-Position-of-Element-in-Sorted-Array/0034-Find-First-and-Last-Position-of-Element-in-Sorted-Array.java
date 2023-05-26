class Solution {
    public int[] searchRange(int[] nums, int target) {
        int left = BinarySearch(nums, target, true);
        int right = BinarySearch(nums, target, false);

        return new int[] {left, right};
    }

    public static int BinarySearch(int[] nums, int target, boolean leftBias)
    {
        int l = 0;
        int r = nums.length-1;
        int mid = -1;
        int i = -1;
        while (l <= r)
        {
            mid = (r - l)/2 + l;
            if (nums[mid] < target)
            {
                l = mid + 1;
            }
            else if (nums[mid] > target)
            {
                r = mid - 1;
            }
            else
            {
                i = mid;
                if (leftBias) r = mid - 1;
                else l = mid + 1;
            }
        }

        return i;
    }
}