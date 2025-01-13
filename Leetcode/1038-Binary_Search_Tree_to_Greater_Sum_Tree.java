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
    // brute force
    // static int sum = 0;
    // public void inorder(TreeNode root){
    // if(root==null){
    // return;
    // }
    // inorder(root.left);
    // sum+=root.val;
    // inorder(root.right);
    // }
    // public void inorder1(TreeNode root){
    // if(root==null){
    // return;
    // }
    // inorder1(root.left);
    // sum-=root.val;
    // root.val+=sum;
    // inorder1(root.right);
    // }
    // public TreeNode bstToGst(TreeNode root) {
    // sum = 0;
    // inorder(root);
    // inorder1(root);
    // return root;

    // }

    // optimal - go right to left do dry run
    static int sum = 0;
    public void inorder(TreeNode root) {
        if (root == null) {
            return;
        }
        inorder(root.right);
        sum += root.val;
        root.val = sum;
        inorder(root.left);
    }

    public TreeNode bstToGst(TreeNode root) {
        sum = 0;
        inorder(root);
        return root;
    }
}