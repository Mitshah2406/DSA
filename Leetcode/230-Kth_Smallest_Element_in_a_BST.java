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
    static int count = 0;
    static int ans = -1;

    public void inorder(TreeNode root, int k) {
        if (root == null) {
            return;
        }
        if(ans!=-1) return;
        inorder(root.left, k);
        count++;
        if (count == k) {
            ans = root.val;
            return;
        }
        inorder(root.right, k);
    }

    public int kthSmallest(TreeNode root, int k) {
        count = 0;
        ans = -1;
        inorder(root, k);
        return ans;
    }
}