class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> ans = new ArrayList<>();
        backTrack(ans, new StringBuilder(), 0, 0, n);
        return ans;
    }

    public void backTrack(List<String> ans, StringBuilder sb, int open, int close, int n) 
    {
        if (open == close && close == n) {
            ans.add(sb.toString());
            return;
        }

        if (open < n) {
            sb.append("(");
            backTrack(ans, sb, open+1, close, n);
            sb.deleteCharAt(sb.length()-1);
        }

        if (close < open) {
            sb.append(")");
            backTrack(ans, sb, open, close+1, n);
            sb.deleteCharAt(sb.length()-1);
        }
    }
    
}