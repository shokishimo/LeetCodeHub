class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        List<Integer> ans = triangle.get(triangle.size()-1);
        List<Integer> temp;

        for (int i = triangle.size()-2; i >= 0; i--) {
            List<Integer> curList = triangle.get(i);
            temp = new ArrayList<>();
            for (int j = 0; j < ans.size()-1; j++) {
                int next = Math.min(ans.get(j), ans.get(j+1));
                temp.add(curList.get(j)+next);
            }
            ans = temp;
        }

        return ans.get(0);
    }
}