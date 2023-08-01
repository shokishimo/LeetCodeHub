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
  TreeNode sub;
  public boolean isSubtree(TreeNode root, TreeNode subRoot) {
      if (subRoot == null) return true;
      if (root == null) return false;

      if (isSameTree(root, subRoot)) return true;
      
      return isSubtree(root.left, subRoot) || isSubtree(root.right, subRoot);
  }

  private boolean isSameTree(TreeNode root, TreeNode subRoot) {
      if (root == null && subRoot == null) return true;
      if (root == null || subRoot == null) return false;

      if (root.val != subRoot.val) return false;

      return isSameTree(root.left, subRoot.left) && isSameTree(root.right, subRoot.right);
  }
}

// resolve
class Solution {
    TreeNode sub;
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        if (subRoot == null) return true;
        if (root == null) return false;

        if (isSameTree(root, subRoot)) return true;
        return isSubtree(root.left, subRoot) ||
                isSubtree(root.right, subRoot);
    }

    private boolean isSameTree(TreeNode tree, TreeNode subTree) {
        if (tree == null && subTree == null) return true;
        if (tree == null || subTree == null || tree.val != subTree.val) return false;

        return isSameTree(tree.left, subTree.left) &&
                isSameTree(tree.right, subTree.right);
    }
}