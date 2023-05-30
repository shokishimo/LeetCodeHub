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
  public boolean isValidBST(TreeNode root) {
      boolean left = isBST(root.left, Long.MIN_VALUE, root.val);
      boolean right = isBST(root.right, root.val, Long.MAX_VALUE);
      return left && right;
  }

  private boolean isBST(TreeNode node, long lower, long upper) {
      if (node == null) return true;

      if (!(lower < node.val && node.val < upper)) return false;
      boolean l = isBST(node.left, lower, node.val);
      boolean r = isBST(node.right, node.val, upper);
      return l && r;    
  }
}