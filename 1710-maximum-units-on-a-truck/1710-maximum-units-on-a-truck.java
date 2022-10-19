class Solution {
    public int maximumUnits(int[][] boxTypes, int truckSize) {
        Arrays.sort(boxTypes, (a, b) -> {
            return b[1] - a[1];
        });
        
        int cur = 0;
        int units = 0;
        for (int i = 0; i < boxTypes.length; i++)
        {
            if (cur + boxTypes[i][0] <= truckSize)
            {
                units += boxTypes[i][0] * boxTypes[i][1];
                cur += boxTypes[i][0];
            }
            else
            {
                cur = truckSize - cur;
                units += cur * boxTypes[i][1];
                break;
            }
        }
        
        return units;
    }
}