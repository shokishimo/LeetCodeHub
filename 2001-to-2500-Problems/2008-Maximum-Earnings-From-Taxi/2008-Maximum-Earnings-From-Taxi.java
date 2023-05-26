// Dynamic Programming with HashMap
class Solution {
    public long maxTaxiEarnings(int n, int[][] rides) {
        Map<Integer, List<int[]>> map = new HashMap<>();

        for (int[] ride: rides)
        {
            List<int[]> values = map.get(ride[1]);

            if (values == null) {
                values = new ArrayList<>();
                map.put(ride[1], values);
            }

            values.add(ride);
        }

        long[] dp = new long[n+1];

        for (int i = 2; i <= n; i++)
        {
            List<int[]> values = map.get(i);

            if (values != null) // There should be a passsenger(s)
            {
                long profit = 0;
                for (int[] value: values) {
                    profit = Math.max(profit, value[1] - value[0] + value[2] + dp[value[0]]);
                }

                dp[i] = profit;
            } 

            dp[i] = Math.max(dp[i], dp[i-1]);
        }
        
        return dp[n];
    }
}