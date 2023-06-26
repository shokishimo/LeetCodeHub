class Solution {
    public int maxProfit(int[] prices) {
        int sold = Integer.MIN_VALUE;
        int held = Integer.MIN_VALUE;
        int reset = 0;

        for (int price : prices) {
            int newSold = held+price;
            int newHeld = Math.max(held, reset-price);
            int newReset = Math.max(reset, sold);
            sold = newSold;
            held = newHeld;
            reset = newReset;
        }
        return Math.max(sold, reset);
    }
}