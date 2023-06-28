class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        HashMap<String, Integer> map = new HashMap<>();
        return recusiveWithMemo(map, nums, target, 0, 0);
    }

    private int recusiveWithMemo(HashMap<String, Integer> map, int[] nums, int target, int i, int t) {
        if (i >= nums.length) {
            if (t == target) return 1;
            else return 0;
        }
        String key = i+"-"+t;
        if (map.get(key) != null) return map.get(key);

        int curT = recusiveWithMemo(map, nums, target, i+1, t+nums[i])
                + recusiveWithMemo(map, nums, target, i+1, t-nums[i]);
        map.put(key, curT);
        return curT;
    }
}