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
    public TreeNode findLCA(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) {
            return root;
        }
        if (root == p || root == q) {
            return root;
        }
        TreeNode l = findLCA(root.left, p, q);
        TreeNode r = findLCA(root.right, p, q);

        if (l != null && r != null) {
            return root; // lca
        }

        if (l != null) {
            return l;
        }
        if (r != null) {
            return r;
        }

        return null;
    }

    public TreeNode findLCABST(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) {
            return root;
        }
        if (root == p || root == q) {
            return root;
        }
        TreeNode l = null;
        TreeNode r = null;
        if (root.val > p.val && root.val > q.val) {
            l = findLCABST(root.left, p, q);
        } else if (root.val < p.val && root.val < q.val) {
            r = findLCABST(root.right, p, q);
        } else {
            l = findLCABST(root.left, p, q);
            r = findLCABST(root.right, p, q);

        }

        if (l != null && r != null) {
            return root; // lca
        }

        if (l != null) {
            return l;
        }
        if (r != null) {
            return r;
        }

        return null;
    }

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {

        // same lca code for bt
        // return findLCA(root,p,q);

        // use bst property with recursion
        // return findLCABST(root, p, q);

        // use basic logic of bst for iterative approach
        while (true) {
            if (root.val > p.val && root.val > q.val) {
                root = root.left; // go left acc to bst
            } else if (root.val < p.val && root.val < q.val) {
                root = root.right; // go right acc to bst
            } else {
                return root; // return node itself as both p q are in diff branches of it so it is itself the
                             // lcs
            }
        }

    }
}