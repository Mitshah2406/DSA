/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    /**
    Basic Preorder, First Include, Check target Sum == 0 if leaf node and and add path, then backtrack


Time complexity: O(N), where N is the number of nodes in the tree. Each node is visited once during the DFS traversal.

Space complexity: O(H) in the recursion stack plus O(H) for the path list, where H is the height of the tree. In the worst case (skewed tree), H = N, so space complexity becomes O(N). In a balanced tree, H = log N. Additional space for the result depends on the number of valid paths.
     */
    private void find(TreeNode root, int t, int currSum, List<Integer> path, List<List<Integer>> res) {
        if (root == null) {
            return;
        }
        path.add(root.val);
        currSum += root.val;
        if (root.left == null && root.right == null) {
            if (currSum == t) {
                res.add(new ArrayList<Integer>(path));
            }
        }

        find(root.left, t, currSum, path, res);
        find(root.right, t, currSum, path, res);
        path.remove(path.size() - 1);
        currSum-=root.val;

    }

    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> path = new ArrayList<>();

        find(root, targetSum, 0, path, res);
        return res;
    }
}