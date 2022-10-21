class Solution {
    public String longestPalindrome(String s) {
        String ans ="";
        int len = 0;
        
        
        // odd
        for (int i = 0; i < s.length(); i++)
        {
            int lo = i;
            int hi = i;
            
            while (lo>=0 && hi<s.length() && s.charAt(lo)==s.charAt(hi))
            {
                if (hi-lo+1 > len) {
                    ans = s.substring(lo, hi+1);
                    len = hi-lo+1;
                }
                hi++;
                lo--;
            }
        }
        
        // even
        for (int i = 0; i < s.length()-1; i++)
        {
            int lo = i;
            int hi = i+1;

            while (lo>=0 && hi<s.length() && s.charAt(lo)==s.charAt(hi))
            {
                if (hi-lo+1 >len) {
                    ans = s.substring(lo, hi+1);
                    len = hi-lo+1;
                }
                hi++;
                lo--;
            }
        }
        
        return ans;
    }
}