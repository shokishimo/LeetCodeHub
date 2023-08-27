// resolve

// DFS Solution
class Solution {
    public int countComponents(int n, int[][] edges) {
        List<List<Integer>> theEdges = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            theEdges.add(new ArrayList<>());
        }
        for (int[] curEdge : edges) {
            theEdges.get(curEdge[0]).add(curEdge[1]);
            theEdges.get(curEdge[1]).add(curEdge[0]);
        }

        boolean[] visited = new boolean[n];
        int ans = 0;
        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                dfs(theEdges, visited, i);
                ans++;
            }
        }

        return ans;
    }

    private void dfs(List<List<Integer>> theEdges, boolean[] visited, int curInd) {
        if (visited[curInd]) return;

        visited[curInd] = true;
        for (int nextNode : theEdges.get(curInd)) {
            dfs(theEdges, visited, nextNode);
        }
    }
}



// // Union-Find Solution
class Solution {
    public int countComponents(int n, int[][] edges) {
        int[] par = new int[n];
        int[] rank = new int[n];
        for (int i = 0; i < n; i++) {
            par[i] = i;
            rank[i] = 1;
        }

        int res = n;
        for (int[] edge : edges) {
            if (union(edge[0], edge[1], par, rank)) res--;
        }
        return res;
    }

    private boolean union(int a, int b, int[] par, int[] rank) {
        int A = find(a, par);
        int B = find(b, par);

        if(A == B) return false;
        if (rank[A] > rank[B]) {
            rank[A] += rank[B];
            par[B] = A;
        } else {
            rank[B] += rank[A];
            par[A] = B;
        }
        return true;
    }

    private int find(int p, int[] par) {
        while(p != par[p]) {
            par[p] = par[par[p]];
            p = par[p];
        }
        return p;
    }
}