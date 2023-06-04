class Solution {
  public boolean canFinish(int numCourses, int[][] prerequisites) {
      Node[] courses = new Node[numCourses];
      for (int i = 0; i < courses.length; i++) {
          courses[i] = new Node(i);
      }
      for (int i = 0; i < prerequisites.length; i++) {
          int[] one = prerequisites[i];
          courses[one[0]].prereq.put(one[1], courses[one[1]]);
      }

      Deque<Node> que = new ArrayDeque<>();
      int count = numCourses;
      while(count > 0) {
          for (Node each: courses) {
              if (!each.taken && each.prereq.size() == 0) {
                  que.add(each);
              }
          }
          if (que.size() == 0) return false;
      
          while(!que.isEmpty()) {
              Node t = que.poll();
              t.taken = true;
              for (Node each: courses) {
                  if (each.prereq.get(t.val) != null) {
                      each.prereq.remove(t.val);
                  }
              }
              count--;
          }
      }
      return true;
  }
}

class Node {
  int val;
  boolean taken;
  HashMap<Integer, Node> prereq;

  Node(int value) {
      val = value;
      taken = false;
      prereq = new HashMap<>();
  }
}

// more efficient solution
class Solution {
    HashMap<Integer, ArrayList<Integer>> map;
    HashSet<Integer> visited;
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        map = new HashMap<>();
        for (int i = 0; i < numCourses; i++) {
            map.put(i, new ArrayList<>());
        }
        for (int[] course: prerequisites) {
            map.get(course[0]).add(course[1]);
        }
        visited = new HashSet<>();

        for(int i = 0; i < numCourses; i++) {
            if (!dfs(i)) return false;
        }
        return true;
    }

    private boolean dfs(int cur) {
        if (visited.contains(cur)) return false;
        if (map.get(cur).size() == 0) return true;

        visited.add(cur);
        for (int each: map.get(cur)) {
            if (!dfs(each)) return false;
        }
        visited.remove(cur);
        map.get(cur).clear();
        return true;
    }
}