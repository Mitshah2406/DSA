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

    // kadande algo wont work
    // static int sum = 0;
    // static int max = Integer.MIN_VALUE;
    // public void inorder(TreeNode root){
    // if(root==null){
    // return;
    // }

    // inorder(root.left);
    // sum+=root.val;
    // max = Math.max(sum, max);
    // if(sum<=0){
    // sum = 0;
    // }
    // inorder(root.right);
    // }

    static int max = Integer.MIN_VALUE;

    public int postorder(TreeNode root) {
        if (root == null) {
            return 0;
        }
        // for each node first consider a V shaped path that is calc left+right+self
        int l = Math.max(0, postorder(root.left)); // just dont consider neg paths (No fayda)
        int r = Math.max(0, postorder(root.right)); // as we dont condier neg values in kadanes same as that
        // happening here (V shape)
        max = Math.max(max, root.val + l + r);

        // while returning return self + either(left/right) one of the two which is max
        // because the the other path for V will be of the root node where this function
        // is returning

        // draw tree and try

        // src - Striver = https://www.youtube.com/watch?v=WszrfSwMz58
        return root.val + Math.max(l, r);
    }

    public int maxPathSum(TreeNode root) {
        max = Integer.MIN_VALUE;
        // calc
        postorder(root);
        return max;
    }
}