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
    public void preorder(List<Integer> arr, TreeNode root) {
        if (root == null) {
            return;
        }
        arr.add(root.val);
        preorder(arr, root.left);
        preorder(arr, root.right);
    }

    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> arr = new ArrayList();

        // preorder(arr, root);

        // morris (preorder - node,left,right)

        TreeNode curr = root;
        while (curr != null) {

            if (curr.left == null) {
                // if left is null process node and go right
                arr.add(curr.val);
                curr = curr.right;
            } else {
                // if left is non null
                TreeNode currp1 = curr.left;

                while (currp1.right != null && currp1.right != curr) {
                    currp1 = currp1.right;
                }

                if (currp1.right == null) {
                    // if first time then print root(curr) & establish link and then move curr to left
                    currp1.right = curr;
                    arr.add(curr.val);
                    curr = curr.left;
                } else {
                    // if second time print node, destroy link, move to right

                    currp1.right = null;
                    curr = curr.right;
                }
            }
        }
        return arr;

    }
}