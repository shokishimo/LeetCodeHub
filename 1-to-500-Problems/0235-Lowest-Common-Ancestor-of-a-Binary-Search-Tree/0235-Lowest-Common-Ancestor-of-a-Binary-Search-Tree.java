/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

 class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        TreeNode[] res = findLCA(root, p, q);
        return res[0];
    }

    private TreeNode[] findLCA(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) return new TreeNode[] {null, null, null};

        TreeNode[] left = findLCA(root.left, p, q);
        TreeNode[] right = findLCA(root.right, p, q);

        TreeNode[] cur = left;
        if (cur[0] == null && right[0] != null) cur[0] = right[0];
        if (cur[1] == null && right[1] != null) cur[1] = right[1];
        if (cur[2] == null && right[2] != null) cur[2] = right[2];

        if (cur[1] == null && root == p) cur[1] = root;
        if (cur[2] == null && root == q) cur[2] = root;
        if (cur[0] == null && cur[1] != null && cur[2] != null) cur[0] = root;
        
        return cur;
    }
}