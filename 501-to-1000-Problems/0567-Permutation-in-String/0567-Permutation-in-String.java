class Solution {
  public boolean checkInclusion(String s1, String s2) {
      char[] s1Arr = s1.toCharArray();
      Arrays.sort(s1Arr);
      s1 = new String(s1Arr);

      int len = s1.length();
      for (int i = 0; i + len -1 < s2.length(); i++)
      {
          char[] temp = s2.substring(i, len+i).toCharArray();
          Arrays.sort(temp);
          String t = new String(temp);
          if (s1.equals(t)) return true;
      }
      return false;
  }
}


// second solution
class Solution {
  public boolean isValid(String s) {
      HashMap<Character, Character> map = new HashMap<>();
      map.put(')', '(');
      map.put('}', '{');
      map.put(']', '[');
      Stack<Character> stack = new Stack<>();

      for (char c: s.toCharArray()) {
          if (map.get(c) == null) {
              stack.push(c);
          } else {
              if (stack.isEmpty()) return false;
              else if (stack.pop() != map.get(c)) return false;
          }
      }

      return stack.isEmpty();
  }
}