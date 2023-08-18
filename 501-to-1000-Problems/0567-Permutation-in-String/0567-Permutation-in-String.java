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

// resolve 2
class Solution {
    public boolean checkInclusion(String s1, String s2) {
        if (s1.length() > s2.length()) return false;
        int[] s1Map = new int[26];
        int[] s2Map = new int[26];
        for (int i = 0; i < s1.length(); i++) {
            s1Map[s1.charAt(i)-'a']++;
            s2Map[s2.charAt(i)-'a']++;
        }
        int matchCount = 0;
        for (int i = 0; i < 26; i++) {
            if (s1Map[i] == s2Map[i]) matchCount++;
        }

        int l = 0;
        for (int r = s1.length(); r < s2.length(); r++) {
            if (matchCount == 26) return true;

            int ind = s2.charAt(r)-'a';
            s2Map[ind]++;
            if (s2Map[ind] == s1Map[ind]) matchCount++;
            else if (s2Map[ind] - 1 == s1Map[ind]) matchCount--;

            ind = s2.charAt(l)-'a';
            s2Map[ind]--;
            if (s2Map[ind] == s1Map[ind]) matchCount++;
            else if (s2Map[ind] + 1 == s1Map[ind]) matchCount--;

            l++;
        }

        return matchCount == 26? true : false;
    }
}