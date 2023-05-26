class Solution {
  public int search(int[] nums, int target) {
      int left = 0;
      int right = nums.length-1;
      int mid;

      while (left <= right)
      {
          mid = (left+right)/2;

          if (nums[mid] == target) {
              return mid;
          } else if (nums[mid] < target) {
              left = mid+1;
          } else {
              right = mid-1;
          }
      }

      return -1;
  }
}

// Solution2: Left Most Binary Search
class Solution {
    public int search(int[] nums, int target) {
        int l = 0;
        int r = nums.length;

        while (l < r)
        {
            int m = (l + r) / 2;
            if (nums[m] < target) {
                l = m + 1;
            } else {
                r = m;
            }
        }
        if (l >= nums.length || nums[l] != target) return -1;
        else return l;
    }
}