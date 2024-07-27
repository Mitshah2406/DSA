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
    static TreeNode f = null;
    static TreeNode s = null;
    static TreeNode p = null;

    private void inorder(TreeNode curr) {
        if (curr == null)
            return;

        inorder(curr.left);
        if (p != null) {
            if (curr.val < p.val && f == null) {
                f = p;
                s = curr;
            } else if (curr.val < p.val && f != null) {
                s = curr;
            }
        }
        p = curr;
        inorder(curr.right);
    }

    public void recoverTree(TreeNode root) {
        f = null;
        s = null;
        p = null;
        inorder(root);
        // System.out.println(f.val+ " "+ s.val);
        int temp = s.val;
        s.val = f.val;
        f.val = temp;
        // System.out.println(f.val+ " "+ s.val);

    }

    // public void inorder(TreeNode root, ArrayList<TreeNode> arr) {
    // if (root == null) {
    // return;
    // }

    // inorder(root.left, arr);
    // arr.add(root);
    // inorder(root.right, arr);

    // }

    // public void recoverTree(TreeNode root) {
    // ArrayList<TreeNode> arr = new ArrayList();
    // inorder(root, arr);
    // int ansIdx1 = -1;
    // int ansIdx2 = -1;
    // int count = 0;
    // int n = arr.size();
    // for (int i = 0; i < n - 1 && count!=2; i++) {
    // if (count == 0) {
    // if (arr.get(i).val > arr.get(i + 1).val) {
    // ansIdx1 = i;
    // ansIdx2 = i + 1;
    // count++;
    // }
    // }else{
    // if (arr.get(i).val > arr.get(i+1).val) {
    // ansIdx2 = i + 1;
    // count++;
    // }
    // }
    // }

    // int temp = arr.get(ansIdx1).val;
    // arr.get(ansIdx1).val = arr.get(ansIdx2).val;
    // arr.get(ansIdx2).val = temp;

    // }
}