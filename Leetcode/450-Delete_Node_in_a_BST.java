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
    public TreeNode findMax(TreeNode root) {
        if (root.right == null) {
            return root;
        }
        return findMax(root.right);
    }

    public TreeNode findMin(TreeNode root) {
        if (root.left == null) {
            return root;
        }
        return findMin(root.left);
    }

    public TreeNode solve(TreeNode root, int key) {
        if (root == null) {
            return null;
        }

        if (key < root.val) {
            root.left = solve(root.left, key);
        } else if (key > root.val) {
            root.right = solve(root.right, key);
        } else {
            // found

            // 4 possibility

            if (root.left == null && root.right == null) {
                return null;
            } else if (root.left != null && root.right == null) {
                return root.left;
            } else if (root.left == null && root.right != null) {
                return root.right;
            } else {
                // both childs present
                // go to left ka max make it root delete that max return root by connecting
                // deleted part
                // TreeNode max = findMax(root.left);
                // root.val = max.val;
                // root.left = solve(root.left, max.val);
                // return root;
                // go to right ka min make it root delete that min return root by connecting
                // deleted part
                // TreeNode min = findMin(root.right);
                // root.val = min.val;
                // root.right = solve(root.right, min.val);
                // return root;

                // go to left ka max connect the max ka right to root ka right and return root ka left
                // TreeNode max = findMax(root.left);
                // max.right = root.right;

                // return root.left;

                // go to right ka min connect the min ka left to root ka left and return root ka right
                TreeNode min = findMin(root.right);
                min.left = root.left;

                return root.right;

            }
        }

        return root;
    }

    public TreeNode deleteNode(TreeNode root, int key) {
        return solve(root, key);
    }
}