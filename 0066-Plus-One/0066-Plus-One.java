class Solution {
    public int[] plusOne(int[] digits) {
        int i = digits.length-1;
        digits[i]++;

        while (0 < i && digits[i] == 10)
        {
            digits[i] = 0;
            i--;
            digits[i]++;
        }

        if (digits[0] == 10) {
            digits[0] = 0;
            int[] ans = new int[digits.length+1];
            ans[0] = 1;
            for (int j = 1; j < ans.length; j++) {
                ans[j] = digits[j-1];
            }
            return ans;
        }
        

        return digits;
    }
}