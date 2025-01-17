/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode() {}
 * TreeNode(int val) { this.val = val; }
 * TreeNode(int val, TreeNode left, TreeNode right) {
 * this.val = val;
 * this.left = left;
 * this.right = right;
 * }
 * }
 */
class Solution {
    TreeNode idx1;
    TreeNode idx2;
    TreeNode prev;

    public void solve(TreeNode root){
        if(root == null) return;

        solve(root.left);

        // Here, prev acts as a (i) and cur act as (i+1)
        if(prev != null && root.val < prev.val && idx1 == null){
            idx1 = prev;
            idx2 = root; 
        }else if(prev != null && root.val < prev.val && idx1 != null){
            idx2 = root; 
        }

        // We are not moving root as it is done by recurion
        prev = root;
        solve(root.right);
    }

    public void recoverTree(TreeNode root) {
        prev = null;
        idx1 = null;
        idx2 = null;

        solve(root);

        int tmp = idx1.val;
        idx1.val = idx2.val;
        idx2.val = tmp;
    }
}