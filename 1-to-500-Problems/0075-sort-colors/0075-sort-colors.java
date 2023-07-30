class Solution {
    public void sortColors(int[] nums) {
        if (nums.length == 1) return;
            
        int red = 0;
        int blue = nums.length-1;
        
        for (int i = 0; i < nums.length; i++)
        {
            if (nums[i] == 0) {
                int temp = nums[red];
                nums[red] = nums[i];
                nums[i] = temp;
                red++;
            } else if (nums[i] == 2 && i < blue) {
                int temp = nums[blue];
                nums[blue] = nums[i];
                nums[i] = temp;
                blue--;
                i--;
            }
        }
    }
}

// Solution 2
class Solution {
    public void sortColors(int[] nums) {
        int l = 0;
        int r = nums.length-1;
        int i = 0;

        while (l < r && i <= r) {
            if (nums[i] == 0) {
                switchNum(nums, l, i);
                l++;
                i++;
            } else if (nums[i] == 2) {
                switchNum(nums, r, i);
                r--;
            } else {
                i++;
            }
        }
    }

    private void switchNum(int[] nums, int a, int i) {
        int temp = nums[a];
        nums[a] = nums[i];
        nums[i] = temp;
    }
}