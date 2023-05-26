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
  int unbalanced = -1;
  public boolean isBalanced(TreeNode root) {
      return (hightBalanceChecker(root) == -1)? false: true; 
  }

  private int hightBalanceChecker(TreeNode root) {
      if (root == null) return 0;

      int l = hightBalanceChecker(root.left);
      int r = hightBalanceChecker(root.right);
      if (l == unbalanced || r == unbalanced) return unbalanced;
      else if (l > r+1 || r > l+1) return unbalanced;

      return Math.max(l, r) + 1;
  }
}