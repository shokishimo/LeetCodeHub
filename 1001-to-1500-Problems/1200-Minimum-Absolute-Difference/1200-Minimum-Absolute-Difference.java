class Solution {
    public List<List<Integer>> minimumAbsDifference(int[] arr) {
        Arrays.sort(arr);

        int minDif = Integer.MAX_VALUE;
        for (int i = 1; i < arr.length; i++)
        {
            minDif = Math.min(minDif, (int)Math.abs(arr[i] - arr[i-1]));
        }

        List<List<Integer>> ans = new ArrayList<>();
        for (int i = 1; i < arr.length; i++)
        {
            if ((int)Math.abs(arr[i]-arr[i-1]) == minDif) {
                List<Integer> t = new ArrayList<>();
                if (arr[i] > arr[i-1]) {
                    t.add(arr[i-1]);
                    t.add(arr[i]);
                } else {
                    t.add(arr[i]);
                    t.add(arr[i-1]);
                }
                ans.add(t);
            }
        }

        return ans;
    }
}