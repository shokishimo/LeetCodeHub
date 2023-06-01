class Solution {
  List<List<Integer>> ans;
  public List<List<Integer>> combinationSum2(int[] candidates, int target) {
      ans = new ArrayList<>();
      Arrays.sort(candidates);
      backtrack(candidates, target, 0, new ArrayList<Integer>(), 0);
      return ans;
  }

  public void backtrack(int[] candidates, int target, int pos, List<Integer> cur, int sum) {
      if (sum > target) return;
      if (pos >= candidates.length) {
          if (sum == target) {
              ans.add(new ArrayList<>(cur));
          }
          return;
      }
      // include the character of current position
      cur.add(candidates[pos]);
      sum += candidates[pos];
      backtrack(candidates, target, pos+1, cur, sum);
      cur.remove(cur.size()-1);
      sum -= candidates[pos];

      // Do Not include the character of current position
      while (pos+1 < candidates.length && candidates[pos] == candidates[pos+1]) pos++;
      backtrack(candidates, target, pos+1, cur, sum);
  }
}