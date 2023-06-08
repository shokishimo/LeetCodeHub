// Solution 1, Using DFS, less efficient
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

// Solution 2, Using UnionFind, more effient
class Solution {
    public int countComponents(int n, int[][] edges) {
        int[] par = new int[n];
        int[] rank = new int[n];
        for (int i = 0; i < n; i++) {
            par[i] = i;
            rank[i] = 1;
        }

        for (int[] edge: edges) {
            union(edge[0], edge[1], par, rank);
        }
        int num = 0;
        for (int each: rank) {
            if (each != 0) num++;
        }

        return num;
    }

    private void union(int a, int b, int[] par, int[] rank) {
        int A = getPar(a, par);
        int B = getPar(b, par);

        if (A == B) return;
        if (rank[A] >= rank[B]) {
            rank[A] += rank[B];
            rank[B] = 0;
            par[B] = A;
        } else {
            rank[B] += rank[A];
            rank[A] = 0;
            par[A] = B;
        }
    }

    private int getPar(int p, int[] par) {
        p = par[p];

        while (p != par[p]) {
            par[p] = par[par[p]];
            p = par[p];
        }
        return p;
    }
}