class Solution {
    public String minWindow(String s, String t) {
        if (t.length() == 0 || t.length() > s.length()) return "";

        HashMap<Character, Integer> map = new HashMap<>();
        for (char c : t.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        int l = 0;
        int match = 0;
        int minLen = s.length()+1;
        int minStart = -1;

        for (int r = 0; r < s.length(); r++) {
            char rightC = s.charAt(r);
            if (map.containsKey(rightC)) {
                map.put(rightC, map.get(rightC)-1);
                if (map.get(rightC) == 0) match++;
            }

            while (match == map.size()) {
                if (r-l+1 < minLen) {
                    minLen = r-l+1;
                    minStart = l;
                }

                char leftC = s.charAt(l);
                if (map.containsKey(leftC)) {
                    if (map.get(leftC) == 0) match--;
                    map.put(leftC, map.get(leftC)+1);
                }
                l++;
            }
        }

        return (minLen > s.length())? "" : s.substring(minStart, minStart+minLen);
    }
}