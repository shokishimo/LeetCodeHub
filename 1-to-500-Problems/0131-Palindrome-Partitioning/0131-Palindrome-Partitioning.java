// resolve
class Solution {
    List<List<String>> ans;
    public List<List<String>> partition(String s) {
        ans = new ArrayList<>();
        backtrack(s, new ArrayList<>(), 0);
        return ans;
    }

    private void backtrack(String s, List<String> curPart, int i) {
        if (i >= s.length()) {
            ans.add(new ArrayList<>(curPart));
            return;
        }

        for (int j = i; j < s.length(); j++) {
            if (isPalindrome(s, i, j)) {
                curPart.add(s.substring(i, j+1));
                backtrack(s, curPart, j+1);
                curPart.remove(curPart.size()-1);
            }
        }
    }

    private boolean isPalindrome(String s, int l, int r) {
        while (l < r) {
            if (s.charAt(l) != s.charAt(r)) return false;
            l++;
            r--;
        }
        return true;
    }
}