/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

class Solution {
    public static TreeNode lca(TreeNode root, TreeNode p, TreeNode q){
        if(root==null) return root;
        TreeNode l=null;
        TreeNode r=null;
        if(root.val>p.val && root.val>q.val){
            //  both on left side
            l= lca(root.left, p,q);
        }else if(root.val<p.val && root.val<q.val){
            //both on right side
            r= lca(root.right, p,q);
        }else{
            return root;
        }
        if(l!=null){
            return l;
        }else{
            return r;
        }
        // return root;
    }
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        return lca(root,p,q);
    }
}