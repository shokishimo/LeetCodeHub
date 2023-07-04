class Solution {
    public boolean canJump(int[] nums) {
        int goalInd = nums.length-1;

        for (int i = nums.length-1; i >= 0; i--) {
            if (i + nums[i] >= goalInd)
                goalInd = i;
        }

        if (goalInd == 0) return true;
        return false;
    }
}