class Solution {
    public boolean mergeTriplets(int[][] triplets, int[] target) {
        int[] cur = new int[3];
        for (int i = 0; i < triplets.length; i++) {
            if (triplets[i][0] > target[0] || triplets[i][1] > target[1] || triplets[i][2] > target[2])
                continue;
            if (triplets[i][0] == target[0] && triplets[i][1] == target[1] && triplets[i][2] == target[2])
                return true;

            cur[0] = Math.max(cur[0], triplets[i][0]);
            cur[1] = Math.max(cur[1], triplets[i][1]);
            cur[2] = Math.max(cur[2], triplets[i][2]);
            if (cur[0] == target[0] && cur[1] == target[1] && cur[2] == target[2])
                return true;
        }

        return false;
    }
}