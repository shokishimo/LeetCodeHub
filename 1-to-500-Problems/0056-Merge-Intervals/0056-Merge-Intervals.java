// resolve
class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
        List<int[]> ans = new ArrayList<>();
        int[] newInterval = intervals[0];
        for (int i = 0; i < intervals.length; i++) {
            if (newInterval[1] < intervals[i][0]) {
                ans.add(newInterval);
                newInterval = intervals[i];
            } else {
                newInterval[1] = Math.max(newInterval[1], intervals[i][1]);
            }
        }
        ans.add(newInterval);
        return ans.toArray(new int[ans.size()][]);
    }
}