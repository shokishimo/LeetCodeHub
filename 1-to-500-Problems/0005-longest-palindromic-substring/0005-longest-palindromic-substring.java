class Solution {
    public String longestPalindrome(String s) {
        if (s.length() < 2) return s;
        int len = 0;
        int left = 0;
        int right = 0;
        int l;
        int r;

        // odd
        for (int i = 0; i < s.length(); i++) {
            l = i;
            r = i;
            
            while (0 <= l && r < s.length() && s.charAt(l) == s.charAt(r)) {
                if (r-l+1 > len) {
                    left = l;
                    riht = r;
                    len = r-l+1;
                }
                l--;
                r++;
            }
        }
        
        // even
        for (int i = 0; i < s.length()-1; i++) {
            l = i;
            r = i+1;

            while (0 <= l && r < s.length() && s.charAt(l) == s.charAt(r)) {
                if (r-l+1 > len) {
                    left = l;
                    riht = r;
                    len = r-l+1;
                }
                l--;
                r++;
            }
        }
        
        return s.substring(l, r+1);
    }
}