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
  public List<List<Integer>> levelOrder(TreeNode root) {
      List<List<Integer>> ans = new ArrayList<>();
      if (root == null) return ans;
      Queue<TreeNode> que = new LinkedList<>();
      que.add(root);
      bfs(ans, que);
      return ans;
  }

  private void bfs(List<List<Integer>> ans, Queue<TreeNode> que) {
      int size = que.size();
      while(!que.isEmpty()) {
          ArrayList<Integer> temp = new ArrayList<>();
          for (int i = size; i > 0; i--) {
              TreeNode t = que.poll();
              temp.add(t.val);
              if (t.left != null) 
                  que.add(t.left);
              if (t.right != null)
                  que.add(t.right);
          }
          ans.add(temp);
          size = que.size();
      }
  }
}