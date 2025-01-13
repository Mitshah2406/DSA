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
    static TreeNode right = null;
    static TreeNode left = null;

    public void findPosToInsert(TreeNode root, int val) {
        if (root.val < val) {
            if (root.right == null) {
                right = root;
                return;
            }
            findPosToInsert(root.right, val);
        }
        if (root.val > val) {
            if (root.left == null) {
                left = root;
                return;
            }
            findPosToInsert(root.left, val);
        }
    }

    public TreeNode insertIntoBST(TreeNode root, int val) {
        right=null;
         left = null;
        TreeNode nn = new TreeNode(val);
        if(root==null){
            return nn;
        }
        findPosToInsert(root,val);
        if(left==null){
            right.right = nn;
        }
        if(right==null){
            left.left = nn;
        }
        return root;
    }
}