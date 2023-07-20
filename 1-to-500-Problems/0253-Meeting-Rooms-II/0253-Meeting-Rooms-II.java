class Solution {
    public int minMeetingRooms(int[][] intervals) {
        int[] starts = new int[intervals.length];
        int[] ends = new int[intervals.length];
        for (int i = 0; i < intervals.length; i++) {
            starts[i] = intervals[i][0];
            ends[i] = intervals[i][1];
        }

        Arrays.sort(starts);
        Arrays.sort(ends);

        int s = 0;
        int e = 0;
        int res = 0;
        int count = 0;
        while (s < starts.length) {
            if (starts[s] < ends[e]) {
                count++;
                res = Math.max(res, count);
                s++;
            } else {
                count--;
                e++;
            }
        }

        return res;
    }
}