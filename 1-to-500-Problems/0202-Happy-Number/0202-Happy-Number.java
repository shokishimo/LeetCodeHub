class Solution {
    public boolean isHappy(int n) {
        HashSet<Integer> repeat = new HashSet<>();
        repeat.add(n);
        boolean ans = true;
        while(n != 0) {
            n = getSumSquares(n);
            if (n == 1) {
                ans = true;
                break;
            }else if (!repeat.add(n)) {
                ans = false;
                break;
            }
        }

        return ans;
    }

    public int getSumSquares(int n) {
        int res = 0;
        while (n != 0) {
            int a = n%10;
            res += a*a;
            n /= 10;
        }

        return res;
    }
}