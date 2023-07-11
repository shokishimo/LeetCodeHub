class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int totalGas = 0;
        int start = 0;
        int total = 0;

        for (int i = 0 ; i < gas.length; i++) {
            totalGas += gas[i] - cost[i];
            total += gas[i] - cost[i];
            if (total < 0) {
                total = 0;
                start = i + 1;
            }
        }
        return totalGas >= 0 ? start : -1;
    }
}