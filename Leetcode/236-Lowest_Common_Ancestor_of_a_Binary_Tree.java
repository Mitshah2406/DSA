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
    // static TreeNode ans = null;

    // public boolean[] postorder(TreeNode root, TreeNode p, TreeNode q) {
    // if (root == null) {
    // return new boolean[] { false, false };
    // }

    // boolean l[] = postorder(root.left, p, q);
    // boolean r[] = postorder(root.right, p, q);

    // boolean res[] = new boolean[2];
    // if (root == p) {
    // res[0] = true;
    // } else if (root == q) {
    // res[1] = true;
    // }
    // res[0] = res[0] || l[0] || r[0];
    // res[1] = res[1] || l[1] || r[1];
    // if (res[0] && res[1] == true) {
    // ans = root;
    // return new boolean[] { false, false };
    // }
    // return res;

    // }

    // public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
    // ans = null;
    // postorder(root, p, q);
    // return ans;
    // }


    // optimal using less space
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
            return root;
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
        return findLCA(root, p, q);
    }
}