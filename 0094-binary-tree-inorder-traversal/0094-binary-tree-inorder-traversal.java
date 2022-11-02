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
    public List<Integer> inorderTraversal(TreeNode root) {
        ArrayList<Integer> ans = new ArrayList<>();
        if (root == null) return ans;
        travelBT(root, ans);
        return ans;
    }
    
    public static void travelBT(TreeNode root, ArrayList<Integer> ans)
    {
        // left
        if (root.left != null) {
            travelBT(root.left, ans);
        }
        // root node
        ans.add(root.val);
        // right
        if (root.right != null) {
            travelBT(root.right, ans);
        }
    }
}