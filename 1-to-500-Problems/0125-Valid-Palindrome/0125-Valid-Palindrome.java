class Solution {
    public boolean isPalindrome(String s) {
        StringBuilder sb = new StringBuilder();

        s.chars()
          .filter(c -> Character.isLetterOrDigit(c))
          .mapToObj(c -> Character.toLowerCase((char) c))
          .forEach(sb::append);

        return sb.toString().equals(sb.reverse().toString());
    }
}