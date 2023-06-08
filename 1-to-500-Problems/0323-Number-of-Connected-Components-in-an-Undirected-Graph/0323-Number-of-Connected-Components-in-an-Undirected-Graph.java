// Solution 1
class Solution {
    List<List<Integer>> graph;
    HashSet<Integer> visited;
    public int countComponents(int n, int[][] edges) {
        graph = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>(i));
        }
        for (int[] edge: edges) {
            graph.get(edge[0]).add(edge[1]);
            graph.get(edge[1]).add(edge[0]);
        }
        visited = new HashSet<>();
        int count = 0;
        for (int i = 0; i < n; i++) {
            if (!visited.contains(i)) {
                dfs(i);
                count++;
            }
        }
        return count;
    }

    private void dfs(int cur) {
        visited.add(cur);
        for (int next: graph.get(cur)) {
            if (!visited.contains(next)) dfs(next);
        }
    }
}

// Solution 2