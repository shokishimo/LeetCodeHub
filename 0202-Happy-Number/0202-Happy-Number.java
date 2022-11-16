class Solution {
    public boolean isHappy(int n) {
        if (n == 1) return true;
        HashSet<Integer> set = new HashSet<>();

        boolean ans = false;
        while (n != 1)
        {
            int sum = 0;
            while (n > 0)
            {
                sum += (int) Math.pow(n%10, 2);
                n = n/10;
            }
            if (sum == 1) {
                ans = true;
                break;
            }
            else if (!set.add(sum)) {
                break;
            }
            n = sum;
        }

        return ans;
    }
}