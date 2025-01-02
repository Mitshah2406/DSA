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
    private void inorder(List<Integer> arr, TreeNode root){
        if(root==null){
            return;
        }
        inorder(arr, root.left);
        arr.add(root.val);
        inorder(arr, root.right);
    }
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> arr = new ArrayList();
        inorder(arr, root);
        return arr;
    }
}