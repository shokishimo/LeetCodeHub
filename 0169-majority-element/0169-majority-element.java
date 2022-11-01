class Solution {
    public int majorityElement(int[] nums) {
        int len = nums.length;
        int majority = len/2;
        
        HashMap<Integer, Integer> map = new HashMap<>();
        
        for (int i = 0; i < len; i++)
        {
            map.put(nums[i], map.getOrDefault(nums[i], 0)+1);
        }
        
        
        for (int i = 0; i < len; i++)
        {
            if (map.get(nums[i]) > majority) {
                return nums[i];
            }
        }
        return -1;
    }
}