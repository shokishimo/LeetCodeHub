class Solution {
    public boolean containsDuplicate(int[] nums) {
        boolean ans = false;

        HashSet<Integer> set = new HashSet<>();

        for (int each : nums)
        {
            if (!set.add(each)) {
                ans = true;
                break;
            }
        }

        return ans;
    }
}