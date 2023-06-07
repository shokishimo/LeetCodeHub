class Solution {
  public int[] findRedundantConnection(int[][] edges) {
      int n = edges.length;
      int[] ranks = new int[n+1];
      int[] par = new int[n+1];
      for (int i = 1; i <= n; i++) {
          par[i] = i;
          ranks[i] = 1;
      }
      
      int[] ans = new int[2];
      for (int i = 0; i < n; i++) {
          if (union(ranks, par, edges[i][0], edges[i][1], ans)) return ans;
      }
      return new int[0];
  }
  
  private int find(int p, int[] par) {
      p = par[p];
      while (p != par[p]) {
          par[p] = par[par[p]];
          p = par[p];
      }
      return p;
  }

  private boolean union(int[] ranks, int[] par, int a, int b, int[] ans) {
      int A = find(a, par);
      int B = find(b, par);
      if (A == B) {
          if (a < b) {
              ans[0] = a;
              ans[1] = b;
          } else {
              ans[0] = b;
              ans[1] = a;
          }
          return true;
      }
      if (ranks[A] >= ranks[B]) {
          ranks[A] += ranks[B];
          par[B] = par[A];
      } else {
          ranks[B] += ranks[A];
          par[B] = par[A];
      }
      return false;
  }
}