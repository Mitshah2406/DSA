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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();

        if (root == null) {
            return ans;
        }

        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);

        boolean isLeftToRight = true;
        while (q.size() != 0) {
            int size = q.size();

            List<Integer> tmp = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                TreeNode rem = q.poll();

                if(rem.left != null) {
                    q.add(rem.left);
                }

                if (rem.right != null) {
                    q.add(rem.right);
                }

                if(isLeftToRight){
                    tmp.add(rem.val);
                } else {
                    tmp.add(0, rem.val);
                }
            }

            isLeftToRight = !isLeftToRight;
            ans.add(tmp);
        }

        return ans;
    }
}