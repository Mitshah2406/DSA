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
    
    TreeNode f,s,p;
    public void inorder(TreeNode root) {
        if (root == null) {
            return;
        }

        inorder(root.left);
        if(p!=null && p.val>root.val && f==null){
            f = p;
            s = root;
        }else if(p!=null && p.val>root.val && f!=null){
            s= root;
        }
        p = root;
        inorder(root.right);
    }

    public void recoverTree(TreeNode root) {
        f= null;s=null; p=null;
        inorder(root);

        int t = f.val;
        f.val = s.val;
        s.val = t;
    }
}