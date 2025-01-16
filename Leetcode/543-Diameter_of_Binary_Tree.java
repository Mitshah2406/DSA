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
    static int longest = 0;
    public int findHeight(TreeNode root){
        if(root==null){
            return 0;
        }

        int x = findHeight(root.left);
        int y = findHeight(root.right);
        longest = Math.max(longest, (x+y+1)); // basically counting nodes only
        return Math.max(x,y)+1;
    }
    public int diameterOfBinaryTree(TreeNode root) {
        longest = 0;
        findHeight(root);
        return longest-1; // so idher se minus 1
    }
}