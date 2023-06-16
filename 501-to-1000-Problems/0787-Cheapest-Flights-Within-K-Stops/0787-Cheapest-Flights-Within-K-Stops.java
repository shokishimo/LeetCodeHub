class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        int[] prices = new int[n];
        Arrays.fill(prices, Integer.MAX_VALUE);
        prices[src] = 0;

        for (int i = 0; i <= k; i++) {
            int[] temp = new int[n];
            temp = Arrays.copyOf(prices, prices.length);

            for (int j = 0; j < flights.length; j++) {
                int from = flights[j][0];
                int to = flights[j][1];
                int cost = flights[j][2];

                if (prices[from] == Integer.MAX_VALUE) continue;
                if (prices[from] + cost < temp[to]) {
                    temp[to] = prices[from] + cost;
                }
            }

            prices = temp;
        }

        if (prices[dst] == Integer.MAX_VALUE) return -1;
        return prices[dst];
    }
}