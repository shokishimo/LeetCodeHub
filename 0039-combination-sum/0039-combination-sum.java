class Solution {
    List<List<Integer>> ans = new ArrayList<>();
    
    public List<List<Integer>> combinationSum(int[] candidates, int target)       { 
        List<Integer> cur = new ArrayList<>();
        dfs(0, candidates, cur, 0, target);
        return ans;
    }
    
    public void dfs(int i, int[] candidates, List<Integer> cur, int total, int target)
    {
        if (total == target) {
            List<Integer> temp = new ArrayList<>(cur);
            ans.add(temp);
            return;
        }
        if (i >= candidates.length || total > target) {
            return;
        }
        
        cur.add(candidates[i]);
        dfs(i, candidates, cur, total+candidates[i], target);
        cur.remove(cur.size()-1);
        dfs(i+1, candidates, cur, total, target);
    
    }
    
}