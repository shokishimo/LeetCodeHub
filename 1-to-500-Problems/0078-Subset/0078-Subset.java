class Solution {
  public List<List<Integer>> subsets(int[] nums) {
      List<List<Integer>> ans = new ArrayList<>();
      backTrack(nums, ans, 0);
      return ans;
  }

  public void backTrack(int[] nums, List<List<Integer>> ans, int i) {
      if (i >= nums.length) {
          ans.add(new ArrayList<>());
          return;
      }
      backTrack(nums, ans, i+1);
      int len = ans.size();
      for (int j = 0; j < len; j++) {
          ArrayList<Integer> temp = new ArrayList<>();
          for(int k: ans.get(j)) {
              temp.add(k);
          }
          temp.add(nums[i]);
          ans.add(temp);
      }
  }
}