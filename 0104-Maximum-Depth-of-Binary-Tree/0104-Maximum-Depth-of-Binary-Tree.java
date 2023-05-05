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
  public int maxDepth(TreeNode root) {
      int depth = countDepth(root, 0);
      return depth;
  }

  public int countDepth(TreeNode root, int depth) {
      if (root == null) return depth;

      int l = countDepth(root.left, depth+1);
      int r = countDepth(root.right, depth+1);
      return Math.max(l, r);
  }
}