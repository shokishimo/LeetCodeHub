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