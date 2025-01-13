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
    // 1. Both approaches are close to optimal
    // 1st approach is like compare left subtree ka max should be smaller than root
    // and right subtree ka min should be greater than root

    // tc - O(n), sc- O(h)
    // static boolean valid = true;

    // public int[] valid(TreeNode root) {
    //     int min = root.val;
    //     int max = root.val;

    //     if (valid && root.left != null) {
    //         int[] l = valid(root.left);
    //         min = Math.min(min, l[0]);
    //         if (!(l[1] < root.val)) {
    //             valid = false;
    //         }
    //     }
    //     if (valid && root.right != null) {
    //         int[] r = valid(root.right);
    //         max = Math.max(max, r[1]);
    //         if (!(r[0] > root.val)) {
    //             valid = false;
    //         }
    //     }

    //     return new int[] { min, max };
    // }

    // public boolean isValidBST(TreeNode root) {
    //     valid = true;
    //     int arr[] = valid(root);
    //     return valid;
    // }

    // 2. more optimal
    // tc - o(n), sc - O(h)

    public boolean valid(TreeNode root, long min, long max) {
        if (root == null)
            return true;
        long val = root.val;
        if (val > max || val < min) {
            return false;
        }

        boolean l = valid(root.left, min, val - 1);
        boolean r = valid(root.right, val + 1, max);

        if (l == false || r == false) {
            return false;
        }

        return true;
    }

    public boolean isValidBST(TreeNode root) {
        long min = Long.MIN_VALUE;
        long max = Long.MAX_VALUE;

        return valid(root, min, max);
    }
}