/*
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
  int diameter;
  public int diameterOfBinaryTree(TreeNode root) {
      diameter = 0;
      dfs(root);
      return diameter;
  }

  private int dfs(TreeNode root) {
      if (root == null) return 0;

      int l = dfs(root.left);
      int r = dfs(root.right);

      diameter = Math.max(diameter, l+r);

      return Math.max(l, r) + 1;
  }
}

// resolve
class Solution {
    int diameter = 0;
    public int diameterOfBinaryTree(TreeNode root) {
        int height = dfs(root);
        return diameter;
    }

    private int dfs(TreeNode root) {
        if (root == null) return 0;

        int left = dfs(root.left);
        int right = dfs(root.right);

        diameter = Math.max(diameter, left + right);
        return Math.max(left+1, right+1);
    }
}