class Solution {
  public List<List<Integer>> permute(int[] nums) {
      List<List<Integer>> ans = new ArrayList<>();
      backTrack(nums, ans, new HashSet<Integer>(), new ArrayList<Integer>());

      return ans;
  }

  public void backTrack(int[] nums, List<List<Integer>> ans, HashSet<Integer> set, ArrayList<Integer> cur) {
      if (set.size() >= nums.length && cur.size() >= nums.length) {
          ans.add(new ArrayList<Integer>(cur));
          return;
      }

      for (int num: nums) {
          if (!set.contains(num)) {
              set.add(num);
              cur.add(num);
              backTrack(nums, ans, set, cur);
              cur.remove(cur.size()-1);
              backTrack(nums, ans, set, cur);
              set.remove(num);
          }
      }
  }
}

// resolve

class Solution {
    List<List<Integer>> ans;

    public List<List<Integer>> permute(int[] nums) {
        ans = new ArrayList<>();
        HashSet<Integer> set = new HashSet<>();
        backtrack(nums, set, new ArrayList<>());
        return ans;
    }

    private void backtrack(int[] nums, HashSet<Integer> set, List<Integer> cur) {
        if (cur.size() >= nums.length) {
            ans.add(new ArrayList<>(cur));
        }

        for (int i = 0 ; i < nums.length; i++) {
            if (!set.contains(nums[i])) {
                set.add(nums[i]);
                cur.add(nums[i]);
                backtrack(nums, set, cur);
                cur.remove(cur.size()-1);
                set.remove(nums[i]);
            }
        }
    }
}