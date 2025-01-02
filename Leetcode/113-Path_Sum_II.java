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
    private void preorder(TreeNode root, int sum, int target, ArrayList<Integer> arr, List<List<Integer>> paths) {
        if (root == null) {
            return;
        }
        sum += root.val;
        arr.add(root.val);
        if (sum == target && root.left == null && root.right == null) {
            paths.add(new ArrayList(arr));
        }
        preorder(root.left, sum, target, arr, paths);
        preorder(root.right, sum, target, arr, paths);
        arr.remove(arr.size() - 1);

    }

    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        // using preorder traversal
        // add sum of root & root to curr_path(arr) and pass to left and right
        // while coming back just ensure to remove root from curr_path(arr) and dont
        // subtract sum as it is passed as a value not a reference
        List<List<Integer>> paths = new ArrayList();
        preorder(root, 0, targetSum, new ArrayList(), paths);
        return paths;
    }
}