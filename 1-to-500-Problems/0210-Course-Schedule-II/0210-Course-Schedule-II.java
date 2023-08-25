class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        List<List<Integer>> nextCourses = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) {
            nextCourses.add(new ArrayList<>());
        }
        int[] prereqCount = new int[numCourses];
        for (int[] eachPre : prerequisites) {
            nextCourses.get(eachPre[1]).add(eachPre[0]);
            prereqCount[eachPre[0]]++;
        }

        Deque<Integer> nextStartPos = new LinkedList<>();
        for (int i = 0; i < prereqCount.length; i++) {
            if (prereqCount[i] == 0) nextStartPos.add(i);
        }

        int[] ans = new int[numCourses];
        int ind = 0;
        int taken = 0;
        while (!nextStartPos.isEmpty()) {
            int curCourse = nextStartPos.poll();
            ans[ind++] = curCourse;
            taken++;

            for (int nextCourse : nextCourses.get(curCourse)) {
                prereqCount[nextCourse]--;
                if (prereqCount[nextCourse] == 0)
                    nextStartPos.add(nextCourse);
            }
        }

        return (taken == numCourses)? ans : new int[]{};
    }
}