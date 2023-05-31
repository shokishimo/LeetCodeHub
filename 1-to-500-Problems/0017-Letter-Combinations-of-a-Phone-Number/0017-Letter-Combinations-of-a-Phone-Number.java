class Solution {
  HashMap<Character, char[]> map;
  List<String> ans;

  public List<String> letterCombinations(String digits) {
      ans = new ArrayList<>();
      map = new HashMap<>();
      map.put('2', new char[] {'a', 'b', 'c'});
      map.put('3', new char[] {'d', 'e', 'f'});
      map.put('4', new char[] {'g', 'h', 'i'});
      map.put('5', new char[] {'j', 'k', 'l'});
      map.put('6', new char[] {'m', 'n', 'o'});
      map.put('7', new char[] {'p', 'q', 'r', 's'});
      map.put('8', new char[] {'t', 'u', 'v'});
      map.put('9', new char[] {'w', 'x', 'y', 'z'});
      char[] list = new char[digits.length()];
      generateLetters(digits, list, 0);
      return ans;
  }

  private void generateLetters(String digits, char[] list, int pos) {
      if (pos >= digits.length()) {
          String t = new String(list);
          if (t.equals("")) return;
          ans.add(t);
      } else {
          char[] chars = map.get(digits.charAt(pos));
          for (int i = 0; i < chars.length; i++) {
              list[pos] = chars[i];
              generateLetters(digits, list, pos+1);
          }
      }
  }
}