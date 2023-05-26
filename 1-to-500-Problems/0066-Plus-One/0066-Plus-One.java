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


// s2
class Solution {
    public int[] plusOne(int[] digits) {
        boolean isCarry = true;
        for (int i = 0; i < digits.length; i++) {
            if (digits[i] != 9) {
                isCarry = false;
                break;
            }
        }

        int[] ans;
        if (isCarry) ans = new int[digits.length+1];
        else ans = new int[digits.length];

        int carry = 0;
        for (int i = digits.length-1; i >= 0; i--) {
            if (i == digits.length-1) {
                if (isCarry) ans[i+1] = (digits[i] + 1)%10;
                else ans[i] = (digits[i] + 1)%10;
                carry = (digits[i] + 1)/10;
            } else {
                if (isCarry) ans[i+1] = (digits[i] + carry)%10;
                else ans[i] = (digits[i] + carry)%10;
                carry = (digits[i] + carry)/10;
            }
        }
        if (isCarry) ans[0] = carry;

        return ans;
    }
}