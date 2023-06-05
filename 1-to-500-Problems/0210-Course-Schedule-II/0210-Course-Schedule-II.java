class Solution {
  public int[] findOrder(int numCourses, int[][] prerequisites) {
      int[] ans = new int[numCourses];
      int[] prereqCount = new int[numCourses];
      List<List<Integer>> courses = new ArrayList<>();
      for (int i = 0; i < numCourses; i++) {
          courses.add(new ArrayList<>());
      }
      for (int i = 0; i < prerequisites.length; i++) {
          int wantToTake = prerequisites[i][0];
          int mustTakeF = prerequisites[i][1];
          prereqCount[wantToTake]++;
          courses.get(mustTakeF).add(wantToTake);
      }
      Deque<Integer> q = new ArrayDeque<>();
      for (int i = 0; i < numCourses; i++) {
          if (prereqCount[i] == 0) q.add(i);
      }

      int taken = 0;
      int index = 0;
      while (!q.isEmpty()) {
          int takeNow = q.poll();
          taken++;
          ans[index++] = takeNow;
          for (int each: courses.get(takeNow)) {
              prereqCount[each]--;
              if (prereqCount[each] == 0) q.add(each);
          }
      }

      if (taken != numCourses) return new int[0];
      return ans;
  }
}