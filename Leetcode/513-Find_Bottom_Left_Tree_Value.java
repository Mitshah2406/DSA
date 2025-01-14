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

    // read question properly .... 

    public int findBottomLeftValue(TreeNode root) {

        // do a level order and keep rewriting first ele for every level
        if (root == null) {
            return -1;
        }
        Queue<TreeNode> q = new LinkedList();

        q.add(root);
        int first = -1;

        while (q.size() != 0) {
            int n = q.size();
            for (int i = 0; i < n; i++) {
                TreeNode rem = q.poll();
                if (i == 0)
                    first = rem.val;
                if (rem.left != null) {
                    q.add(rem.left);
                }
                if (rem.right != null) {
                    q.add(rem.right);
                }
            }

        }

        return first;
    }
}