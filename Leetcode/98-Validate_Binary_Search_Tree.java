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
    public static int max = 0;
    public static boolean valid = true;

    public static void inorder(TreeNode root, ArrayList<Integer> arr) {
        if (root == null)
            return;

        inorder(root.left, arr);
        if (arr.size() <1) {
            max = root.val;
            arr.add(root.val);
        } else {
            if (max >= root.val) {
                valid = false;
                return;
            } else {
                max = root.val;
                arr.add(root.val);
            }
        }
        inorder(root.right, arr);

    }

    public boolean isValidBST(TreeNode root) {
        valid = true;
        max = 0;
        ArrayList<Integer> arr = new ArrayList<>();
        inorder(root, arr);
        // for (int i = 0; i < arr.size() - 1; i++) {
        //     if (arr.get(i) >= arr.get(i + 1)) {
        //         valid = false;
        //         break;
        //     }
        // }

        return valid;
    }
}