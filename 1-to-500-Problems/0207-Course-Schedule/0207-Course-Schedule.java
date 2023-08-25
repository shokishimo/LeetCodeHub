class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<List<Integer>> prereq = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) {
            prereq.add(new ArrayList<>());
        }

        int[] taken = new int[numCourses];
        for (int[] eachPre : prerequisites) {
            prereq.get(eachPre[1]).add(eachPre[0]);
            taken[eachPre[0]]++;
        }

        Deque<Integer> starts = new LinkedList<>();
        for (int i = 0; i < taken.length; i++) {
            if (taken[i] == 0) starts.add(i);
        }

        int numTaken = 0;
        while (!starts.isEmpty()) {
            int ind = starts.poll();
            numTaken++;
            for (int nextCourseInd : prereq.get(ind)) {
                taken[nextCourseInd]--;
                if (taken[nextCourseInd] == 0)
                    starts.add(nextCourseInd);
            }
        }

        return numTaken == numCourses;
    }
}