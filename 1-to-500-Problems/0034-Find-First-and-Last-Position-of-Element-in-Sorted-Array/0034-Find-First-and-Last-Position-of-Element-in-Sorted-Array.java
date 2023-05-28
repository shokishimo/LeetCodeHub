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



// Solution2
class Solution {
    public int[] searchRange(int[] nums, int target) {
        if (nums.length == 0) return new int[] {-1, -1};
        int leftPos = Binary(nums, target, true);
        if (leftPos == -1) return new int[] {-1, -1};
        int rightPos = Binary(nums, target+1, false);
        rightPos = (rightPos == 0)? 0: rightPos-1;
        return new int[] {leftPos, rightPos};
    }

    private int Binary(int[] nums, int target, boolean check) {
        int l = 0;
        int r = nums.length;

        while (l < r) {
            int m = (l+r)/2;
            if (nums[m] < target) 
                l = m + 1;
            else 
                r = m;
        }
        if (check && l >= nums.length)  return -1;
        else if (check && nums[l] != target) return -1;
        return l;
    }
}