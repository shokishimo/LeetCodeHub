class Solution {
    public int[] sortedSquares(int[] nums) {
        if (nums.length == 1) {
            nums[0] *= nums[0];
            return nums;
        }

        int l = 0;
        int r = nums.length-1;
        for (int i = 0; i < nums.length; i++)
        {
            if (nums[i] < 0) {
                nums[i] *= -1;
                l = i;
            }
        }

        if (l+1 < nums.length) {
            r = l+1;
        } else {
            r = l;
            l--;
        }
        if (l < 0) {
            l++;
            r++;
        }

        int ind = 0;
        int[] ans = new int[nums.length];

        while(l >= 0 && r < nums.length)
        {
            
            if (nums[l]*nums[l] < nums[r]*nums[r]) {
                ans[ind] = nums[l]*nums[l];
                l--;
            } else {
                ans[ind] = nums[r]*nums[r];
                r++;
            }
            ind++;
        }

        while(l >= 0)
        {
            ans[ind] = nums[l]*nums[l];
            l--;
            ind++;
        }
        while(r < nums.length)
        {
            ans[ind] = nums[r]*nums[r];
            r++;
            ind++;
        }

        return ans;
    }
}