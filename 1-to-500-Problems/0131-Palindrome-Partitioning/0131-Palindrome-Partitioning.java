class Solution {
  List<List<String>> ans;
  public List<List<String>> partition(String s) {
      ans = new ArrayList<>();
      backtrack(s, new ArrayList<>(), 0);
      return ans;
  }

  private void backtrack(String s, List<String> cur, int pos) {
      if (pos >= s.length()) {
          ans.add(new ArrayList<>(cur));
          return;
      }
      // evey possible partition
      for (int i = pos; i < s.length(); i++) {
          if (isPalin(s, pos, i)) {
              cur.add(s.substring(pos, i+1));
              backtrack(s, cur, i+1);
              cur.remove(cur.size()-1);
          }
      }
  }

  private boolean isPalin(String s, int l, int r) {
      while (l < r) {
          if (s.charAt(l) != s.charAt(r))
              return false;
          l++;
          r--;
      }
      return true;
  }
}