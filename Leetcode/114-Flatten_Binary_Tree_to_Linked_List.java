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
    // public TreeNode solve(TreeNode root) {
    // if (root == null) {
    // return null;
    // }
    // TreeNode rightTemp = root.right;
    // root.right = solve(root.left);
    // root.left = solve(rightTemp);

    // if(root.right!=null){
    // TreeNode temp = root.right;
    // while(temp.right!=null){
    // temp = temp.right;
    // }
    // temp.right = root.left;
    // }else{
    // root.right = root.left;
    // }
    // root.left=null;
    // return root;
    // }
    public TreeNode opt(TreeNode root) {
        if (root == null) {
            return null;
        }

        TreeNode lt = opt(root.left); // left tail
        TreeNode rt = opt(root.right); // right tail

        if(lt==null && rt==null){
            return root;
        }else if(lt==null && rt!=null){
            return rt;
        }else if(lt!=null && rt==null){
            root.right = root.left;
            root.left = null;
            return lt;
        }else{
            TreeNode rc = root.right;

            root.right = root.left;
            root.left = null;
            lt.right = rc;
            return rt;
        }
    }

    public void flatten(TreeNode root) {
        if (root == null || (root.left == null && root.right == null)) {
            return;
        }

        opt(root);
    }
}