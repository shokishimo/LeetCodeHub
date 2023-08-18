// resolve 1
class Solution {
    public boolean checkInclusion(String s1, String s2) {
        int[] s1Map = new int[26];
        for (char c : s1.toCharArray()) {
            s1Map[c-'a']++;
        }

        int l = 0;
        for (int r = 0; r < s2.length(); r++) {
            char c = s2.charAt(r);
            s1Map[c-'a']--;
            if (s1Map[c-'a'] < 0 || r - l + 1 > s1.length()) {
                s1Map[s2.charAt(l)-'a']++;
                l++;
            }
            if (checkIfAllZero(s1Map)) return true;
        }

        return false;
    }

    private boolean checkIfAllZero(int[] map) {
        for (int each : map) {
            if (each != 0) return false;
        }
        return true;
    }
}