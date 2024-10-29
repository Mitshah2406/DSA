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
    public TreeNode solve(TreeNode root) {
        if (root == null) {
            return null;
        }
        TreeNode rightTemp = root.right;
        root.right = solve(root.left);
        root.left = solve(rightTemp);

        if(root.right!=null){
            TreeNode temp = root.right;
            while(temp.right!=null){
                temp = temp.right;
            }
            temp.right = root.left;
        }else{
            root.right = root.left;
        }
        root.left=null;
        return root;
    }

    public void flatten(TreeNode root) {
        if (root == null || (root.left == null && root.right == null)) {
            return;
        }

        solve(root);
    }
}