class Solution {
    public int[] twoSum(int[] nums, int target) {
        int[] ans = new int[2];
        HashMap<Integer, Integer> map = new HashMap<>();
        HashSet<Integer> set = new HashSet<>();

        for (int i = 0; i < nums.length; i++)
        {
            if (set.contains(nums[i])) {
                ans[1] = i;
                ans[0] = map.get(target-nums[i]);
                break;
            }
            map.put(nums[i], i);
            set.add(target-nums[i]);
        }
        return ans;
    }
}