class Solution {
    public int secondsToRemoveOccurrences(String s) {
        int zeros = 0, seconds = 0;

        for (int i = 0; i < s.length(); i++)
        {
            zeros += s.charAt(i)=='0'? 1:0;

            if (s.charAt(i)=='1' && zeros>0) {
                seconds = Math.max(seconds+1, zeros);
            }
        }

        return seconds;
    }
}