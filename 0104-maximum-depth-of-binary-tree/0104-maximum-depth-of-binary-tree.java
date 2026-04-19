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
    int d = 0;
    public int maxDepth(TreeNode root) {
        if(root == null) return 0;

        depth(root, 1);
        return d;       
    }
     
    public void depth(TreeNode root, int count){
     if(root == null) return;
         
        d = Math.max(count, d);
        depth(root.left, count+1);
        depth(root.right, count+1);
         
    }
}