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

// resolve
class Solution {
    List<List<Integer>> ans;

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        ans = new ArrayList<>();
        backtrack(nums, 0, new ArrayList<>());

        return ans;
    }

    private void backtrack(int[] nums, int ind, List<Integer> cur) {
        if (ind >= nums.length) {
            ans.add(new ArrayList<>(cur));
            return;
        }

        cur.add(nums[ind]);
        backtrack(nums, ind+1, cur);

        cur.remove(cur.size()-1);
        int curVal = nums[ind];
        while(ind < nums.length && curVal == nums[ind]) {
            ind++;
        }
        backtrack(nums, ind, cur);
    }
}