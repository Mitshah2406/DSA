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
    private TreeNode lca(TreeNode root, int p, int q) {
        // getting the lowest common ancestor of both soruce and dest
        if (root == null || root.val == p || root.val == q) {
            return root;
        }
        TreeNode left = lca(root.left, p, q);
        TreeNode right = lca(root.right, p, q);

        if (left == null) {
            return right;
        } else if (right == null) {
            return left;
        }

        return root;
    }

    private boolean findPath(TreeNode root, StringBuilder path, int target) {
        // finding path for each i.e source and dest from lca as root
        if (root == null)
            return false;
        if (root.val == target)
            return true;
        // going left
        path.append("L");
        if (findPath(root.left, path, target)) {
            // if target got return true
            return true;
        }
        // otherwise remove "L" direction
        path.setLength(path.length() - 1);
        // going right
        path.append("R");
        if (findPath(root.right, path, target)) {
            // otherwise remove "R" direction
            return true;
        }
        // otherwise remove "R" direction
        path.setLength(path.length() - 1);

        // if node is not in curr subtree i.e root ke left subtree and right subtree
        // then return false
        return false;

    }

    public String getDirections(TreeNode root, int startValue, int destValue) {
        // finding the lca for src,dest
        TreeNode ca = lca(root, startValue, destValue);
        StringBuilder path = new StringBuilder();
        if (findPath(ca, path, startValue)) {
            // remove the length of path that we got for source as "L" and add respective
            // length of "U"
            int n = path.length();
            // removing length of L's recieved
            path.setLength(n - n);
            for (int i = 0; i < n; i++) {
                // adding that much length of U coz we always go "U" from src
                path.append("U");
            }
        }

        if (findPath(ca, path, destValue)) {
            // simply return
            return path.toString();
        }
        return path.toString();
    }
}