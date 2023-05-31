class Solution {
  public List<List<Integer>> subsetsWithDup(int[] nums) {
      List<List<Integer>> ans = new ArrayList<>();
      Arrays.sort(nums);
      backtrack(nums, ans, 0, new ArrayList<>());
      return ans;
  }

  private void backtrack(int[] nums, List<List<Integer>> ans, int pos, List<Integer> subset) {
      if (pos >= nums.length) 
          ans.add(new ArrayList<>(subset));
      else {
          // all subsets that include nums[pos]
          subset.add(nums[pos]);
          backtrack(nums, ans, pos+1, subset);
          subset.remove(subset.size()-1);

          // all subsets that DO NOT include nums[pos]
          while (pos+1 < nums.length && nums[pos] == nums[pos+1])
              pos++;
          backtrack(nums, ans, pos+1, subset);
      }
  }
}