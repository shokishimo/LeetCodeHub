class Solution {
    public boolean validTree(int n, int[][] edges) {
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }

        for (int[] edge: edges) {
            graph.get(edge[0]).add(edge[1]);
            graph.get(edge[1]).add(edge[0]);
        }

        HashSet<Integer> visited = new HashSet<>();
        if (!dfs(graph, visited, 0, -1)) return false;
        if (visited.size() != n) return false;
        return true;
    }

    private boolean dfs(List<List<Integer>> graph, HashSet<Integer> visited, int cur, int prev) {
        visited.add(cur);

        for (int next: graph.get(cur)) {
            if (next == prev) continue;
            if (visited.contains(next)) return false;
            if (!dfs(graph, visited, next, cur)) return false;
        }
        return true;
    }
}