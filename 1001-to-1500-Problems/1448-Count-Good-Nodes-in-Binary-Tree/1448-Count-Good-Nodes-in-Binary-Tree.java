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
  public int goodNodes(TreeNode root) {
      int res = dfs(root, Integer.MIN_VALUE);
      return res;
  }

  private int dfs(TreeNode root, int max) {
      int count = 0;
      if (root == null) return count;
      if (root.val >= max) {
          max = root.val;
          count++;
      }
      if (root.left != null) count += dfs(root.left, max);
      if (root.right != null) count += dfs(root.right, max);
      return count;
  }
}