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
    // base case
      if (root == null || root == p || root == q) {
        return root;
      }

        // search in left & right
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);

        // if both sides return non-null → this is LCA
        if (left != null && right != null) {
            return root;
        }

        // otherwise return non-null one
        return (left != null) ? left : right;
    }
}