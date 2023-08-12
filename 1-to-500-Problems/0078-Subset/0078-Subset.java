// resolve

class Solution {
    List<List<Integer>> ans;
    public List<List<Integer>> subsets(int[] nums) {
        ans = new ArrayList<>();
        backtrack(nums, new ArrayList<>(), 0);
        return ans;
    }

    private void backtrack(int[] nums, List<Integer> curSub, int i) {
        if (i >= nums.length) {
            ans.add(new ArrayList<>(curSub));
            return;
        }

        backtrack(nums, curSub, i+1);
        curSub.add(nums[i]);
        backtrack(nums, curSub, i+1);
        curSub.remove(curSub.size()-1);
    }
}