/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
  public int kthSmallest(TreeNode root, int k) {
      PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> b - a);
      dfsSearch(root, k, pq);
      int res = pq.poll();
      return res;
  }

  private void dfsSearch(TreeNode root, int k, PriorityQueue<Integer> pq) {
      if (root == null) return;
      pq.add(root.val);
      if (pq.size() > k) pq.poll();
      dfsSearch(root.left, k, pq);
      dfsSearch(root.right, k, pq);
  }
}