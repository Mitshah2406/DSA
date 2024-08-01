/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public static TreeNode lca(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null)
            return root;
        if (root.val == p.val || root.val == q.val)
            return root;

        TreeNode l = lca(root.left, p, q);
        TreeNode r = lca(root.right, p, q);

       
            if (r != null && l != null) {
                return root;
            }
            if (l != null) {
                return l;
            } else if (r != null) {
                return r;
            }

            return null;
        
    }

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
            return lca(root, p, q);
    }
}