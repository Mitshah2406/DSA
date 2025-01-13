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
    public TreeNode search(TreeNode root, int val) {
        if (root == null || root.val == val) {
            return root;
        }
        TreeNode ans = null;
        if (val < root.val) {
            ans = search(root.left, val);
        }
        if (val > root.val) {
            ans = search(root.right, val);
        }
        return ans;
    }

    public TreeNode searchBST(TreeNode root, int val) {
        // use BST property for searching

        // all nodes lesser than root are on left, greater are on right
        return search(root, val);
    }
}