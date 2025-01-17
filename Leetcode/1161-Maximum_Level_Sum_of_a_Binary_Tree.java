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
    public int maxLevelSum(TreeNode root) {
        Queue<TreeNode> q = new LinkedList();
        q.add(root);
        int level = 1;
        int max = Integer.MIN_VALUE;
        int ans = -1;
        while (q.size() != 0) {
            int n = q.size();
            int sum = 0;
            for (int i = 0; i < n; i++) {
                TreeNode rem = q.poll();
                sum += rem.val;

                if (rem.left != null)
                    q.add(rem.left);
                if (rem.right != null)
                    q.add(rem.right);
            }
            if (max < sum) {
                ans = level;
                max = sum;
            }
             level++;
        }
        return ans;
    }
}