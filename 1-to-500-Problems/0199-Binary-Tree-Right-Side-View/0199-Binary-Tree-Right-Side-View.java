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
  public List<Integer> rightSideView(TreeNode root) {
      List<Integer> ans = new ArrayList<>();
      Queue<TreeNode> q = new LinkedList<>();
      if (root == null) return ans;

      q.add(root);
      while(!q.isEmpty()) {
          int size = q.size();
          ans.add(q.peek().val);
          for (int i = 0; i < size; i++) {
              TreeNode t = q.poll();
              if (t.right != null) q.add(t.right);
              if (t.left != null) q.add(t.left);
          }
      }
      return ans;
  }
}