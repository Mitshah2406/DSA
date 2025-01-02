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
    private void postorder(List<Integer> arr, TreeNode root){
        if(root==null){
            return;
        }
        postorder(arr, root.left);
        postorder(arr, root.right);
        arr.add(root.val);
    }
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> arr = new ArrayList();
        postorder(arr, root);
        return arr;
    }
}