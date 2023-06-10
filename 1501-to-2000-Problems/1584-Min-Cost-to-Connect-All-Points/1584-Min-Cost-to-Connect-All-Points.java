class Solution {
    public int minCostConnectPoints(int[][] points) {
        int n = points.length;
        int[] par = new int[n];
        int[] rank = new int[n];
        for (int i = 0; i < n; i++) {
            rank[i] = 1;
            par[i] = i;
        }
        List<int[]> edges = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            for (int j = i+1; j < n; j++) {
                int weight = Math.abs(points[i][0] - points[j][0])
                        + Math.abs(points[i][1] - points[j][1]);
                int[] curEdge = {weight, i, j};
                edges.add(curEdge);
            }
        }
        Collections.sort(edges, (a, b) -> a[0] - b[0]);
        int minCost = 0;
        int edgesCon = 0;

        for (int i = 0; i < edges.size() && edgesCon < n-1; i++) {
            int posA = edges.get(i)[1];
            int posB = edges.get(i)[2];
            int weight = edges.get(i)[0];

            if (union(posA, posB, par, rank)) {
                minCost += weight;
                edgesCon++;
            }
        }
        return minCost;
    }

    private int find(int p, int[] par) {
        p = par[p];
        while(p != par[p]) {
            par[p] = par[par[p]];
            p = par[p];
        }
        return p;
    }

    private boolean union(int a, int b, int[] par, int[] rank) {
        int A = find(a, par);
        int B = find(b, par);

        if (A == B) return false;
        if (rank[A] >= rank[B]) {
            rank[A] += rank[B];
            par[B] = A;
        } else {
            rank[B] += rank[A];
            par[A] = B;
        }
        return true;
    }
}